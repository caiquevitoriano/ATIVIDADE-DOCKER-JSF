/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memoria;

import interfaces.Dependentes;
import java.util.ArrayList;
import java.util.List;
import modelo.Dependente;

/**
 *
 * @author caique
 */
public class DependenteEmMemoria implements Dependentes {

    private final List<Dependente> dependentes = new ArrayList<>();

    @Override
    public void novo(Dependente dependente) {
        dependentes.add(dependente);
    }

    @Override
    public List<Dependente> todos() {
        return dependentes;
    }

    @Override
    public void excluir(Dependente dependente) {
        dependentes.remove(dependente);
    }

    @Override
    public void atualizar(Dependente dependente) {
        dependentes.remove(dependente);
        dependentes.add(dependente);
    }

    @Override
    public Dependente localizarDependenteComId(String uuid) {
        for (Dependente d : dependentes) {
            if (d.getUuid().equals(uuid)) {
                return d;
            }
        }
        return null;
    }

    @Override
    public List<Dependente> todosOsDepentendes() {
        return dependentes;
    }

}
