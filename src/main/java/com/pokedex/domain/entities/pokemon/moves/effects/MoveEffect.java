package com.pokedex.domain.entities.pokemon.moves.effects;

import com.pokedex.domain.entities.pokemon.Pokemon;

public interface MoveEffect {
    MoveEffectResult apply(Pokemon attacker, Pokemon defender, MoveContext context);
    int getChancePercent();
}
