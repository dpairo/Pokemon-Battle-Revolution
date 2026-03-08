package com.pokedex.domain.entities.battlefield.conditions;

import com.pokedex.domain.entities.pokemon.Pokemon;

public class Gravity extends Condition {
    public Gravity(Pokemon pokemon) {
        this.condition = ConditionList.GRAVITY;
        this.remainingTurns = BASE_DURATION;
    }
}
