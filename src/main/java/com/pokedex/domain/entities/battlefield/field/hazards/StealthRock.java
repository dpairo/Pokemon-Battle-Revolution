package com.pokedex.domain.entities.battlefield.field.hazards;

import com.pokedex.domain.entities.pokemon.types.RockType;

public class StealthRock extends Hazard {
    public StealthRock() {
        hazardType = new RockType();
        hazard = HazardList.STEALTH_ROCK;
        setHazard();
    }

}
