package com.pokedex.domain.entities.battlefield.weather;

import com.pokedex.domain.entities.objects.extenders.weather.WeatherExtender;
import com.pokedex.domain.entities.pokemon.Pokemon;
import com.pokedex.domain.entities.pokemon.types.TypeList;

public abstract class Weather {
    protected WeatherList weather;
    protected int weatherCounter;

    public WeatherList getWeather() {
        return this.weather;
    }

    public int getWeatherCounter() {
        return this.weatherCounter;
    }

    public void decrementCounter() {
        if (this.weatherCounter > 0) {
            this.weatherCounter--;
        }
    }

    public boolean isActive() {
        return this.weatherCounter > 0;
    }

    public int calculateDuration(Pokemon pokemon, int baseDuration) {
        if (pokemon.getObject() instanceof WeatherExtender extender && extender.getExtendedWeather() == this.weather) {
            return baseDuration + extender.getExtensionTurns();
        }
        return baseDuration;
    }

    public abstract TypeList getTypeToBoost();
}
