package org.ragra.optional.ejemplo;

import java.util.Optional;

public class OptionalEjemplo {
    public static void main(String[] args) {
        String nombre = null;
        Optional<String> opt = Optional.ofNullable(nombre);

        System.out.println("opt = " + opt);
        System.out.println(opt.isEmpty());
        System.out.println(opt.isPresent());

        opt.ifPresentOrElse(valor -> System.out.println("Hola " + valor),
                () -> System.out.println("Está vacío."));
    }
}
