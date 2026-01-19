package com.pokedex.domain.entities.types;

public class FlyingType extends Type {
    public FlyingType() {
        type = TypeList.Flying;
    }

    @Override
    public boolean takesSuperEffectiveDamage(TypeList attackingType) {
        return attackingType == TypeList.Rock || attackingType == TypeList.Electric || attackingType == TypeList.Ice;
    }

    @Override
    public boolean dealsSuperEffectiveDamage(TypeList defendingType) {
        return defendingType == TypeList.Fighting || defendingType == TypeList.Bug || defendingType == TypeList.Grass;
    }

    @Override
    public boolean isEnemyInmuneTo(TypeList defendingType) {
        return false;
    }

    @Override
    public boolean areYouInmuneTo(TypeList attackingType) {
        return attackingType == TypeList.Ground;
    }

    @Override
    public boolean dealsNotEffectiveDamage(TypeList defendingType) {
        return defendingType == TypeList.Rock || defendingType == TypeList.Steel
                || defendingType == TypeList.Electric;
    }

    @Override
    public boolean takesNotEffectiveDamage(TypeList attackingType) {
        return attackingType == TypeList.Fighting || attackingType == TypeList.Bug
                || attackingType == TypeList.Grass;
    }
}
