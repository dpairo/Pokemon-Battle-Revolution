package com.pokedex.domain.entities.battlefield.conditions;

import com.pokedex.domain.entities.objects.extenders.condition.ConditionExtender;
import com.pokedex.domain.entities.pokemon.Pokemon;

public abstract class Condition {
    protected ConditionList condition;
    protected int remainingTurns;
    protected static final int BASE_DURATION = 5;

    protected int calculateDuration(Pokemon pokemon) {
        if (pokemon.getObject() instanceof ConditionExtender extender && extender.getExtendedCondition() == this.condition) {
            return BASE_DURATION + extender.getExtensionTurns();
        }
        return BASE_DURATION;
    }

    public void decrementCounter() {
        if (this.remainingTurns > 0) {
            this.remainingTurns--;
        }
    }

    public boolean isActive() {
        return this.remainingTurns > 0;
    }

    public int getRemainingTurns() {
        return this.remainingTurns;
    }

    public ConditionList getCondition() {
        return this.condition;
    }
}
