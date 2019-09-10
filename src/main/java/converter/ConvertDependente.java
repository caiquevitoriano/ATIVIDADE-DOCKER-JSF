/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import interfaces.Dependentes;
import javax.enterprise.inject.spi.CDI;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import modelo.Dependente;

/**
 *
 * @author caique
 */

@FacesConverter(value = "converter.Dependente")
public class ConvertDependente implements Converter {

  //  private Pessoas service = new PessoasEmMemoria();

   
    private Dependentes dependentes = CDI.current().select(Dependentes.class).get();

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return dependentes.localizarDependenteComId(value);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Dependente dep = (Dependente) value;
        return dep.getUuid();
    }

    
}
