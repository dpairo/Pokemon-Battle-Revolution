package com.pokedex.domain.entities.battlefield.terrain;

import com.pokedex.domain.entities.pokemon.Pokemon;
import com.pokedex.domain.entities.pokemon.types.TypeList;

public class GrassyTerrain extends Terrain {
    private static final int BASE_DURATION = 5;

    public GrassyTerrain(Pokemon pokemonSummoner) {
        this.terrain = TerrainList.GRASSY_TERRAIN;
        this.counterTurns = calculateDuration(pokemonSummoner, BASE_DURATION);
    }

    @Override
    public TypeList getTypeToBoost() {
        return TypeList.Grass;
    }
}
