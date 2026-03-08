package com.pokedex.domain.entities.pokemon.stats.evs;

import com.pokedex.domain.entities.pokemon.stats.StatList;

public class EvStat {
    public static final int EV_MIN = 0;
    public static final int EV_MAX = 252;

    private int currentEvs;
    private final StatList statName;

    public EvStat(StatList statName) {
        this.currentEvs = EV_MIN;
        this.statName = statName;
    }

    public EvStat(StatList statName, int initialEvs) {
        this.statName = statName;
        this.currentEvs = this.clamp(initialEvs);
    }

    public EvChangeResult applyChange(int change, int availableGlobalEvs, String pokemonName) {
        if (change == 0) {
            return EvChangeResult.noChange(this.statName, this.currentEvs);
        }

        if (change > 0) {
            return this.applyIncrease(change, availableGlobalEvs, pokemonName);
        }
        else {
            return this.applyDecrease(Math.abs(change), pokemonName);
        }
    }

    private EvChangeResult applyIncrease(int amount, int availableGlobalEvs, String pokemonName) {
        if (this.currentEvs >= EV_MAX) {
            String message = String.format("Los EVs de %s de %s ya estan al maximo (252).", this.statName, pokemonName);

            return EvChangeResult.failed(this.statName, this.currentEvs, message);
        }

        if (availableGlobalEvs <= 0) {
            String message = String.format("No hay EVs globales disponibles para asignar a %s de %s.", this.statName, pokemonName);

            return EvChangeResult.failed(this.statName, this.currentEvs, message);
        }

        int maxByIndividual = EV_MAX - this.currentEvs;
        int maxByGlobal = availableGlobalEvs;

        int actualIncrease;
        boolean limitedByIndividual = false;
        boolean limitedByGlobal = false;

        if (amount <= maxByIndividual && amount <= maxByGlobal) {
            actualIncrease = amount;
        }
        else if (maxByIndividual <= maxByGlobal) {
            actualIncrease = maxByIndividual;
            limitedByIndividual = true;
        }
        else {
            actualIncrease = maxByGlobal;
            limitedByGlobal = true;
        }

        this.currentEvs += actualIncrease;
        String message = this.generateIncreaseMessage(amount, actualIncrease, pokemonName, limitedByIndividual, limitedByGlobal);

        if (limitedByIndividual) {
            return EvChangeResult.limitedByIndividual(this.statName, actualIncrease, this.currentEvs, message);
        }
        else if (limitedByGlobal) {
            return EvChangeResult.limitedByGlobal(this.statName, actualIncrease, this.currentEvs, message);
        }
        else {
            return EvChangeResult.success(this.statName, actualIncrease, this.currentEvs, message);
        }
    }

    private EvChangeResult applyDecrease(int amount, String pokemonName) {
        if (this.currentEvs <= EV_MIN) {
            String message = String.format("Los EVs de %s de %s ya estan al minimo (0).", this.statName, pokemonName);

            return EvChangeResult.failed(this.statName, this.currentEvs, message);
        }

        int actualDecrease = Math.min(amount, this.currentEvs);
        boolean wasLimited = actualDecrease < amount;

        this.currentEvs -= actualDecrease;
        String message = this.generateDecreaseMessage(amount, actualDecrease, pokemonName, wasLimited);

        if (wasLimited) {
            return EvChangeResult.limitedByIndividual(this.statName, -actualDecrease, this.currentEvs, message);
        }
        else {
            return EvChangeResult.success(this.statName, -actualDecrease, this.currentEvs, message);
        }
    }

    private String generateIncreaseMessage(int requested, int actual, String pokemonName, boolean limitedByIndividual, boolean limitedByGlobal) {
        if (this.currentEvs == EV_MAX) {
            return String.format("Los EVs de %s de %s aumentaron al maximo (252).", this.statName, pokemonName);
        }

        if (limitedByGlobal) {
            return String.format("Los EVs de %s de %s aumentaron en %d (limitado por EVs globales disponibles). Ahora tiene %d EVs.", this.statName, pokemonName, actual, this.currentEvs);
        }

        return String.format("Los EVs de %s de %s aumentaron en %d. Ahora tiene %d EVs.", this.statName, pokemonName, actual, this.currentEvs);
    }

    private String generateDecreaseMessage(int requested, int actual, String pokemonName, boolean wasLimited) {
        if (this.currentEvs == EV_MIN) {
            return String.format("Los EVs de %s de %s disminuyeron al minimo (0).", this.statName, pokemonName);
        }

        return String.format("Los EVs de %s de %s disminuyeron en %d. Ahora tiene %d EVs.", this.statName, pokemonName, actual, this.currentEvs);
    }

    public int calculateMaxPossibleIncrease(int amount, int availableGlobalEvs) {
        if (amount <= 0 || availableGlobalEvs <= 0) {
            return 0;
        }

        int maxByIndividual = EV_MAX - this.currentEvs;
        int maxByGlobal = availableGlobalEvs;

        return Math.min(amount, Math.min(maxByIndividual, maxByGlobal));
    }

    public int calculateMaxPossibleDecrease(int amount) {
        if (amount <= 0) {
            return 0;
        }

        return Math.min(amount, this.currentEvs);
    }

    public void setEvs(int value) {
        this.currentEvs = this.clamp(value);
    }

    public void reset() {
        this.currentEvs = EV_MIN;
    }

    public int getCurrentEvs() {
        return this.currentEvs;
    }

    public StatList getStatName() {
        return this.statName;
    }

    public boolean canIncrease() {
        return this.currentEvs < EV_MAX;
    }

    public boolean canDecrease() {
        return this.currentEvs > EV_MIN;
    }

    public boolean isAtMaximum() {
        return this.currentEvs == EV_MAX;
    }

    public boolean isAtMinimum() {
        return this.currentEvs == EV_MIN;
    }

    public int getRemainingToMax() {
        return EV_MAX - this.currentEvs;
    }

    private int clamp(int value) {
        return Math.max(EV_MIN, Math.min(value, EV_MAX));
    }

    @Override
    public String toString() {
        return String.format("EvStat{%s=%d}", this.statName, this.currentEvs);
    }
}
