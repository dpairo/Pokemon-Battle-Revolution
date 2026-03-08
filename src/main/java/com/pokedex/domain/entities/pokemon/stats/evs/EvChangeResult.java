package com.pokedex.domain.entities.pokemon.stats.evs;

import com.pokedex.domain.entities.pokemon.stats.StatList;

public final class EvChangeResult {
    private final boolean applied;
    private final int actualChange;
    private final String message;
    private final boolean wasLimitedByIndividual;
    private final boolean wasLimitedByGlobal;
    private final StatList stat;
    private final int newValue;

    public EvChangeResult(boolean applied, int actualChange, String message, boolean wasLimitedByIndividual, boolean wasLimitedByGlobal, StatList stat, int newValue) {
        this.applied = applied;
        this.actualChange = actualChange;
        this.message = message;
        this.wasLimitedByIndividual = wasLimitedByIndividual;
        this.wasLimitedByGlobal = wasLimitedByGlobal;
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

    public boolean wasLimitedByIndividual() {
        return this.wasLimitedByIndividual;
    }

    public boolean wasLimitedByGlobal() {
        return this.wasLimitedByGlobal;
    }

    public boolean wasLimited() {
        return this.wasLimitedByIndividual || this.wasLimitedByGlobal;
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
        return this.applied && !this.wasLimited();
    }

    @Override
    public String toString() {
        return String.format(
                "EvChangeResult{stat=%s, applied=%s, actualChange=%+d, newValue=%d, limitedByIndividual=%s, limitedByGlobal=%s, message='%s'}",
                this.stat, this.applied, this.actualChange, this.newValue, this.wasLimitedByIndividual, this.wasLimitedByGlobal, this.message
        );
    }

    public static EvChangeResult success(StatList stat, int actualChange, int newValue, String message) {
        return new EvChangeResult(true, actualChange, message, false, false, stat, newValue);
    }

    public static EvChangeResult limitedByIndividual(StatList stat, int actualChange, int newValue, String message) {
        return new EvChangeResult(true, actualChange, message, true, false, stat, newValue);
    }

    public static EvChangeResult limitedByGlobal(StatList stat, int actualChange, int newValue, String message) {
        return new EvChangeResult(true, actualChange, message, false, true, stat, newValue);
    }

    public static EvChangeResult failed(StatList stat, int currentValue, String message) {
        return new EvChangeResult(false, 0, message, false, false, stat, currentValue);
    }

    public static EvChangeResult noChange(StatList stat, int currentValue) {
        String message = String.format("Los EVs de %s no cambiaron.", stat);

        return new EvChangeResult(false, 0, message, false, false, stat, currentValue);
    }
}
