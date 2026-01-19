package com.pokedex.infraestructure.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OtherSpritesDto {
    @JsonProperty("official-artwork")
    private OfficialArtworkDto officialArtwork;

    private HomeSpritesDto home;

    @JsonProperty("dream_world")
    private DreamWorldSpritesDto dreamWorld;

    public OtherSpritesDto() {
    }

    public OfficialArtworkDto getOfficialArtwork() {
        return officialArtwork;
    }

    public void setOfficialArtwork(OfficialArtworkDto officialArtwork) {
        this.officialArtwork = officialArtwork;
    }

    public HomeSpritesDto getHome() {
        return home;
    }

    public void setHome(HomeSpritesDto home) {
        this.home = home;
    }

    public DreamWorldSpritesDto getDreamWorld() {
        return dreamWorld;
    }

    public void setDreamWorld(DreamWorldSpritesDto dreamWorld) {
        this.dreamWorld = dreamWorld;
    }
}
