package com.pokedex.domain.entities.pokemon.abilities.hooks;

import com.pokedex.domain.entities.battlefield.BattleField;
import com.pokedex.domain.entities.pokemon.Pokemon;

public interface OnEndOfTurn {
    void onEndOfTurn(Pokemon owner, BattleField field);
}
