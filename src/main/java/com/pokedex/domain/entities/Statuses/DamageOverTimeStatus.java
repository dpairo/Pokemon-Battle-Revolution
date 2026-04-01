package com.pokedex.domain.entities.statuses;

import com.pokedex.domain.entities.pokemon.Pokemon;
import com.pokedex.domain.ports.output.random.DamageRollProvider;

public abstract class DamageOverTimeStatus implements Status {

    protected abstract double getDamageFraction();

    @Override
    public void applyEndOfTurnEffect(Pokemon pokemon) {
        int maxHp = pokemon.getStats().getMaxHp();
        int damage = (int) Math.max(1, maxHp * getDamageFraction());
        pokemon.getStats().takeDamage(damage);
    }

    @Override
    public boolean preventsAction(DamageRollProvider random) {
        return false;
    }
}
