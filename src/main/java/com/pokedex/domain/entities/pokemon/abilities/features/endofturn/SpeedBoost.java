package com.pokedex.domain.entities.pokemon.abilities.features.endofturn;

import com.pokedex.domain.entities.battlefield.BattleField;
import com.pokedex.domain.entities.pokemon.Pokemon;
import com.pokedex.domain.entities.pokemon.abilities.Ability;
import com.pokedex.domain.entities.pokemon.abilities.hooks.OnEndOfTurn;
import com.pokedex.domain.entities.pokemon.stats.StatList;

public class SpeedBoost implements Ability, OnEndOfTurn {

    @Override
    public String getName() {
        return "Speed Boost";
    }

    @Override
    public String getDescription() {
        return "This Pokemon's Speed stat is raised by one stage at the end of each turn.";
    }

    @Override
    public void onEndOfTurn(Pokemon owner, BattleField field) {
        owner.applyStageChange(StatList.Speed, 1);
    }
}
