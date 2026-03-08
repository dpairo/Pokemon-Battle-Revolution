package com.pokedex.domain.entities.battlefield.field.screens;

import com.pokedex.domain.entities.pokemon.Pokemon;

public class LightScreen extends Screens {

    public LightScreen(Pokemon pokemon) {
        this.screenType = ScreenList.LIGHT_SCREEN;
        this.remainingTurns = calculateDuration(pokemon);
    }
}
