package com.pokedex.domain.entities.statuses;

import com.pokedex.domain.entities.pokemon.Pokemon;
import com.pokedex.domain.ports.output.random.RandomProvider;

public class BadlyPoisoned implements Status {
    private int turnCounter;

    public BadlyPoisoned() {
        this.turnCounter = 1;
    }

    @Override
    public StatusList getStatusType() {
        return StatusList.BadlyPoisoned;
    }

    @Override
    public void applyEndOfTurnEffect(Pokemon pokemon) {
        int maxHp = pokemon.getStats().getMaxHp();
        int damage = (int) Math.max(1, (maxHp * this.turnCounter) / 16.0);
        pokemon.getStats().takeDamage(damage);
        this.turnCounter = Math.min(this.turnCounter + 1, 15);
    }

    @Override
    public boolean preventsAction(RandomProvider random) {
        return false;
    }

    public void resetCounter() {
        this.turnCounter = 1;
    }
}
