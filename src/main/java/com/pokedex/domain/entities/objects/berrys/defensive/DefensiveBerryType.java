package com.pokedex.domain.entities.objects.berrys.defensive;

import com.pokedex.domain.entities.pokemon.types.TypeList;

public enum DefensiveBerryType {
    OCCA_BERRY("Occa Berry", TypeList.Fire, true),
    PASSHO_BERRY("Passho Berry", TypeList.Water, true),
    WACAN_BERRY("Wacan Berry", TypeList.Electric, true),
    RINDO_BERRY("Rindo Berry", TypeList.Grass, true),
    YACHE_BERRY("Yache Berry", TypeList.Ice, true),
    CHOPLE_BERRY("Chople Berry", TypeList.Fighting, true),
    KEBIA_BERRY("Kebia Berry", TypeList.Poison, true),
    SHUCA_BERRY("Shuca Berry", TypeList.Ground, true),
    COBA_BERRY("Coba Berry", TypeList.Flying, true),
    PAYAPA_BERRY("Payapa Berry", TypeList.Psychic, true),
    TANGA_BERRY("Tanga Berry", TypeList.Bug, true),
    CHARTI_BERRY("Charti Berry", TypeList.Rock, true),
    KASIB_BERRY("Kasib Berry", TypeList.Ghost, true),
    HABAN_BERRY("Haban Berry", TypeList.Dragon, true),
    COLBUR_BERRY("Colbur Berry", TypeList.Dark, true),
    BABIRI_BERRY("Babiri Berry", TypeList.Steel, true),
    ROSELI_BERRY("Roseli Berry", TypeList.Fairy, true),
    CHILAN_BERRY("Chilan Berry", TypeList.Normal, false);

    private final String name;
    private final TypeList defendsAgainstType;
    private final boolean requiresSuperEffective;

    DefensiveBerryType(String name, TypeList defendsAgainstType, boolean requiresSuperEffective) {
        this.name = name;
        this.defendsAgainstType = defendsAgainstType;
        this.requiresSuperEffective = requiresSuperEffective;
    }

    public String getDisplayName() {
        return name;
    }

    public TypeList getDefendsAgainstType() {
        return defendsAgainstType;
    }

    public boolean requiresSuperEffective() {
        return requiresSuperEffective;
    }
}
