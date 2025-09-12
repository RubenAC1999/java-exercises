package org.ragra.date_time;

import java.time.LocalDate;
import java.time.Period;

public class EjemploDurationPeriod {
    public static void main(String[] args) {
        LocalDate fecha1 = LocalDate.of(2025, 11, 11);
        LocalDate fecha2 = LocalDate.parse("2010-10-10");

        Period periodo = Period.between(fecha1, fecha2);

        System.out.println("Periodo entre " + fecha1 + " y " + fecha2 + ": " + periodo);
    }
}
