package com.pokedex.domain.entities.battlefield.field.hazards;

import com.pokedex.domain.entities.statuses.StatusList;
import com.pokedex.domain.entities.pokemon.types.TypeList;

public class ToxicSpikes extends Hazard {
    public ToxicSpikes() {
        hazard = HazardList.TOXIC_SPIKES;
        setHazard();
    }

    public void addLayer() {
        if (layers != 2) {
            layers++;
        }
    }

    public StatusList getEffect(TypeList firstType, TypeList secondType) {
        if (firstType == TypeList.Poison || secondType == TypeList.Poison) {
            return StatusList.Null;
        }

        if(layers == 1) {
            return StatusList.Poisoned;
        }
        if (layers == 2) {
            return StatusList.BadlyPoisoned;
        }

        return StatusList.Null;
    }

    @Override
    public Double getDamageByHazard(TypeList firstType, TypeList secondType) {
        return 0.0;
    }
}
