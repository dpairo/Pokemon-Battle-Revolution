package com.pokedex.domain.entities.battlefield.weather;

import com.pokedex.domain.entities.pokemon.Pokemon;
import com.pokedex.domain.entities.pokemon.types.TypeList;

public class SunnyDay extends Weather {
    private static final int BASE_DURATION = 5;

    public SunnyDay(Pokemon pokemon) {
        this.weather = WeatherList.SUNNY_DAY;
        this.weatherCounter = calculateDuration(pokemon, BASE_DURATION);
    }

    @Override
    public TypeList getTypeToBoost() {
        return TypeList.Fire;
    }
}
