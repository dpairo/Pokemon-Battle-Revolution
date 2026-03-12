package com.pokedex.domain.entities.statuses;

import com.pokedex.domain.entities.pokemon.Pokemon;
import com.pokedex.domain.ports.output.random.RandomProvider;

public interface Status {
    StatusList getStatusType();
    void applyEndOfTurnEffect(Pokemon pokemon);
    boolean preventsAction(RandomProvider random);
}
