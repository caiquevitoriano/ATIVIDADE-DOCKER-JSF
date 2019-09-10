/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author caique
 */
public class ValidadorNome implements Validator{

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        
         String nome = (String) value;
        if(nome == null){
            throw new ValidatorException(new FacesMessage("Informe o nome"));
        }
        if(nome.length() == 0){
            throw new ValidatorException(new FacesMessage("Nome vazio"));
        }
    }
    
}
