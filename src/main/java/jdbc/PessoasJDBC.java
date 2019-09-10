/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

import interfaces.Pessoas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import modelo.CPF;
import modelo.Dependente;
import modelo.Pessoa;

/**
 *
 * @author caique
 */

@Stateless
public class PessoasJDBC implements Pessoas {

    @Resource(name = "java:app/dac")
    private DataSource dataSource;
    private Connection connection;

    private Logger log = Logger.getLogger(this.getClass().getName());
    private String uuid;

    @PostConstruct
    private void init() {
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            log.log(Level.SEVERE, "Erro ao conectar");
            e.printStackTrace();
        }
    }

    @Override
    public void nova(Pessoa pessoa) {
        String sql = "INSERT INTO pessoa (cpf, nome, id_dependente) VALUES (?, ?, ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, pessoa.getCpf().valor());
            ps.setString(2, pessoa.getNome());
            if (pessoa.getDependente() != null) {
                ps.setString(3, pessoa.getDependente().getUuid());
            } else {
                ps.setString(3, null);
            }
            ps.execute();
        } catch (SQLException e) {
            log.log(Level.SEVERE, "Deu erro ao salvar");
            e.printStackTrace();
        }
    }

    @Override
    public List<Pessoa> todas() {
        String sql = "SELECT * FROM pessoa";
        List<Pessoa> pessoas = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                pessoas.add(construirPessoa(resultSet));
            }
        } catch (SQLException e) {
            log.log(Level.SEVERE, "Deu erro ao listar");
            e.printStackTrace();
        }
        return pessoas;
    }

    @Override
    public void excluir(Pessoa pessoa) {
        String sql = "DELETE FROM pessoa WHERE cpf = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, pessoa.getCpf().valor());
            ps.executeUpdate();
        } catch (SQLException e) {
            log.log(Level.SEVERE, "Deu erro ao excluir");
            e.printStackTrace();
        }
    }

    @Override
    public void atualizar(Pessoa pessoa) {
        String sql = "UPDATE pessoa SET nome = ?, id_dependente = ? WHERE cpf = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, pessoa.getNome());
            if (pessoa.getDependente() != null) {
                ps.setString(2, pessoa.getDependente().getUuid());
            } else {
                ps.setString(2, null);
            }
            ps.setString(3, pessoa.getCpf().valor());
            ps.executeUpdate();
        } catch (SQLException e) {
            log.log(Level.SEVERE, "Deu erro ao atualizar");
            e.printStackTrace();
        }
    }

    @Override
    public Pessoa buscar(CPF cpf) {
        String sql = "SELECT * FROM pessoa WHERE cpf = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, cpf.valor());
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                return construirPessoa(resultSet);
            }
        } catch (SQLException e) {
            log.log(Level.SEVERE, "Deu erro ao buscar");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Pessoa> buscar(String cpf) {
        String sql = "SELECT * FROM pessoa WHERE cpf LIKE ?";
        List<Pessoa> pessoas = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, "%" + cpf + "%");
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                pessoas.add(construirPessoa(resultSet));
            }
        } catch (SQLException e) {
            log.log(Level.SEVERE, "Deu erro ao buscar com regex");
            e.printStackTrace();
        }
        return pessoas;
    }

    private Pessoa construirPessoa(ResultSet resultSet) throws SQLException {
        Pessoa pessoa = new Pessoa();
        pessoa.setCpf(new CPF(resultSet.getString("cpf")));
        pessoa.setNome(resultSet.getString("nome"));
        pessoa.setDependente(buscarDependente(resultSet.getString("id_dependente")));
        return pessoa;
    }

    private Dependente buscarDependente(String string) throws SQLException {
        String sql = "SELECT * FROM dependente WHERE uuid = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, uuid);
        ResultSet resultSet = ps.executeQuery();
        if (resultSet.next()) {
            return new Dependente(
                    resultSet.getString("uuid"),
                    resultSet.getString("nome"),
                    resultSet.getDate("dataNascimento").toLocalDate()
            );
        }
        return null;
    }

}
