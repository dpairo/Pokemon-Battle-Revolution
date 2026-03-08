package com.pokedex.domain.entities.battlefield.weather;

import com.pokedex.domain.entities.pokemon.Pokemon;
import com.pokedex.domain.entities.pokemon.types.TypeList;

public class Sandstorm extends Weather {
    private static final int BASE_DURATION = 5;

    public Sandstorm(Pokemon pokemon) {
        this.weather = WeatherList.SANDSTORM;
        this.weatherCounter = calculateDuration(pokemon, BASE_DURATION);
    }

    @Override
    public TypeList getTypeToBoost() {
        return TypeList.Rock;
    }
}
