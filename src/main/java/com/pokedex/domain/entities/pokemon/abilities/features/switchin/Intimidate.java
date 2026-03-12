package com.pokedex.domain.entities.pokemon.abilities.features.switchin;

import com.pokedex.domain.entities.battlefield.BattleField;
import com.pokedex.domain.entities.pokemon.Pokemon;
import com.pokedex.domain.entities.pokemon.abilities.Ability;
import com.pokedex.domain.entities.pokemon.abilities.hooks.OnSwitchIn;
import com.pokedex.domain.entities.pokemon.stats.StatList;

public class Intimidate implements Ability, OnSwitchIn {

    @Override
    public String getName() {
        return "Intimidate";
    }

    @Override
    public String getDescription() {
        return "When this Pokemon enters battle, the opposing Pokemon's Attack stat is lowered by one stage.";
    }

    @Override
    public void onSwitchIn(Pokemon owner, Pokemon opponent, BattleField field) {
        opponent.applyStageChange(StatList.Attack, -1);
    }
}
