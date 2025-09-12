package org.ragra.optional.ejemplo.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductRepository implements ProductFilter<Product> {
    private List<Product> productRepository;

    public ProductRepository() {
        this.productRepository = new ArrayList<>();
    }

    public void addProduct(Product product) {
        this.productRepository.add(product);
    }

    public List<Product> getProductRepository() {
        return productRepository;
    }

    public void setProductRepository(List<Product> productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Optional<Product> filter(String name) {
        return this.productRepository.stream()
                .filter(product -> product.getName().toLowerCase().contains(name.toLowerCase()))
                .findFirst();
    }
}
