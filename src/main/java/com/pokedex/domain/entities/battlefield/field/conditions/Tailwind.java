package com.pokedex.domain.entities.battlefield.field.conditions;

public class Tailwind {
    private static final int DURATION = 4;

    private int remainingTurns;

    public Tailwind() {
        this.remainingTurns = DURATION;
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
}
