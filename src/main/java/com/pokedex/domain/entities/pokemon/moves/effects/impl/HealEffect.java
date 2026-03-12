package com.pokedex.domain.entities.pokemon.moves.effects.impl;

import com.pokedex.domain.entities.pokemon.Pokemon;
import com.pokedex.domain.entities.pokemon.moves.effects.MoveContext;
import com.pokedex.domain.entities.pokemon.moves.effects.MoveEffect;
import com.pokedex.domain.entities.pokemon.moves.effects.MoveEffectResult;

public class HealEffect implements MoveEffect {
    private final double healFraction;

    public HealEffect(double healFraction) {
        this.healFraction = healFraction;
    }

    @Override
    public MoveEffectResult apply(Pokemon attacker, Pokemon defender, MoveContext context) {
        int heal = Math.max(1, (int)(attacker.getStats().getMaxHp() * healFraction));
        attacker.getStats().heal(heal);
        return new MoveEffectResult(true, attacker.getName() + " recuper\u00f3 " + heal + " HP!");
    }

    @Override
    public int getChancePercent() {
        return 100;
    }
}
