package com.pokedex.domain.entities.objects.berrys.stage;

import com.pokedex.domain.entities.pokemon.stats.StatList;
import com.pokedex.domain.ports.output.random.RandomProvider;

public class StarfBerry extends StageBerry {
    private static final StatList[] BOOSTABLE_STATS = {
        StatList.Attack,
        StatList.Defense,
        StatList.SpecialAttack,
        StatList.SpecialDefense,
        StatList.Speed
    };

    public StarfBerry() {
        super(StageBerryType.STARF_BERRY);
    }

    public StatList getStatToBoost(RandomProvider random) {
        return BOOSTABLE_STATS[random.nextInt(BOOSTABLE_STATS.length)];
    }
}
