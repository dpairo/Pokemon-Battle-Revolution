package com.pokedex.domain.entities.pokemon.stats.stage;

public class CriticalStage {
    private final static int MAX_STAGE = 4;
    private final static int MIN_STAGE = 1;

    private int currentStage;

    public CriticalStage() {
        this.currentStage = MIN_STAGE;
    }

    public void addCriticalStage() {
        if (this.currentStage < MAX_STAGE) {
            this.currentStage++;
        }
    }

    public int getCurrentStage() {
        return this.currentStage;
    }

    public int getMaxStage() {
        return MAX_STAGE;
    }

    public int getMinStage() {
        return MIN_STAGE;
    }

    public void resetCurrentStage() {
        this.currentStage = MIN_STAGE;
    }
}
