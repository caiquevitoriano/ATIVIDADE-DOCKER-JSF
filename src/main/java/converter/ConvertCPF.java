/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import modelo.CPF;

/**
 *
 * @author caique
 */


@FacesConverter(value = "converter.cpf")
public class ConvertCPF implements Converter {

    @Override
    public Object getAsObject(
            FacesContext context,
            UIComponent component,
            String value) {

        return new CPF(value);

    }

    @Override
    public String getAsString(
            FacesContext context,
            UIComponent component,
            Object value) {

        CPF cpf = (CPF) value;
        return cpf.valor();

    }

}
