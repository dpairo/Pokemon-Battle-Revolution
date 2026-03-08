package com.pokedex.domain.entities.objects.extenders.weather;

import com.pokedex.domain.entities.battlefield.weather.WeatherList;
import com.pokedex.domain.entities.pokemon.types.TypeList;

public class SmoothRock extends WeatherRock {
    public SmoothRock() {
        this.name = "Smooth Rock";
    }

    @Override
    public WeatherList getExtendedWeather() {
        return WeatherList.SANDSTORM;
    }

    @Override
    public TypeList getTypeToBoost() {
        return TypeList.Rock;
    }
}
