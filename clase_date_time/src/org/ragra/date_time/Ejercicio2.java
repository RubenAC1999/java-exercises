package org.ragra.date_time;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Ejercicio2 {
    public static void main(String[] args) {
        LocalTime horaActual = LocalTime.now();
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("HH:mm:ss");

        System.out.println("El resultado es: " + horaActual.format(pattern));
    }
}
