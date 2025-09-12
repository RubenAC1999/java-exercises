package org.ragra.anotaciones.ejemplo.models;

import org.ragra.anotaciones.ejemplo.procesador.JsonSerializador;

import java.time.LocalDate;

public class EjemploAnotacion {
    public static void main(String[] args) {

        Producto producto = new Producto();
        producto.setNombre("ordenador macBook air");
        producto.setPrecio(1000L);
        producto.setFecha(LocalDate.now());

        System.out.println(JsonSerializador.convertirJson(producto));
    }
}
