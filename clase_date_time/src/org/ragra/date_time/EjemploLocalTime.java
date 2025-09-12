package org.ragra.date_time;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class EjemploLocalTime {
    public static void main(String[] args) {
        
        LocalTime ahora = LocalTime.now();
        System.out.println("ahora = " + ahora);
        
        ahora = LocalTime.of(6, 30);
        System.out.println("ahora = " + ahora);
        System.out.println("ahora = " + LocalTime.parse("06:30"));
        System.out.println("ahora + 1 hora: " + LocalTime.parse("06:30").plusHours(1));

        System.out.println("Hora: " + ahora.getHour());
        System.out.println("Minutos: " + ahora.getMinute());
        System.out.println("Segundos: " + ahora.getSecond());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss");
        String horaFormateada = formatter.format(ahora);
        System.out.println("horaFormateada = " + horaFormateada);

    }
}
