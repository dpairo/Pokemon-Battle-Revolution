package com.pokedex.domain.entities.statuses;

import com.pokedex.domain.entities.pokemon.Pokemon;
import com.pokedex.domain.ports.output.random.DamageRollProvider;

public class Paralyzed implements Status {

    @Override
    public StatusList getStatusType() {
        return StatusList.Paralyzed;
    }

    @Override
    public void applyEndOfTurnEffect(Pokemon pokemon) {
        // Paralysis has no end-of-turn damage effect
    }

    @Override
    public boolean preventsAction(DamageRollProvider random) {
        return random.rollChance(25);
    }
}
