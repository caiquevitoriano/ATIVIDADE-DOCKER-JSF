/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validator;

import java.util.Arrays;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import modelo.CPF;

/**
 *
 * @author caique
 */

@FacesValidator(value = "validator.cpf")
public class ValidadorCPF implements Validator {

    @Override
    public void validate(
            FacesContext context,
            UIComponent component,
            Object value) throws ValidatorException {
        CPF cpf = (CPF) value;

        if (cpf.naoValido()) {
            FacesMessage facesMessage = new FacesMessage("cpf inválido");

            List<FacesMessage> asList = Arrays.asList(
                    new FacesMessage("cpf inválido"),
                    new FacesMessage("deu ruim"),
                    new FacesMessage("de novo")
            );

            throw new ValidatorException(asList);
        }
    }
}
