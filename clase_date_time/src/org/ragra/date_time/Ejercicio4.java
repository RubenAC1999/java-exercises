package org.ragra.date_time;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Ejercicio4 {
    public static void main(String[] args) {
        ZoneId esID = ZoneId.of("Europe/Madrid");
        ZoneId nyID = ZoneId.of("America/New_York");

        LocalDateTime fecha = LocalDateTime.now();

        ZonedDateTime fechaEspanha = fecha.atZone(esID);
        ZonedDateTime fechaNY = fechaEspanha.withZoneSameInstant(nyID);

        System.out.println("Fecha y hora en España: " + fechaEspanha);
        System.out.println("Fecha y hora en Nueva York: " + fechaNY);
    }
}
