package org.ragra.recursividad.ejemplo.models;

import java.util.ArrayList;
import java.util.List;

public class Componente {
    private String nombre;
    private List<Componente> componentes;

    public Componente(String nombre) {
        this.nombre = nombre;
        this.componentes = new ArrayList<>();
    }

    public List<Componente> getComponentes() {
        return componentes;
    }

    public void setComponentes(List<Componente> componentes) {
        this.componentes = componentes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Componente addComponente(Componente componente) {
        this.componentes.add(componente);

        return this;
    }

    public boolean hasComponentes() {
        return this.componentes.isEmpty();
    }
}
