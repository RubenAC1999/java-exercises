package org.ragra.date_time;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.TimeUnit;

public class EjemploDurationInstant {
    public static void main(String[] args) throws InterruptedException {
        Instant instante1 = Instant.now();

        TimeUnit.SECONDS.sleep(3);

        Instant instante2 = Instant.now();

        System.out.println("Duración: " + Duration.between(instante1, instante2));
    }
}
