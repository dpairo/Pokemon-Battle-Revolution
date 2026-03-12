package com.pokedex.domain.entities.pokemon.abilities.features.immunity;

import com.pokedex.domain.entities.battlefield.BattleField;
import com.pokedex.domain.entities.pokemon.Pokemon;
import com.pokedex.domain.entities.pokemon.abilities.Ability;
import com.pokedex.domain.entities.pokemon.abilities.hooks.OnBeforeDefend;
import com.pokedex.domain.entities.pokemon.moves.Move;
import com.pokedex.domain.entities.pokemon.types.TypeList;

public class Levitate implements Ability, OnBeforeDefend {

    @Override
    public String getName() {
        return "Levitate";
    }

    @Override
    public String getDescription() {
        return "This Pokemon is immune to Ground-type moves, unless Gravity is in effect.";
    }

    @Override
    public double onBeforeDefend(Pokemon owner, Pokemon attacker, Move move, BattleField field) {
        if (move.getType().getType() == TypeList.Ground && !field.isGravityUp()) {
            return 0.0;
        }
        return 1.0;
    }
}
