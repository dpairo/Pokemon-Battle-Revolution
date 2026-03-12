package com.pokedex.domain.entities.battlefield.field.hazards;

import com.pokedex.domain.entities.pokemon.types.Type;
import com.pokedex.domain.entities.pokemon.types.TypeList;

public abstract class Hazard {
    protected Type hazardType;
    protected HazardList hazard;
    protected Integer layers;

    public HazardList getHazard() {
        return hazard;
    }

    public Integer getLayerByHazard() {
        return layers;
    }

    public void setHazard() {
        layers = 1;
    }

    public void clearHazard() {
        layers = 0;
    }

    public Double getDamageByHazard(TypeList firstType, TypeList secondType) {
        if (hazardType.dealsSuperEffectiveDamage(firstType) && hazardType.dealsSuperEffectiveDamage(secondType)) {
            return 50.0;
        }
        if (hazardType.dealsSuperEffectiveDamage(firstType) && hazardType.dealsNotEffectiveDamage(secondType)) {
            return 12.5;
        }
        if (hazardType.dealsNotEffectiveDamage(firstType) && hazardType.dealsSuperEffectiveDamage(secondType)) {
            return 12.5;
        }
        if (hazardType.dealsSuperEffectiveDamage(firstType) || hazardType.dealsSuperEffectiveDamage(secondType)) {
            return 25.0;
        }
        if (hazardType.dealsNotEffectiveDamage(firstType) && hazardType.dealsNotEffectiveDamage(secondType)) {
            return 3.125;
        }
        if (hazardType.dealsNotEffectiveDamage(firstType) || hazardType.dealsNotEffectiveDamage(secondType)) {
            return 6.25;
        }

        // base damage
        return 12.5;
    }
}
