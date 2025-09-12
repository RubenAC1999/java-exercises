package org.ragra.java8.lambda.ejercicio2;

import java.util.*;
import java.util.function.Function;

public class ContarPalabrasEjercicio {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduzca la frase: ");
        String frase = scanner.nextLine();


        Function<String, Map<Integer, String>> contarPalabras = (string) -> {
            String palabraMasRepetida = null;

            String[] palabras = string.toLowerCase().split(" ", string.length());
            int max = 0;

            for (int i = 0; i < palabras.length; i++) {
                int contador = 0;
                String palabra = palabras[i];

                for (int j = 0; j < palabras.length; j++) {
                    if (palabra.equals(palabras[j])) {
                        contador++;
                    }
                }

                if (contador > max) {
                    max = contador;
                    palabraMasRepetida = palabra;
                }
            }

           return Collections.singletonMap(max, palabraMasRepetida);
        };

        System.out.println("La palabra más repetida es: " + contarPalabras.apply(frase));
    }
}

