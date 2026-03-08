package com.pokedex.domain.entities.battlefield.field.screens;

import com.pokedex.domain.entities.pokemon.Pokemon;

public class AuroraVeil extends Screens {

    public AuroraVeil(Pokemon pokemon) {
        this.screenType = ScreenList.AURORA_VEIL;
        this.remainingTurns = calculateDuration(pokemon);
    }
}
