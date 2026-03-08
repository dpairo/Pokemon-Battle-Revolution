package com.pokedex.domain.entities.battlefield.terrain;

import com.pokedex.domain.entities.objects.extenders.terrain.TerrainDurationExtender;
import com.pokedex.domain.entities.pokemon.Pokemon;
import com.pokedex.domain.entities.pokemon.types.TypeList;

public abstract class Terrain {
    protected TerrainList terrain;
    protected int counterTurns;

    protected int calculateDuration(Pokemon pokemon, int baseDuration) {
        if (pokemon.getObject() instanceof TerrainDurationExtender extender) {
            return baseDuration + extender.getExtensionTurns();
        }
        return baseDuration;
    }

    public void decrementCounter() {
        if (this.counterTurns > 0) {
            this.counterTurns--;
        }
    }

    public boolean isActive() {
        return this.counterTurns > 0;
    }

    public TerrainList getTerrain() {
        return this.terrain;
    }

    public int getCounterTurns() {
        return this.counterTurns;
    }

    public abstract TypeList getTypeToBoost();
}
