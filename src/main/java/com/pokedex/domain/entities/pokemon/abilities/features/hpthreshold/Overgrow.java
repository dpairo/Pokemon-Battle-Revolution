package com.pokedex.domain.entities.pokemon.abilities.features.hpthreshold;

import com.pokedex.domain.entities.pokemon.Pokemon;
import com.pokedex.domain.entities.pokemon.abilities.Ability;
import com.pokedex.domain.entities.pokemon.abilities.hooks.OnHpThreshold;
import com.pokedex.domain.entities.pokemon.moves.Move;
import com.pokedex.domain.entities.pokemon.types.TypeList;

public class Overgrow implements Ability, OnHpThreshold {

    @Override
    public String getName() {
        return "Overgrow";
    }

    @Override
    public String getDescription() {
        return "When this Pokemon's HP is below 1/3, its Grass-type moves deal 1.5x damage.";
    }

    @Override
    public double getThreshold() {
        return 1.0 / 3.0;
    }

    @Override
    public double onHpThreshold(Pokemon owner, Move move) {
        if (move.getType().getType() == TypeList.Grass) {
            return 1.5;
        }
        return 1.0;
    }
}
