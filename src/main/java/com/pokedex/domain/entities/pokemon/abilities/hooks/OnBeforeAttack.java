package com.pokedex.domain.entities.pokemon.abilities.hooks;

import com.pokedex.domain.entities.battlefield.BattleField;
import com.pokedex.domain.entities.pokemon.Pokemon;
import com.pokedex.domain.entities.pokemon.moves.Move;

public interface OnBeforeAttack {
    double onBeforeAttack(Pokemon owner, Pokemon target, Move move, BattleField field);
}
