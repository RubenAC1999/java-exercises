package org.ragra.date_time;

import java.time.*;

public class Ejercicio5 {
    public static void main(String[] args) {
        LocalDateTime hoy = LocalDateTime.now();
        LocalDateTime manhana = LocalDateTime.parse("2025-08-01T00:00");
        LocalDateTime hoyHora = LocalDateTime.of(hoy.getYear(), hoy.getMonth().getValue(), hoy.getDayOfMonth(),
                hoy.plusHours(1).getHour(), 0);

        LocalDateTime anhoNuevo = LocalDateTime.parse("2026-01-01T00:00");

        long duracionDias = Duration.between(hoy, anhoNuevo).toDays();
        long duracionHoras = Duration.between(hoy, manhana).toHours();
        long duracionMinutos = Duration.between(hoy, hoyHora).toMinutes();

        System.out.printf("Faltan %d días, %d horas y %d minutos para fin de año.", duracionDias, duracionHoras, duracionMinutos);

    }

}
