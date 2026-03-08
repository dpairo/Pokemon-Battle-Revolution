package com.pokedex.domain.entities.pokemon.stats.stage;

public final class StageChangeResult {
    private final boolean applied;
    private final int actualChange;
    private final String information;
    private final boolean wasLimited;

    public StageChangeResult(boolean applied, int actualChange, String message, boolean wasLimited) {
        this.applied = applied;
        this.actualChange = actualChange;
        this.information = message;
        this.wasLimited = wasLimited;
    }

    public boolean wasApplied() {
        return this.applied;
    }

    public int getActualChange() {
        return this.actualChange;
    }

    public String getMessage() {
        return this.information;
    }

    public boolean wasLimited() {
        return this.wasLimited;
    }

    public boolean hasFailed() {
        return !this.applied && this.actualChange == 0;
    }

    public boolean wasFullyApplied() {
        return this.applied && !this.wasLimited;
    }

    @Override
    public String toString() {
        return String.format(
                "StageChangeResult{applied=%s, actualChange=%+d, wasLimited=%s, message='%s'}",
                this.applied, this.actualChange, this.wasLimited, this.information
        );
    }
}
