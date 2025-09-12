package org.ragra.java8.lambda.ejercicio;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduzca la palabra a transformar: ");
        String frase = scanner.nextLine();

        EliminarEspacios transformar = (palabra) -> palabra.replaceAll("[ ,.]", "").toUpperCase();

        String resultado = Main.transformar(frase, transformar);

        System.out.println("El resultado final es: " + resultado);
    }

    private static String transformar(String frase, EliminarEspacios lambda) {
        return lambda.transformar(frase);
    }


}
