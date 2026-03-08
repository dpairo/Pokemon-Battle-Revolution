package com.pokedex.domain.entities.objects.extenders.weather;

import com.pokedex.domain.entities.battlefield.weather.WeatherList;
import com.pokedex.domain.entities.objects.Consumable;
import com.pokedex.domain.entities.pokemon.Pokemon;
import com.pokedex.domain.entities.pokemon.types.TypeList;

public abstract class WeatherRock implements Consumable, WeatherExtender {
    private static final int EXTENSION_TURNS = 3;

    protected String name;

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void loseObject(Pokemon pokemon) {
        pokemon.setObject(null);
    }

    @Override
    public int getExtensionTurns() {
        return EXTENSION_TURNS;
    }

    @Override
    public abstract WeatherList getExtendedWeather();

    public abstract TypeList getTypeToBoost();
}
