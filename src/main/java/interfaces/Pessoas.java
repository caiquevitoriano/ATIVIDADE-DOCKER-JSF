/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.io.Serializable;
import java.util.List;
import modelo.CPF;
import modelo.Pessoa;

/**
 *
 * @author caique
 */
public interface Pessoas extends Serializable {    
    
    void nova(Pessoa pessoa);

    List<Pessoa> todas() ;

    void excluir(Pessoa pessoa);

    void atualizar(Pessoa pessoa);

    Pessoa buscar(CPF cpf);

    List<Pessoa> buscar(String cpf);
}

