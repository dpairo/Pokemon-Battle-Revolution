package com.pokedex.domain.entities.pokedex;

public class PokedexListEntry {
    private final int id;
    private final String name;

    public PokedexListEntry(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
}
