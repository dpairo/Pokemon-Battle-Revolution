package com.pokedex.infrastructure.api.dto;

public class TypeSlotDto {
    private Integer slot;
    private NamedApiResourceDto type;

    public TypeSlotDto() {
    }

    public TypeSlotDto(Integer slot, NamedApiResourceDto type) {
        this.slot = slot;
        this.type = type;
    }

    public Integer getSlot() {
        return slot;
    }

    public void setSlot(Integer slot) {
        this.slot = slot;
    }

    public NamedApiResourceDto getType() {
        return type;
    }

    public void setType(NamedApiResourceDto type) {
        this.type = type;
    }
}
