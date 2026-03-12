package com.pokedex.domain.entities.pokedex;

import com.pokedex.domain.entities.pokemon.stats.BaseStats;
import com.pokedex.domain.entities.pokemon.types.TypeList;

import java.util.Objects;

public class PokedexEntry {
    private final int pokedexId;
    private final String name;
    private final TypeList firstType;
    private final TypeList secondType;
    private final int height;
    private final int weight;
    private final String spriteUrl;
    private final BaseStats baseStats;

    public PokedexEntry(int pokedexId, String name, TypeList firstType, TypeList secondType, int height, int weight, String spriteUrl, BaseStats baseStats) {
        this.pokedexId = pokedexId;
        this.name = name;
        this.firstType = firstType;
        this.secondType = secondType;
        this.height = height;
        this.weight = weight;
        this.spriteUrl = spriteUrl;
        this.baseStats = baseStats;
    }

    public int getPokedexId() {
        return this.pokedexId;
    }

    public String getName() {
        return this.name;
    }

    public TypeList getFirstType() {
        return this.firstType;
    }

    public TypeList getSecondType() {
        return this.secondType;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWeight() {
        return this.weight;
    }

    public String getSpriteUrl() {
        return this.spriteUrl;
    }

    public BaseStats getBaseStats() {
        return this.baseStats;
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) {
            return true;
        }
        if (otherObject == null || this.getClass() != otherObject.getClass()) {
            return false;
        }

        PokedexEntry otherEntry = (PokedexEntry) otherObject;
        return this.pokedexId == otherEntry.pokedexId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.pokedexId);
    }

    @Override
    public String toString() {
        return String.format("PokedexEntry{id=%d, name='%s', types=[%s, %s]}", this.pokedexId, this.name, this.firstType, this.secondType);
    }
}
