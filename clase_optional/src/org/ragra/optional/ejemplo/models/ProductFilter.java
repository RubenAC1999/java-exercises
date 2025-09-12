package org.ragra.optional.ejemplo.models;

import java.util.Optional;

@FunctionalInterface
public interface ProductFilter<T> {
    Optional<T> filter(String name);
}
