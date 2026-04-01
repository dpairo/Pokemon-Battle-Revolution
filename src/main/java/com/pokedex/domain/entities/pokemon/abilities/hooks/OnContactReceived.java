package com.pokedex.domain.entities.pokemon.abilities.hooks;

import com.pokedex.domain.entities.pokemon.Pokemon;
import com.pokedex.domain.ports.output.random.DamageRollProvider;

public interface OnContactReceived {
    void onContactReceived(Pokemon owner, Pokemon attacker, DamageRollProvider random);
    int getChancePercent();
}
