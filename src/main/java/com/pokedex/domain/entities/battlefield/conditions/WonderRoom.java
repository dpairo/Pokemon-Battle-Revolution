package com.pokedex.domain.entities.battlefield.conditions;

import com.pokedex.domain.entities.pokemon.Pokemon;

public class WonderRoom extends Condition {
    public WonderRoom(Pokemon pokemon) {
        this.condition = ConditionList.WONDER_ROOM;
        this.remainingTurns = calculateDuration(pokemon);
    }
}
