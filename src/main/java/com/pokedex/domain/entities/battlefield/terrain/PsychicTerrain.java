package com.pokedex.domain.entities.battlefield.terrain;

import com.pokedex.domain.entities.pokemon.Pokemon;
import com.pokedex.domain.entities.pokemon.types.TypeList;

public class PsychicTerrain extends Terrain {
    private static final int BASE_DURATION = 5;

    public PsychicTerrain(Pokemon pokemonSummoner) {
        this.terrain = TerrainList.PSYCHIC_TERRAIN;
        this.counterTurns = calculateDuration(pokemonSummoner, BASE_DURATION);
    }

    @Override
    public TypeList getTypeToBoost() {
        return TypeList.Psychic;
    }
}
