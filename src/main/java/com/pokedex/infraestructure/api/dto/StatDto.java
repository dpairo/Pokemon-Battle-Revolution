package com.pokedex.infraestructure.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StatDto {
    @JsonProperty("base_stat")
    private Integer baseStat;

    private Integer effort;
    private NamedApiResourceDto stat;

    public StatDto() {
    }

    public StatDto(Integer baseStat, Integer effort, NamedApiResourceDto stat) {
        this.baseStat = baseStat;
        this.effort = effort;
        this.stat = stat;
    }

    public Integer getBaseStat() {
        return baseStat;
    }

    public void setBaseStat(Integer baseStat) {
        this.baseStat = baseStat;
    }

    public Integer getEffort() {
        return effort;
    }

    public void setEffort(Integer effort) {
        this.effort = effort;
    }

    public NamedApiResourceDto getStat() {
        return stat;
    }

    public void setStat(NamedApiResourceDto stat) {
        this.stat = stat;
    }
}
