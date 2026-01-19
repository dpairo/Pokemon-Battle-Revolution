package com.pokedex.domain.entities.types;

public class FightingType extends Type {
    public FightingType() {
        type = TypeList.Fighting;
    }

    @Override
    public boolean takesSuperEffectiveDamage(TypeList attackingType) {
        return attackingType == TypeList.Flying || attackingType == TypeList.Psychic || attackingType == TypeList.Fairy;
    }

    @Override
    public boolean dealsSuperEffectiveDamage(TypeList defendingType) {
        return defendingType == TypeList.Normal || defendingType == TypeList.Rock || defendingType == TypeList.Steel || defendingType == TypeList.Ice
                || defendingType == TypeList.Dark;
    }

    @Override
    public boolean isEnemyInmuneTo(TypeList defendingType) {
        return defendingType == TypeList.Ghost;
    }

    @Override
    public boolean areYouInmuneTo(TypeList attackingType) {
        return false;
    }

    @Override
    public boolean dealsNotEffectiveDamage(TypeList defendingType) {
        return defendingType == TypeList.Flying || defendingType == TypeList.Poison || defendingType == TypeList.Bug || defendingType == TypeList.Psychic
                || defendingType == TypeList.Fairy;
    }

    @Override
    public boolean takesNotEffectiveDamage(TypeList attackingType) {
        return attackingType == TypeList.Rock || attackingType == TypeList.Bug || attackingType == TypeList.Dark;
    }
}
