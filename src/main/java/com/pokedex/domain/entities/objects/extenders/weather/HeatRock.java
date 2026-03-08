package com.pokedex.domain.entities.objects.extenders.weather;

import com.pokedex.domain.entities.battlefield.weather.WeatherList;
import com.pokedex.domain.entities.pokemon.types.TypeList;

public class HeatRock extends WeatherRock {
    public HeatRock() {
        this.name = "Heat Rock";
    }

    @Override
    public WeatherList getExtendedWeather() {
        return WeatherList.SUNNY_DAY;
    }

    @Override
    public TypeList getTypeToBoost() {
        return TypeList.Fire;
    }
}
