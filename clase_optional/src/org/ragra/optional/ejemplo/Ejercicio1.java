package org.ragra.optional.ejemplo;

import java.util.Optional;

public class Ejercicio1 {
    public static void main(String[] args) {
        String nombre = null;

        String saludo = Optional.ofNullable(nombre).orElse("invitado");

        System.out.println("Hola, " + saludo);
    }
}
