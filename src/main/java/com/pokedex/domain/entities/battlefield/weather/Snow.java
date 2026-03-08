package com.pokedex.domain.entities.battlefield.weather;

import com.pokedex.domain.entities.pokemon.Pokemon;
import com.pokedex.domain.entities.pokemon.types.TypeList;

public class Snow extends Weather {
    private static final int BASE_DURATION = 5;

    public Snow(Pokemon pokemon) {
        this.weather = WeatherList.SNOW;
        this.weatherCounter = calculateDuration(pokemon, BASE_DURATION);
    }

    @Override
    public TypeList getTypeToBoost() {
        return TypeList.Ice;
    }
}
