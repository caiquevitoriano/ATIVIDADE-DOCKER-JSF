/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memoria;

import interfaces.Pessoas;
import java.util.ArrayList;
import java.util.List;
import modelo.CPF;
import modelo.Pessoa;

/**
 *
 * @author caique
 */
public class PessoasEmMemoria implements Pessoas {

    private final List<Pessoa> pessoas = new ArrayList<>();

    private static PessoasEmMemoria instance = null;

    public static PessoasEmMemoria getInstance() {
        if (instance == null) {
            synchronized (PessoasEmMemoria.class) {
                if (instance == null) {
                    instance = new PessoasEmMemoria();
                }
            }
        }
        return instance;
    }

    @Override
    public void nova(Pessoa pessoa) {
        pessoas.add(pessoa);

    }

    @Override
    public List<Pessoa> todas() {
        return pessoas;
    }

    @Override
    public void excluir(Pessoa pessoa) {
        pessoas.remove(pessoa);
    }

    @Override
    public void atualizar(Pessoa pessoa) {
        pessoas.remove(pessoa);
        pessoas.add(pessoa);
    }

    @Override
    public Pessoa buscar(CPF cpf) {
        return null;
    }

    @Override
    public List<Pessoa> buscar(String cpf) {
        return null;
    }

}
