package com.pokedex.domain.ports.input.battle;

import com.pokedex.domain.entities.battlefield.BattleResult;
import com.pokedex.domain.entities.pokemon.Pokemon;
import com.pokedex.domain.entities.battlefield.BattleField;

public interface SimulateBattleUseCase {
    BattleResult execute(BattleField field, String playerOneName, String playerTwoName);
}
