package com.pokedex.domain.entities.battlefield.field.screens;

import com.pokedex.domain.entities.pokemon.Pokemon;

public class Reflect extends Screens {

    public Reflect(Pokemon pokemon) {
        this.screenType = ScreenList.REFLECT;
        this.remainingTurns = calculateDuration(pokemon);
    }
}
