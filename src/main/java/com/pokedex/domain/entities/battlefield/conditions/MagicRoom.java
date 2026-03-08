package com.pokedex.domain.entities.battlefield.conditions;

import com.pokedex.domain.entities.pokemon.Pokemon;

public class MagicRoom extends Condition {
    public MagicRoom(Pokemon pokemon) {
        this.condition = ConditionList.MAGIC_ROOM;
        this.remainingTurns = calculateDuration(pokemon);
    }
}
