package org.ragra.date_time;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Ejercicio3 {
    public static void main(String[] args) {
        LocalDateTime citaMedica = LocalDateTime.parse("2025-08-15T10:30");
        DateTimeFormatter pattern = DateTimeFormatter
                .ofPattern("d 'de' MMMM 'del año' yyyy', a las' HH:mm ' de la mañana.'", new Locale("es", "ES"));

        System.out.printf("Buenos días, su cita médica tendrá lugar el día %s", citaMedica.format(pattern));

    }
}
