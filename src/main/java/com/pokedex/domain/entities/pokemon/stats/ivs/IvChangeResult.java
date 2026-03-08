package com.pokedex.domain.entities.pokemon.stats.ivs;

import com.pokedex.domain.entities.pokemon.stats.StatList;

public final class IvChangeResult {
    private final boolean applied;
    private final int actualChange;
    private final String message;
    private final boolean wasLimited;
    private final StatList stat;
    private final int newValue;

    public IvChangeResult(boolean applied, int actualChange, String message, boolean wasLimited, StatList stat, int newValue) {
        this.applied = applied;
        this.actualChange = actualChange;
        this.message = message;
        this.wasLimited = wasLimited;
        this.stat = stat;
        this.newValue = newValue;
    }

    public boolean wasApplied() {
        return this.applied;
    }

    public int getActualChange() {
        return this.actualChange;
    }

    public String getMessage() {
        return this.message;
    }

    public boolean wasLimited() {
        return this.wasLimited;
    }

    public StatList getStat() {
        return this.stat;
    }

    public int getNewValue() {
        return this.newValue;
    }

    public boolean hasFailed() {
        return !this.applied && this.actualChange == 0;
    }

    public boolean wasFullyApplied() {
        return this.applied && !this.wasLimited;
    }

    @Override
    public String toString() {
        return String.format("IvChangeResult{stat=%s, applied=%s, actualChange=%+d, newValue=%d, wasLimited=%s, message='%s'}", this.stat, this.applied, this.actualChange, this.newValue, this.wasLimited, this.message);
    }

    public static IvChangeResult success(StatList stat, int actualChange, int newValue, String message) {
        return new IvChangeResult(true, actualChange, message, false, stat, newValue);
    }

    public static IvChangeResult limited(StatList stat, int actualChange, int newValue, String message) {
        return new IvChangeResult(true, actualChange, message, true, stat, newValue);
    }

    public static IvChangeResult failed(StatList stat, int currentValue, String message) {
        return new IvChangeResult(false, 0, message, false, stat, currentValue);
    }

    public static IvChangeResult noChange(StatList stat, int currentValue) {
        String message = String.format("Los IVs de %s no cambiaron.", stat);

        return new IvChangeResult(false, 0, message, false, stat, currentValue);
    }
}
