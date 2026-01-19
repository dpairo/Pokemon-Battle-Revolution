package com.pokedex.infraestructure.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OfficialArtworkDto {
    @JsonProperty("front_default")
    private String frontDefault;

    @JsonProperty("front_shiny")
    private String frontShiny;

    public OfficialArtworkDto() {
    }

    public OfficialArtworkDto(String frontDefault, String frontShiny) {
        this.frontDefault = frontDefault;
        this.frontShiny = frontShiny;
    }

    public String getFrontDefault() {
        return frontDefault;
    }

    public void setFrontDefault(String frontDefault) {
        this.frontDefault = frontDefault;
    }

    public String getFrontShiny() {
        return frontShiny;
    }

    public void setFrontShiny(String frontShiny) {
        this.frontShiny = frontShiny;
    }
}
