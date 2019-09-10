/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Objects;

/**
 *
 * @author caique
 */
public class CPF {
    
     private final String numero;

    public CPF(String numero) {
        this.numero = numero;
    }

    public String valor() {
        return this.numero;
    }

    public String formatado() {
        return String.format(
            "%s.%s.%s-%s",
            this.numero.substring(0,3), // 111222
            this.numero.substring(3,6),
            this.numero.substring(6,9),
            this.numero.substring(9,11)
        );
    }

    public boolean naoValido() {
        return (11 != this.numero.length());
    }

    public CPF() {
        this.numero = "";
    }
    
     @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CPF)) return false;
        CPF cpf = (CPF) o;
        return Objects.equals(numero, cpf.numero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero);
    }
}
