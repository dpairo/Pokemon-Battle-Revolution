package com.pokedex.domain.entities.battlefield.field.hazards;

import com.pokedex.domain.entities.pokemon.types.SteelType;

public class SteelSpikes extends Hazard {
    public SteelSpikes() {
        hazardType = new SteelType();
        hazard = HazardList.STEEL_SPIKES;
        setHazard();
    }
}
