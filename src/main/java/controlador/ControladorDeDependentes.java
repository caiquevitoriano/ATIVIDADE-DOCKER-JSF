/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import interfaces.Dependentes;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import modelo.Dependente;

/**
 *
 * @author caique
 */

@ViewScoped
@Named
public class ControladorDeDependentes implements Serializable{
    
    private Dependente dependente = new Dependente();
    private List<Dependente> todosOsDependentes;

    @Inject
    private Dependentes service;

    @PostConstruct
    private void init(){
        atualizarLista();
    }
    
    

    public String salvar(){
        service.novo(dependente);
        dependente = new Dependente();
        atualizarLista();
        return "";
    }

    private void atualizarLista() {
        this.todosOsDependentes = service.todosOsDepentendes();
    }

    public String atualizar(){
        service.atualizar(dependente);
        atualizarLista();
        return "";
    }

    public String editar(Dependente dependente){
        this.dependente = dependente;
        return "";

    }

    public String excluir(Dependente dependente){
        service.excluir(dependente);
        atualizarLista();
        return "";
    }

    public List<Dependente> getTodosOsDependentes() {
        return todosOsDependentes;
    }

    public void setTodosOsDependentes(List<Dependente> todosOsDependentes) {
        this.todosOsDependentes = todosOsDependentes;
    }

    public Dependente getDependente() {
        return dependente;
    }

    public void setDependente(Dependente dependente) {
        this.dependente = dependente;
    }

    
}
