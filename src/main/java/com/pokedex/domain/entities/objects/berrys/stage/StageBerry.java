package com.pokedex.domain.entities.objects.berrys.stage;

import com.pokedex.domain.entities.objects.Consumable;
import com.pokedex.domain.entities.pokemon.Pokemon;
import com.pokedex.domain.entities.pokemon.stats.StatList;
import com.pokedex.domain.entities.pokemon.stats.stage.StageChangeResult;

public class StageBerry implements Consumable {
    private final StageBerryType type;

    public StageBerry(StageBerryType type) {
        this.type = type;
    }

    @Override
    public void loseObject(Pokemon pokemon) {
        pokemon.setObject(null);
    }

    protected void consume(Pokemon pokemon) {
        loseObject(pokemon);
    }

    @Override
    public String getName() {
        return type.getDisplayName();
    }

    public StageBerryType getBerryType() {
        return type;
    }

    public StatList getStatToBoost() {
        return type.getStat();
    }

    public int getStageBoost() {
        return type.getStageBoost();
    }

    public int getStageBoostWithRipen() {
        return type.getStageBoostWithRipen();
    }

    public StageBerryTrigger getTrigger() {
        return type.getTrigger();
    }

    public StageChangeResult applyStageBoost(Pokemon pokemon) {
        consume(pokemon);
        StatList stat = getStatToBoost();
        int boost = getStageBoost();
        return pokemon.getStats().applyStageChange(stat, boost, pokemon.getName());
    }

    public StageChangeResult applyStageBoostWithRipen(Pokemon pokemon) {
        consume(pokemon);
        StatList stat = getStatToBoost();
        int boost = getStageBoostWithRipen();
        return pokemon.getStats().applyStageChange(stat, boost, pokemon.getName());
    }
}
