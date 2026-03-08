package com.pokedex.domain.entities.pokemon.types;

public class GhostType extends Type {
    public GhostType() {
        type = TypeList.Ghost;
    }

    @Override
    public boolean takesSuperEffectiveDamage(TypeList attackingType) {
        return attackingType == TypeList.Ghost || attackingType == TypeList.Dark;
    }

    @Override
    public boolean dealsSuperEffectiveDamage(TypeList defendingType) {
        return defendingType == TypeList.Ghost || defendingType == TypeList.Psychic;
    }

    @Override
    public boolean isEnemyImmuneTo(TypeList defendingType) {
        return defendingType == TypeList.Normal;
    }

    @Override
    public boolean isImmuneTo(TypeList attackingType) {
        return attackingType == TypeList.Normal || attackingType == TypeList.Fighting;
    }

    @Override
    public boolean dealsNotEffectiveDamage(TypeList defendingType) {
        return defendingType == TypeList.Dark;
    }

    @Override
    public boolean takesNotEffectiveDamage(TypeList attackingType) {
        return attackingType == TypeList.Poison || attackingType == TypeList.Bug;
    }
}
