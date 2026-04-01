package com.pokedex.domain.entities.pokemon.abilities.features.contact;

import com.pokedex.domain.entities.pokemon.Pokemon;
import com.pokedex.domain.entities.pokemon.abilities.Ability;
import com.pokedex.domain.entities.pokemon.abilities.hooks.OnContactReceived;
import com.pokedex.domain.entities.statuses.Burned;
import com.pokedex.domain.ports.output.random.DamageRollProvider;

public class FlameBody implements Ability, OnContactReceived {

    @Override
    public String getName() {
        return "Flame Body";
    }

    @Override
    public String getDescription() {
        return "Contact with this Pokemon may burn the attacker.";
    }

    @Override
    public int getChancePercent() {
        return 30;
    }

    @Override
    public void onContactReceived(Pokemon owner, Pokemon attacker, DamageRollProvider random) {
        if (!attacker.isStatused() && random.rollChance(getChancePercent())) {
            attacker.setStatus(new Burned());
        }
    }
}
