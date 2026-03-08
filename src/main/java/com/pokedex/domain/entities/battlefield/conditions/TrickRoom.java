package com.pokedex.domain.entities.battlefield.conditions;

import com.pokedex.domain.entities.pokemon.Pokemon;

public class TrickRoom extends Condition {
    public TrickRoom(Pokemon pokemon) {
        this.condition = ConditionList.TRICK_ROOM;
        this.remainingTurns = calculateDuration(pokemon);
    }
}
