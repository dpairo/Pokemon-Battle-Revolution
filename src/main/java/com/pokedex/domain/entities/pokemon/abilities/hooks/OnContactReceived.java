package com.pokedex.domain.entities.pokemon.abilities.hooks;

import com.pokedex.domain.entities.pokemon.Pokemon;
import com.pokedex.domain.ports.output.random.RandomProvider;

public interface OnContactReceived {
    void onContactReceived(Pokemon owner, Pokemon attacker, RandomProvider random);
    int getChancePercent();
}
