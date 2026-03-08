package com.pokedex.domain.entities.battlefield.terrain;

import com.pokedex.domain.entities.pokemon.Pokemon;
import com.pokedex.domain.entities.pokemon.types.TypeList;

public class ElectricTerrain extends Terrain {
    private static final int BASE_DURATION = 5;

    public ElectricTerrain(Pokemon pokemonSummoner) {
        this.terrain = TerrainList.ELECTRIC_TERRAIN;
        this.counterTurns = calculateDuration(pokemonSummoner, BASE_DURATION);
    }

    @Override
    public TypeList getTypeToBoost() {
        return TypeList.Electric;
    }
}
