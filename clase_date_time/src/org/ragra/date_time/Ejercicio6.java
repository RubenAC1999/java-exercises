package org.ragra.date_time;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Ejercicio6 {
    public static void main(String[] args) {
        LocalDate hoy = LocalDate.now();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese su fecha de nacimiento (YYYY-MM-dd): ");
        String respuesta = scanner.nextLine();

        try {
            LocalDate fechaNacimiento = LocalDate.parse(respuesta);
            Period anhos = Period.between(fechaNacimiento, hoy);
            System.out.println("Tiene " + anhos.getYears() + " años.");

        } catch(DateTimeParseException ex) {
            System.out.println("El formato es erróneo...");
        }

    }
}
