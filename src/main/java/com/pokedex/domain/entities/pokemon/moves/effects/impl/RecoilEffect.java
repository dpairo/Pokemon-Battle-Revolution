package com.pokedex.domain.entities.pokemon.moves.effects.impl;

import com.pokedex.domain.entities.pokemon.Pokemon;
import com.pokedex.domain.entities.pokemon.moves.effects.MoveContext;
import com.pokedex.domain.entities.pokemon.moves.effects.MoveEffect;
import com.pokedex.domain.entities.pokemon.moves.effects.MoveEffectResult;

public class RecoilEffect implements MoveEffect {
    private final double recoilFraction;

    public RecoilEffect(double recoilFraction) {
        this.recoilFraction = recoilFraction;
    }

    @Override
    public MoveEffectResult apply(Pokemon attacker, Pokemon defender, MoveContext context) {
        int recoil = Math.max(1, (int)(context.damageDealt() * recoilFraction));
        attacker.getStats().takeDamage(recoil);
        return new MoveEffectResult(true, attacker.getName() + " recibi\u00f3 " + recoil + " de da\u00f1o de retroceso!");
    }

    @Override
    public int getChancePercent() { return 100; }
}
