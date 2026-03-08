package com.pokedex.infrastructure.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AbilitySlotDto {
    private NamedApiResourceDto ability;

    @JsonProperty("is_hidden")
    private Boolean isHidden;

    private Integer slot;

    public AbilitySlotDto() {
    }

    public AbilitySlotDto(NamedApiResourceDto ability, Boolean isHidden, Integer slot) {
        this.ability = ability;
        this.isHidden = isHidden;
        this.slot = slot;
    }

    public NamedApiResourceDto getAbility() {
        return ability;
    }

    public void setAbility(NamedApiResourceDto ability) {
        this.ability = ability;
    }

    public Boolean getIsHidden() {
        return isHidden;
    }

    public void setIsHidden(Boolean isHidden) {
        this.isHidden = isHidden;
    }

    public Integer getSlot() {
        return slot;
    }

    public void setSlot(Integer slot) {
        this.slot = slot;
    }
}
