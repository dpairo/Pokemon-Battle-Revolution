package com.pokedex.domain.entities.pokemon.stats.stage;

import com.pokedex.domain.entities.pokemon.stats.StatList;

public class StatStage {
    private static final int STAGE_MIN = -6;
    private static final int STAGE_MAX = 6;
    private static final int STAGE_NEUTRAL = 0;

    private int currentStage;
    private final StatList statName;

    public StatStage(StatList statName) {
        this.currentStage = STAGE_NEUTRAL;
        this.statName = statName;
    }

    public StageChangeResult applyChange(int change, String pokemonName) {
        if (change > 0 && this.currentStage >= STAGE_MAX) {
            String message = String.format("¡El %s de %s no puede subir más!", this.statName, pokemonName);

            return new StageChangeResult(false, 0, message, true);
        }

        if (change < 0 && this.currentStage <= STAGE_MIN) {
            String message = String.format("¡El %s de %s no puede bajar más!", this.statName, pokemonName);

            return new StageChangeResult(false, 0, message, true);
        }

        if (change == 0) {
            String message = String.format("El %s de %s no cambió.", this.statName, pokemonName);

            return new StageChangeResult(false, 0, message, false);
        }

        int previousStage = this.currentStage;
        int expectedStage = this.currentStage + change;

        this.currentStage = Math.max(STAGE_MIN, Math.min(expectedStage, STAGE_MAX));

        int actualChange = this.currentStage - previousStage;

        String message = this.generateMessage(change, actualChange, pokemonName);

        boolean wasLimited = (expectedStage != this.currentStage);

        return new StageChangeResult(true, actualChange, message, wasLimited);
    }

    private String generateMessage(int requestedChange, int actualChange, String pokemonName) {
        if (requestedChange > 0) {
            if (this.currentStage == STAGE_MAX) {
                return String.format("¡El %s de %s subió al máximo!", this.statName, pokemonName);
            }
            else if (Math.abs(actualChange) >= 2) {
                return String.format("¡El %s de %s subió mucho!", this.statName, pokemonName);
            }
            else {
                return String.format("¡El %s de %s subió!", this.statName, pokemonName);
            }
        }
        else {
            if (this.currentStage == STAGE_MIN) {
                return String.format("¡El %s de %s bajó al mínimo!", this.statName, pokemonName);
            }
            else if (Math.abs(actualChange) >= 2) {
                return String.format("¡El %s de %s bajó mucho!", this.statName, pokemonName);
            }
            else {
                return String.format("¡El %s de %s bajó!", this.statName, pokemonName);
            }
        }
    }

    public int getCurrentStage() {
        return this.currentStage;
    }

    public boolean canIncrease() {
        return this.currentStage < STAGE_MAX;
    }

    public boolean canDecrease() {
        return this.currentStage > STAGE_MIN;
    }

    public boolean isAtMaximum() {
        return this.currentStage == STAGE_MAX;
    }

    public boolean isAtMinimum() {
        return this.currentStage == STAGE_MIN;
    }

    public boolean isNeutral() {
        return this.currentStage == STAGE_NEUTRAL;
    }

    public void reset() {
        this.currentStage = STAGE_NEUTRAL;
    }

    public void setStage(int stage) {
        this.currentStage = Math.max(STAGE_MIN, Math.min(stage, STAGE_MAX));
    }

    public StatList getStatName() {
        return this.statName;
    }
}
