/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author caique
 */
public class Dependente {
    
    private String uuid;
    private String nome;
    private LocalDate dataDeNascimento;
    
    public Dependente() {
    }

    public Dependente(String uuid, String nome, LocalDate dataDeNascimento) {
        this(nome, dataDeNascimento);
        this.uuid = uuid;
    }

    public Dependente(String nome, LocalDate dataDeNascimento) {
        this.nome = nome;
        this.dataDeNascimento = dataDeNascimento;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(LocalDate dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public boolean naoValido() {
        return nomeVazio() || nascimentoAnterior();
    }

    public boolean nomeVazio() {
        return this.nome == null || this.nome.trim().equals("");
    }

    public boolean nascimentoAnterior() {
        return this.dataDeNascimento == null
                || this.dataDeNascimento.isEqual(LocalDate.now())
                || this.dataDeNascimento.isAfter(LocalDate.now());
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.uuid);
        hash = 89 * hash + Objects.hashCode(this.nome);
        hash = 89 * hash + Objects.hashCode(this.dataDeNascimento);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Dependente other = (Dependente) obj;
        if (!Objects.equals(this.uuid, other.uuid)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.dataDeNascimento, other.dataDeNascimento)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Dependente{" + "uuid=" + uuid + ", nome=" + nome + ", dataDeNascimento=" + dataDeNascimento + '}';
    }
    

    
}
