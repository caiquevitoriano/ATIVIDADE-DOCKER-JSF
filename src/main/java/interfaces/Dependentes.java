/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.io.Serializable;
import java.util.List;
import modelo.Dependente;

/**
 *
 * @author caique
 */
public interface Dependentes extends Serializable{
    
     public void novo(Dependente dependente);

    public List<Dependente> todos() ;

    public void excluir(Dependente dependente);

    public void atualizar(Dependente dependente);
    
    public Dependente localizarDependenteComId(String uuid);

    public List<Dependente> todosOsDepentendes();
    
}
