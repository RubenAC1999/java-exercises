package org.ragra.optional.ejemplo.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ComputerRepository implements ProductFilter<Computer> {
    private List<Computer> computerList;

    public ComputerRepository() {
        this.computerList = new ArrayList<>();
        this.computerList.add(new Computer("Asus Rog", "3942"));
        this.computerList.add(new Computer("MacBook", "MVVV123"));
    }

    @Override
    public Optional<Computer> filter(String name) {
        return computerList.stream()
                .filter(v -> v.getName().toLowerCase().contains(name.toLowerCase()))
                .findFirst();
    }
}
