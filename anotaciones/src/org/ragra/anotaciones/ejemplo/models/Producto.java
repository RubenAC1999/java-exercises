package org.ragra.anotaciones.ejemplo.models;

import org.ragra.anotaciones.ejemplo.Init;
import org.ragra.anotaciones.ejemplo.JsonAtributo;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Producto {

    @JsonAtributo (nombre = "descripcion")
    private String nombre;

    @JsonAtributo
    private Long precio;

    private LocalDate fecha;

    @Init
    private void init() {
        this.nombre = Arrays.stream(this.nombre.split(" "))
                .map(palabra -> String.valueOf(palabra.charAt(0)).toUpperCase() +
                        palabra.substring(1).toLowerCase()
                ).collect(Collectors.joining(" "));
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Long getPrecio() {
        return precio;
    }

    public void setPrecio(Long precio) {
        this.precio = precio;
    }
}
