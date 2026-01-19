package com.pokedex.domain.entities.types;

public class GrassType extends Type {
    public GrassType() {
        type = TypeList.Grass;
    }

    @Override
    public boolean takesSuperEffectiveDamage(TypeList attackingType) {
        return attackingType == TypeList.Fire || attackingType == TypeList.Flying || attackingType == TypeList.Bug || attackingType == TypeList.Ice
                || attackingType == TypeList.Poison;
    }

    @Override
    public boolean dealsSuperEffectiveDamage(TypeList defendingType) {
        return defendingType == TypeList.Ground || defendingType == TypeList.Rock || defendingType == TypeList.Water;
    }

    @Override
    public boolean isEnemyInmuneTo(TypeList defendingType) {
        return false;
    }

    @Override
    public boolean areYouInmuneTo(TypeList attackingType) {
        return false;
    }

    @Override
    public boolean dealsNotEffectiveDamage(TypeList defendingType) {
        return defendingType == TypeList.Fire || defendingType == TypeList.Flying || defendingType == TypeList.Poison || defendingType == TypeList.Dragon
                || defendingType == TypeList.Bug || defendingType == TypeList.Steel || defendingType == TypeList.Grass;
    }

    @Override
    public boolean takesNotEffectiveDamage(TypeList attackingType) {
        return attackingType == TypeList.Water || attackingType == TypeList.Grass || attackingType == TypeList.Electric || attackingType == TypeList.Ground;
    }
}
