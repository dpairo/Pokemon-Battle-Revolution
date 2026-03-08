package com.pokedex.domain.entities.objects;

import com.pokedex.domain.entities.pokemon.Pokemon;

public interface Consumable extends Item {
    public void loseObject(Pokemon pokemon);
}
