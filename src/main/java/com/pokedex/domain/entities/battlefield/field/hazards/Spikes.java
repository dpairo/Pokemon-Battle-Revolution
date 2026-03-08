package com.pokedex.domain.entities.battlefield.field.hazards;

import com.pokedex.domain.entities.pokemon.types.TypeList;

public class Spikes extends Hazard {
    public Spikes() {
        hazard = HazardList.SPIKES;
        setHazard();
    }

    public void addLayer() {
        if (layers != 3) {
            layers++;
        }
    }

    @Override
    public Double getDamageByHazard(TypeList firstType, TypeList secondType) {
        if (firstType == TypeList.Flying || secondType == TypeList.Flying) {
            return 0.0;
        }

        return switch (getLayerByHazard()) {
            case 0 ->
                    0.0;
            case 1 ->
                    12.5;
            case 2 ->
                    16.67;
            case 3 ->
                    25.0;
            default ->
                    0.0;
        };
    }
}
