/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import interfaces.Pessoas;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import modelo.CPF;
import modelo.Pessoa;

/**
 *
 * @author caique
 */

@SessionScoped
@Named
public class ControladorDePessoa implements Serializable{
        
        
    private Pessoa pessoa = new Pessoa();
    private List<Pessoa> todasAsPessoas;
    private String cpf;


    @Inject
    private Pessoas service;
    
        public String salvar() {
        this.service.nova(pessoa);
        this.pessoa = new Pessoa();
        atualizar();
        return null;
    }

    public String atualizar() {
        this.service.atualizar(pessoa);
        this.pessoa = new Pessoa();
        return "list.xhtml?faces-redirect=true";
    }

    public String excluir(Pessoa pessoa) {
        this.service.excluir(pessoa);
        return null;
    }

    public String editar(Pessoa pessoa) {
        this.pessoa = pessoa;
        return "edit.xhtml";
    }
    
    public String buscar() {
    	this.pessoa = service.buscar(pessoa.getCpf());
    	return "edit.xhtml";
    }
    
    public List<Pessoa> getTodasAsPessoas() {
        return this.service.todas();
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Pessoas getService() {
        return service;
    }

    public void setService(Pessoas service) {
        this.service = service;
    }
    
    
    
    
}
