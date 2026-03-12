package com.pokedex.domain.entities.pokemon.moves.effects.impl;

import com.pokedex.domain.entities.pokemon.Pokemon;
import com.pokedex.domain.entities.statuses.Status;
import com.pokedex.domain.entities.statuses.StatusList;
import com.pokedex.domain.entities.statuses.StatusFactory;
import com.pokedex.domain.entities.pokemon.moves.effects.MoveContext;
import com.pokedex.domain.entities.pokemon.moves.effects.MoveEffect;
import com.pokedex.domain.entities.pokemon.moves.effects.MoveEffectResult;

import java.util.Optional;

public class ApplyStatusEffect implements MoveEffect {
    private final StatusList statusToApply;
    private final int chancePercent;

    public ApplyStatusEffect(StatusList statusToApply, int chancePercent) {
        this.statusToApply = statusToApply;
        this.chancePercent = chancePercent;
    }

    @Override
    public MoveEffectResult apply(Pokemon attacker, Pokemon defender, MoveContext context) {
        if (defender.isStatused()) {
            return new MoveEffectResult(false, defender.getName() + " ya tiene un estado alterado.");
        }

        Optional<Status> status = StatusFactory.create(statusToApply);
        if (status.isEmpty()) {
            return new MoveEffectResult(false, "No se pudo crear el estado " + statusToApply.name() + ".");
        }

        defender.setStatus(status.get());
        return new MoveEffectResult(true, defender.getName() + " qued\u00f3 " + statusToApply.name().toLowerCase() + "!");
    }

    @Override
    public int getChancePercent() {
        return chancePercent;
    }
}
