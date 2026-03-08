package com.pokedex.domain.entities.statuses;

import com.pokedex.domain.entities.pokemon.Pokemon;

public class Poisoned implements Status {
    private static final double DAMAGE_FRACTION = 1.0 / 8.0;

    @Override
    public StatusList getStatusType() {
        return StatusList.Poisoned;
    }

    @Override
    public void applyEndOfTurnEffect(Pokemon pokemon) {
        int maxHp = pokemon.getStats().getMaxHp();
        int damage = (int) Math.max(1, maxHp * DAMAGE_FRACTION);
        pokemon.getStats().takeDamage(damage);
    }

    @Override
    public boolean preventsAction() {
        return false;
    }
}
