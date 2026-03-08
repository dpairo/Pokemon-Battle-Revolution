package com.pokedex.domain.entities.objects.choice;

import com.pokedex.domain.entities.objects.Consumable;
import com.pokedex.domain.entities.pokemon.Pokemon;

public abstract class ChoiceItem implements Consumable {
    @Override
    public void loseObject(Pokemon pokemon) {
        pokemon.setObject(null);
    }
}
