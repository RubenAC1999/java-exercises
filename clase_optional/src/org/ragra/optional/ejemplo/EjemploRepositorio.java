package org.ragra.optional.ejemplo;

import org.ragra.optional.ejemplo.models.Computer;
import org.ragra.optional.ejemplo.models.ComputerRepository;
import org.ragra.optional.ejemplo.models.ProductFilter;

import java.util.Optional;

public class EjemploRepositorio {
    public static void main(String[] args) {
        ProductFilter<Computer> filter = new ComputerRepository();

        Optional<Computer> computer = filter.filter("intel");

        computer.ifPresentOrElse(System.out::println,
                () -> System.out.println("No se ha encontrado el modelo."));
    }
}
