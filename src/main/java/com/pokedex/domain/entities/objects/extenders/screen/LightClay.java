package com.pokedex.domain.entities.objects.extenders.screen;

import com.pokedex.domain.entities.objects.Consumable;
import com.pokedex.domain.entities.pokemon.Pokemon;

public class LightClay implements Consumable, ScreenExtender {
    private static final String NAME = "Light Clay";
    private static final int EXTENSION_TURNS = 3;

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public void loseObject(Pokemon pokemon) {
        pokemon.setObject(null);
    }

    @Override
    public int getExtensionTurns() {
        return EXTENSION_TURNS;
    }
}
