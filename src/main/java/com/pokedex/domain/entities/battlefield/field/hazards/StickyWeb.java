package com.pokedex.domain.entities.battlefield.field.hazards;

import com.pokedex.domain.entities.pokemon.types.TypeList;

public class StickyWeb extends Hazard {
    public StickyWeb() {
        hazard = HazardList.STICKY_WEB;
        setHazard();
    }

    @Override
    public Double getDamageByHazard(TypeList firstType, TypeList secondType) {
        return 0.0;
    }
}
