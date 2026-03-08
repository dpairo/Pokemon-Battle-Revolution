package com.pokedex.domain.entities.battlefield.field.screens;

import com.pokedex.domain.entities.objects.extenders.screen.ScreenExtender;
import com.pokedex.domain.entities.pokemon.Pokemon;

public abstract class Screens {
    protected static final int BASE_DURATION = 5;

    protected ScreenList screenType;
    protected int remainingTurns;

    protected int calculateDuration(Pokemon pokemon) {
        if (pokemon.getObject() instanceof ScreenExtender extender) {
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

    public ScreenList getScreenType() {
        return this.screenType;
    }
}
