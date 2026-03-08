package com.pokedex.domain.entities.statuses;

import com.pokedex.domain.entities.pokemon.Pokemon;

public interface Status {
    StatusList getStatusType();
    void applyEndOfTurnEffect(Pokemon pokemon);
    boolean preventsAction();
}
