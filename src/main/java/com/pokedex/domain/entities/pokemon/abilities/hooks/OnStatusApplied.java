package com.pokedex.domain.entities.pokemon.abilities.hooks;

import com.pokedex.domain.entities.pokemon.Pokemon;
import com.pokedex.domain.entities.statuses.StatusList;

public interface OnStatusApplied {
    boolean preventsStatus(Pokemon owner, StatusList status);
}
