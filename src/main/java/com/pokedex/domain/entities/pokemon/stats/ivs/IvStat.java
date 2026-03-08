package com.pokedex.domain.entities.pokemon.stats.ivs;

import com.pokedex.domain.entities.pokemon.stats.StatList;

public class IvStat {
    public static final int IV_MIN = 0;
    public static final int IV_MAX = 31;

    private int currentIvs;
    private final StatList statName;

    public IvStat(StatList statName) {
        this.currentIvs = IV_MIN;
        this.statName = statName;
    }

    public IvStat(StatList statName, int initialIvs) {
        this.statName = statName;
        this.currentIvs = this.clamp(initialIvs);
    }

    public IvChangeResult applyChange(int change, String pokemonName) {
        if (change == 0) {
            return IvChangeResult.noChange(this.statName, this.currentIvs);
        }

        if (change > 0) {
            return this.applyIncrease(change, pokemonName);
        }
        else {
            return this.applyDecrease(Math.abs(change), pokemonName);
        }
    }

    private IvChangeResult applyIncrease(int amount, String pokemonName) {
        if (this.currentIvs >= IV_MAX) {
            String message = String.format("Los IVs de %s de %s ya están al máximo (31).", this.statName, pokemonName);

            return IvChangeResult.failed(this.statName, this.currentIvs, message);
        }

        int maxPossible = IV_MAX - this.currentIvs;
        int actualIncrease = Math.min(amount, maxPossible);
        boolean wasLimited = actualIncrease < amount;

        this.currentIvs += actualIncrease;
        String message = this.generateIncreaseMessage(actualIncrease, pokemonName);

        if (wasLimited) {
            return IvChangeResult.limited(this.statName, actualIncrease, this.currentIvs, message);
        }
        else {
            return IvChangeResult.success(this.statName, actualIncrease, this.currentIvs, message);
        }
    }

    private IvChangeResult applyDecrease(int amount, String pokemonName) {
        if (this.currentIvs <= IV_MIN) {
            String message = String.format("Los IVs de %s de %s ya están al mínimo (0).", this.statName, pokemonName);

            return IvChangeResult.failed(this.statName, this.currentIvs, message);
        }

        int actualDecrease = Math.min(amount, this.currentIvs);
        boolean wasLimited = actualDecrease < amount;

        this.currentIvs -= actualDecrease;
        String message = this.generateDecreaseMessage(actualDecrease, pokemonName);

        if (wasLimited) {
            return IvChangeResult.limited(this.statName, -actualDecrease, this.currentIvs, message);
        }
        else {
            return IvChangeResult.success(this.statName, -actualDecrease, this.currentIvs, message);
        }
    }

    private String generateIncreaseMessage(int actual, String pokemonName) {
        if (this.currentIvs == IV_MAX) {
            return String.format("Los IVs de %s de %s aumentaron al máximo (31).", this.statName, pokemonName);
        }

        return String.format("Los IVs de %s de %s aumentaron en %d. Ahora tiene %d IVs.", this.statName, pokemonName, actual, this.currentIvs);
    }

    private String generateDecreaseMessage(int actual, String pokemonName) {
        if (this.currentIvs == IV_MIN) {
            return String.format("Los IVs de %s de %s disminuyeron al mínimo (0).", this.statName, pokemonName);
        }

        return String.format("Los IVs de %s de %s disminuyeron en %d. Ahora tiene %d IVs.", this.statName, pokemonName, actual, this.currentIvs);
    }

    public void setIvs(int value) {
        this.currentIvs = this.clamp(value);
    }

    public void reset() {
        this.currentIvs = IV_MIN;
    }

    public void setToMax() {
        this.currentIvs = IV_MAX;
    }

    public int getCurrentIvs() {
        return this.currentIvs;
    }

    public StatList getStatName() {
        return this.statName;
    }

    public boolean canIncrease() {
        return this.currentIvs < IV_MAX;
    }

    public boolean canDecrease() {
        return this.currentIvs > IV_MIN;
    }

    public boolean isAtMaximum() {
        return this.currentIvs == IV_MAX;
    }

    public boolean isAtMinimum() {
        return this.currentIvs == IV_MIN;
    }

    public boolean isPerfect() {
        return this.currentIvs == IV_MAX;
    }

    public int getRemainingToMax() {
        return IV_MAX - this.currentIvs;
    }

    private int clamp(int value) {
        return Math.max(IV_MIN, Math.min(value, IV_MAX));
    }

    @Override
    public String toString() {
        return String.format("IvStat{%s=%d}", this.statName, this.currentIvs);
    }
}
