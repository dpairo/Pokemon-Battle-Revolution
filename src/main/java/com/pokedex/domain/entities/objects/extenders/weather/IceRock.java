package com.pokedex.domain.entities.objects.extenders.weather;

import com.pokedex.domain.entities.battlefield.weather.WeatherList;
import com.pokedex.domain.entities.pokemon.types.TypeList;

public class IceRock extends WeatherRock {
    public IceRock() {
        this.name = "Icy Rock";
    }

    @Override
    public WeatherList getExtendedWeather() {
        return WeatherList.SNOW;
    }

    @Override
    public TypeList getTypeToBoost() {
        return TypeList.Ice;
    }
}
