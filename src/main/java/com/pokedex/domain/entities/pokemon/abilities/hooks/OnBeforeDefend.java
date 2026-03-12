package com.pokedex.domain.entities.pokemon.abilities.hooks;

import com.pokedex.domain.entities.battlefield.BattleField;
import com.pokedex.domain.entities.pokemon.Pokemon;
import com.pokedex.domain.entities.pokemon.moves.Move;

public interface OnBeforeDefend {
    double onBeforeDefend(Pokemon owner, Pokemon attacker, Move move, BattleField field);
}
