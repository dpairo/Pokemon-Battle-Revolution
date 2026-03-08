package com.pokedex.domain.entities.objects.extenders.weather;

import com.pokedex.domain.entities.battlefield.weather.WeatherList;
import com.pokedex.domain.entities.pokemon.types.TypeList;

public class DampRock extends WeatherRock {
    public DampRock() {
        this.name = "Damp Rock";
    }

    @Override
    public WeatherList getExtendedWeather() {
        return WeatherList.RAIN;
    }

    @Override
    public TypeList getTypeToBoost() {
        return TypeList.Water;
    }
}
