package org.ragra.optional.ejemplo;

import org.ragra.optional.ejemplo.models.*;

public class Ejercicio2 {
    public static void main(String[] args) {
        ProductRepository repository = new ProductRepository();

        repository.addProduct(new Product("Product 1", 10));
        repository.addProduct(new Product("Product 2", 20));
        repository.addProduct(new Product("Product 3", 30));

        repository.filter("1").ifPresentOrElse(System.out::println,
                () -> System.out.println("Producto no encontrado..."));
    }
}
