package com.pokedex.domain.entities.pokemon.moves.effects.impl;

import com.pokedex.domain.entities.pokemon.Pokemon;
import com.pokedex.domain.entities.pokemon.stats.StatList;
import com.pokedex.domain.entities.pokemon.moves.effects.MoveContext;
import com.pokedex.domain.entities.pokemon.moves.effects.MoveEffect;
import com.pokedex.domain.entities.pokemon.moves.effects.MoveEffectResult;

public class StatChangeEffect implements MoveEffect {
    public enum Target { SELF, OPPONENT }

    private final StatList stat;
    private final int stages;
    private final Target target;
    private final int chancePercent;

    public StatChangeEffect(StatList stat, int stages, Target target, int chancePercent) {
        this.stat = stat;
        this.stages = stages;
        this.target = target;
        this.chancePercent = chancePercent;
    }

    @Override
    public MoveEffectResult apply(Pokemon attacker, Pokemon defender, MoveContext context) {
        Pokemon affected = (target == Target.SELF) ? attacker : defender;
        var result = affected.applyStageChange(stat, stages);
        return new MoveEffectResult(result.wasApplied(), result.getMessage());
    }

    @Override
    public int getChancePercent() {
        return chancePercent;
    }
}
