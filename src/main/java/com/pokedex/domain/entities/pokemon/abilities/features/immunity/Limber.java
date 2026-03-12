package com.pokedex.domain.entities.pokemon.abilities.features.immunity;

import com.pokedex.domain.entities.pokemon.Pokemon;
import com.pokedex.domain.entities.pokemon.abilities.Ability;
import com.pokedex.domain.entities.pokemon.abilities.hooks.OnStatusApplied;
import com.pokedex.domain.entities.statuses.StatusList;

public class Limber implements Ability, OnStatusApplied {

    @Override
    public String getName() {
        return "Limber";
    }

    @Override
    public String getDescription() {
        return "This Pokemon cannot be paralyzed.";
    }

    @Override
    public boolean preventsStatus(Pokemon pokemon, StatusList status) {
        return status == StatusList.Paralyzed;
    }
}
