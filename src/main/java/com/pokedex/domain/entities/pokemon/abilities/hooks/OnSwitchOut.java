package com.pokedex.domain.entities.pokemon.abilities.hooks;

import com.pokedex.domain.entities.battlefield.BattleField;
import com.pokedex.domain.entities.pokemon.Pokemon;

public interface OnSwitchOut {
    void onSwitchOut(Pokemon owner, BattleField field);
}
