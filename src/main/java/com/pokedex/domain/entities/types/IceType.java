package com.pokedex.domain.entities.types;

public class IceType extends Type {
    public IceType() {
        type = TypeList.Ice;
    }

    @Override
    public boolean takesSuperEffectiveDamage(TypeList attackingType) {
        return attackingType == TypeList.Fire || attackingType == TypeList.Fighting || attackingType == TypeList.Rock || attackingType == TypeList.Steel;
    }

    @Override
    public boolean dealsSuperEffectiveDamage(TypeList defendingType) {
        return defendingType == TypeList.Flying || defendingType == TypeList.Ground || defendingType == TypeList.Grass || defendingType == TypeList.Dragon;
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
        return defendingType == TypeList.Fire || defendingType == TypeList.Water || defendingType == TypeList.Ice || defendingType == TypeList.Steel;
    }

    @Override
    public boolean takesNotEffectiveDamage(TypeList attackingType) {
        return attackingType == TypeList.Ice;
    }
}
