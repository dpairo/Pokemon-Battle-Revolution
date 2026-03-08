package com.pokedex.domain.entities.objects.choice;

import com.pokedex.domain.entities.pokemon.Pokemon;

public class ChoiceScarf extends ChoiceItem {
    private static final String NAME = "Choice Scarf";

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public void loseObject(Pokemon pokemon) {
        pokemon.setObject(null);
    }
}
