package com.pokedex.domain.entities.pokemon.stats;

import java.util.EnumSet;
import java.util.Set;

public enum StatList {
    HP, Attack, Defense, SpecialAttack, SpecialDefense, Speed, Precision, Evasion;

    private static final Set<StatList> CORE_STATS = EnumSet.of(
            HP, Attack, Defense, SpecialAttack, SpecialDefense, Speed
    );

    public static Set<StatList> coreStats() {
        return CORE_STATS;
    }

    public boolean isCoreStat() {
        return CORE_STATS.contains(this);
    }
}
