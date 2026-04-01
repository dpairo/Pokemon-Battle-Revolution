package com.pokedex.domain.ports.input.battle;

import com.pokedex.domain.entities.pokemon.Pokemon;
import com.pokedex.domain.entities.pokemon.moves.Move;
import com.pokedex.domain.entities.battlefield.BattleField;

public interface CalculateDamageUseCase {
    int execute(Move move, BattleField field, Pokemon attacker, Pokemon defender, boolean isDoubles);
}
