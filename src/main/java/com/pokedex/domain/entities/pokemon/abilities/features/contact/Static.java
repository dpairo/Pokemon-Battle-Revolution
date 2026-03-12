package com.pokedex.domain.entities.pokemon.abilities.features.contact;

import com.pokedex.domain.entities.pokemon.Pokemon;
import com.pokedex.domain.entities.pokemon.abilities.Ability;
import com.pokedex.domain.entities.pokemon.abilities.hooks.OnContactReceived;
import com.pokedex.domain.entities.statuses.Paralyzed;
import com.pokedex.domain.ports.output.random.RandomProvider;

public class Static implements Ability, OnContactReceived {

    @Override
    public String getName() {
        return "Static";
    }

    @Override
    public String getDescription() {
        return "Contact with this Pokemon may paralyze the attacker.";
    }

    @Override
    public int getChancePercent() {
        return 30;
    }

    @Override
    public void onContactReceived(Pokemon owner, Pokemon attacker, RandomProvider random) {
        if (!attacker.isStatused() && random.rollChance(getChancePercent())) {
            attacker.setStatus(new Paralyzed());
        }
    }
}
