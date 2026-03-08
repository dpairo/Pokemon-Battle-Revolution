package com.pokedex.domain.entities.objects.extenders.weather;

import com.pokedex.domain.entities.battlefield.weather.WeatherList;

public interface WeatherExtender {
    WeatherList getExtendedWeather();
    int getExtensionTurns();
}
