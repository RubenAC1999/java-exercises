package org.ragra.date_time;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;

public class EjemploLocalDate {
    public static void main(String[] args) {
        LocalDate fechaActual = LocalDate.now();
        System.out.println("fechaActual = " + fechaActual);
        System.out.println("Día de la semana: " + fechaActual.getDayOfWeek());
        System.out.println("Día del mes: " + fechaActual.getDayOfMonth());
        System.out.println("Día del año: " + fechaActual.getDayOfYear());
        System.out.println("Mes: " + fechaActual.getMonth());
        System.out.println("Año: " + fechaActual.getYear());
        
        fechaActual = LocalDate.of(2010, 10, 10);
        System.out.println("fechaActual = " + fechaActual);
        
        fechaActual = LocalDate.of(2010, Month.OCTOBER, 10);
        System.out.println("fechaActual = " + fechaActual);

        Month mes = fechaActual.getMonth();
        System.out.println("Mes: " +  mes.getDisplayName(TextStyle.FULL, new Locale("es", "ES")));
        
        fechaActual = LocalDate.parse("2010-10-10");
        System.out.println("fechaActual = " + fechaActual);
        
        LocalDate diaPosterior = fechaActual.plusDays(1);
        System.out.println("diaPosterior = " + diaPosterior);
        
        LocalDate mesAnterior = fechaActual.minusMonths(1);
        System.out.println("mesAnterior = " + mesAnterior);

        DayOfWeek diaSemana = fechaActual.getDayOfWeek();
        System.out.println("diaSemana = " + diaSemana.getDisplayName(TextStyle.FULL,
                new Locale("es", "ES")));
        
        int numeroMes = fechaActual.getMonthValue();
        System.out.println("numeroMes = " + numeroMes);
        
        boolean esBisiesto = fechaActual.isLeapYear();
        System.out.println("esBisiesto = " + esBisiesto);
        
        boolean esAntes = fechaActual.isBefore(diaPosterior);
        System.out.println("esAntes = " + esAntes);

        boolean esDespues = fechaActual.isAfter(mesAnterior);
        System.out.println("esDespues = " + esDespues);

    }
}
