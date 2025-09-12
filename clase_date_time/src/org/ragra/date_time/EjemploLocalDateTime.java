package org.ragra.date_time;

import java.time.LocalDateTime;

public class EjemploLocalDateTime {
    public static void main(String[] args) {
        LocalDateTime fechaActual = LocalDateTime.now();

        System.out.println("fechaActual = " + fechaActual);
        
        fechaActual = LocalDateTime.of(2010, 10, 10, 10, 10, 10);
        System.out.println("fechaActual = " + fechaActual);
        
        fechaActual = LocalDateTime.parse("2011-11-11T11:11");
        System.out.println("fechaActual = " + fechaActual);
    }
}
