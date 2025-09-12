package org.ragra.date_time;

import java.time.Duration;
import java.time.LocalDateTime;

public class EjemploDuration {
    public static void main(String[] args) {
        LocalDateTime ahora = LocalDateTime.now();
        LocalDateTime despues = LocalDateTime.of(2025, 7, 24, 15, 15);
        Duration duracion = Duration.between(ahora, despues);

        System.out.println("Duración entre " + ahora + " y " + despues + ": " + duracion);
    }
}
