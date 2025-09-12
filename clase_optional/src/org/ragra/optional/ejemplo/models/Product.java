package org.ragra.optional.ejemplo.models;

public class Product {
    private String name;
    private double precio;

    public Product(String nombre, double precio) {
        this.name = nombre;
        this.precio = precio;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name.concat(", ")
                .concat(String.valueOf(this.precio));
    }
}
