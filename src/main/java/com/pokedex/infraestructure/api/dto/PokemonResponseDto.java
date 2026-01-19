package com.pokedex.infraestructure.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class PokemonResponseDto {
    private Integer id;
    private String name;
    private Integer height;
    private Integer weight;

    @JsonProperty("base_experience")
    private Integer baseExperience;

    @JsonProperty("is_default")
    private Boolean isDefault;

    private Integer order;

    private List<TypeSlotDto> types;
    private List<StatDto> stats;
    private List<AbilitySlotDto> abilities;
    private SpritesDto sprites;

    @JsonProperty("location_area_encounters")
    private String locationAreaEncounters;

    private NamedApiResourceDto species;

    public PokemonResponseDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Integer getBaseExperience() {
        return baseExperience;
    }

    public void setBaseExperience(Integer baseExperience) {
        this.baseExperience = baseExperience;
    }

    public Boolean getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public List<TypeSlotDto> getTypes() {
        return types;
    }

    public void setTypes(List<TypeSlotDto> types) {
        this.types = types;
    }

    public List<StatDto> getStats() {
        return stats;
    }

    public void setStats(List<StatDto> stats) {
        this.stats = stats;
    }

    public List<AbilitySlotDto> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<AbilitySlotDto> abilities) {
        this.abilities = abilities;
    }

    public SpritesDto getSprites() {
        return sprites;
    }

    public void setSprites(SpritesDto sprites) {
        this.sprites = sprites;
    }

    public String getLocationAreaEncounters() {
        return locationAreaEncounters;
    }

    public void setLocationAreaEncounters(String locationAreaEncounters) {
        this.locationAreaEncounters = locationAreaEncounters;
    }

    public NamedApiResourceDto getSpecies() {
        return species;
    }

    public void setSpecies(NamedApiResourceDto species) {
        this.species = species;
    }
}
