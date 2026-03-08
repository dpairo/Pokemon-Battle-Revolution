package com.pokedex.domain.entities.objects.berrys.stage;

import com.pokedex.domain.entities.pokemon.stats.StatList;

import java.util.Random;

public class StarfBerry extends StageBerry {
    private static final StatList[] BOOSTABLE_STATS = {
        StatList.Attack,
        StatList.Defense,
        StatList.SpecialAttack,
        StatList.SpecialDefense,
        StatList.Speed
    };

    private final Random random;

    public StarfBerry() {
        super(StageBerryType.STARF_BERRY);
        this.random = new Random();
    }

    public StarfBerry(Random random) {
        super(StageBerryType.STARF_BERRY);
        this.random = random;
    }

    @Override
    public StatList getStatToBoost() {
        return BOOSTABLE_STATS[random.nextInt(BOOSTABLE_STATS.length)];
    }
}
