/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validator;

import java.time.LocalDate;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author caique
 */
public class ValidadorNascimeto implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        LocalDate dataNascimento = (LocalDate) value;

        if (dataNascimento == null) {
            throw new ValidatorException(new FacesMessage("Data invalida"));
        }

        if (dataNascimento.isEqual(LocalDate.now()) || dataNascimento.isAfter(LocalDate.now())) {
            throw new ValidatorException(new FacesMessage("Data invalida!"));
        }
    }

}
