package com.pokedex.domain.entities.objects.berrys.stage;

import com.pokedex.domain.entities.pokemon.stats.StatList;

public enum StageBerryType {
    LIECHI_BERRY("Liechi Berry", StatList.Attack, 1, StageBerryTrigger.LOW_HP),
    GANLON_BERRY("Ganlon Berry", StatList.Defense, 1, StageBerryTrigger.LOW_HP),
    SALAC_BERRY("Salac Berry", StatList.Speed, 1, StageBerryTrigger.LOW_HP),
    PETAYA_BERRY("Petaya Berry", StatList.SpecialAttack, 1, StageBerryTrigger.LOW_HP),
    APICOT_BERRY("Apicot Berry", StatList.SpecialDefense, 1, StageBerryTrigger.LOW_HP),
    STARF_BERRY("Starf Berry", null, 2, StageBerryTrigger.LOW_HP),
    KEE_BERRY("Kee Berry", StatList.Defense, 1, StageBerryTrigger.PHYSICAL_HIT),
    MARANGA_BERRY("Maranga Berry", StatList.SpecialDefense, 1, StageBerryTrigger.SPECIAL_HIT);

    private final String name;
    private final StatList stat;
    private final int stageBoost;
    private final StageBerryTrigger trigger;

    StageBerryType(String name, StatList stat, int stageBoost, StageBerryTrigger trigger) {
        this.name = name;
        this.stat = stat;
        this.stageBoost = stageBoost;
        this.trigger = trigger;
    }

    public String getDisplayName() {
        return name;
    }

    public StatList getStat() {
        return stat;
    }

    public int getStageBoost() {
        return stageBoost;
    }

    public int getStageBoostWithRipen() {
        return stageBoost * 2;
    }

    public StageBerryTrigger getTrigger() {
        return trigger;
    }

    public boolean isRandomStat() {
        return this == STARF_BERRY;
    }
}
