package org.ragra.date_time;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Ejercicio1 {
    public static void main(String[] args) {
        LocalDate hoy = LocalDate.now();
        LocalDate resultado = hoy.plusDays(5);
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("La fecha de hoy es " + hoy.format(pattern)
                + ". \nEl resultado es: " + resultado.format(pattern) + ".");
    }
}
