package com.pokedex.domain.entities.pokemon;

import com.pokedex.domain.entities.stats.Statistics;
import com.pokedex.domain.entities.types.TypeList;

public class Pokemon {
    private Integer pokedexId;
    private String name;
    private TypeList firstType;
    private TypeList secondType;
    private Statistics stats;
    private Integer height;
    private Integer weight;
    private String spriteUrl;

    public Pokemon(Integer pokedexId, String name, TypeList firstType, TypeList secondType,
                   Statistics stats, Integer height, Integer weight, String spriteUrl) {
        this.pokedexId = pokedexId;
        this.name = name;
        this.firstType = firstType;
        this.secondType = secondType;
        this.stats = stats;
        this.height = height;
        this.weight = weight;
        this.spriteUrl = spriteUrl;
    }

    public Integer getPokedexId() {
        return pokedexId;
    }

    public void setPokedexId(Integer pokedexId) {
        this.pokedexId = pokedexId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TypeList getFirstType() {
        return firstType;
    }

    public void setFirstType(TypeList firstType) {
        this.firstType = firstType;
    }

    public TypeList getSecondType() {
        return secondType;
    }

    public void setSecondType(TypeList secondType) {
        this.secondType = secondType;
    }

    public Statistics getStats() {
        return stats;
    }

    public void setStats(Statistics stats) {
        this.stats = stats;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getSpriteUrl() {
        return spriteUrl;
    }

    public void setSpriteUrl(String spriteUrl) {
        this.spriteUrl = spriteUrl;
    }

    public boolean hasSecondType() {
        return secondType != null && secondType != TypeList.Null;
    }
}
