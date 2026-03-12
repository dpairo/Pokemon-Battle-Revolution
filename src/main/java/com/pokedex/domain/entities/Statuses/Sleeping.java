package com.pokedex.domain.entities.statuses;

import com.pokedex.domain.entities.pokemon.Pokemon;
import com.pokedex.domain.ports.output.random.RandomProvider;

public class Sleeping implements Status {
    private static final int MIN_SLEEP_TURNS = 1;
    private static final int MAX_SLEEP_TURNS = 3;

    private int remainingTurns;
    private boolean turnsInitialized;

    public Sleeping() {
        this.turnsInitialized = false;
        this.remainingTurns = 0;
    }

    @Override
    public StatusList getStatusType() {
        return StatusList.Sleeping;
    }

    @Override
    public void applyEndOfTurnEffect(Pokemon pokemon) {
        // Sleep does not deal damage at end of turn
    }

    @Override
    public boolean preventsAction(RandomProvider random) {
        if (!turnsInitialized) {
            this.remainingTurns = MIN_SLEEP_TURNS + random.nextInt(MAX_SLEEP_TURNS - MIN_SLEEP_TURNS + 1);
            this.turnsInitialized = true;
        }

        if (remainingTurns <= 0) {
            return false;
        }

        remainingTurns--;
        return true;
    }

    public boolean isAwake() {
        return turnsInitialized && remainingTurns <= 0;
    }
}
