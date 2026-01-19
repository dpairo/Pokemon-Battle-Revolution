package com.pokedex.domain.entities.types;

public class WaterType extends Type {
    public WaterType() {
        type = TypeList.Water;
    }

    @Override
    public boolean takesSuperEffectiveDamage(TypeList attackingType) {
        return attackingType == TypeList.Electric || attackingType == TypeList.Grass;
    }

    @Override
    public boolean dealsSuperEffectiveDamage(TypeList defendingType) {
        return defendingType == TypeList.Fire || defendingType == TypeList.Rock || defendingType == TypeList.Ground;
    }

    @Override
    public boolean isEnemyInmuneTo(TypeList attackingType) {
        return false;
    }

    @Override
    public boolean areYouInmuneTo(TypeList attackingType) {
        return false;
    }

    @Override
    public boolean dealsNotEffectiveDamage(TypeList defendingType) {
        return defendingType == TypeList.Dragon || defendingType == TypeList.Water || defendingType == TypeList.Grass;
    }

    @Override
    public boolean takesNotEffectiveDamage(TypeList attackingType) {
        return attackingType == TypeList.Fire || attackingType == TypeList.Water || attackingType == TypeList.Ice || attackingType == TypeList.Steel;
    }
}
