package com.pokedex.domain.entities.battlefield.weather;

import com.pokedex.domain.entities.pokemon.Pokemon;
import com.pokedex.domain.entities.pokemon.types.TypeList;

public class RainDance extends Weather {
    private static final int BASE_DURATION = 5;

    public RainDance(Pokemon pokemon) {
        this.weather = WeatherList.RAIN;
        this.weatherCounter = calculateDuration(pokemon, BASE_DURATION);
    }

    @Override
    public TypeList getTypeToBoost() {
        return TypeList.Water;
    }
}
