package org.ragra.date_time;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class EjemploZoneDateTime {
    public static void main(String[] args) {
        LocalDateTime fecha = LocalDateTime.now();

        ZoneId nYorkId = ZoneId.of("America/New_York");

        ZonedDateTime fechaNuevaYork = ZonedDateTime.of(fecha, nYorkId);
        System.out.println("Fecha y hora en Nueva York: " + fechaNuevaYork);

        ZoneId madridId = ZoneId.of("Europe/Madrid");
        ZonedDateTime fechaMadrid = fechaNuevaYork.withZoneSameInstant(madridId);
        System.out.println("Fecha y hora en Madrid: " + fechaMadrid);

        ZoneId.getAvailableZoneIds().forEach(System.out::println);
    }
}
