package com.pokedex.domain.entities.pokemon.types;

public class RockType extends Type {
    public RockType() {
        type = TypeList.Rock;
    }

    @Override
    public boolean takesSuperEffectiveDamage(TypeList attackingType) {
        return attackingType == TypeList.Water || attackingType == TypeList.Grass || attackingType == TypeList.Fighting || attackingType == TypeList.Ground
                || attackingType == TypeList.Steel;
    }

    @Override
    public boolean dealsSuperEffectiveDamage(TypeList defendingType) {
        return defendingType == TypeList.Flying || defendingType == TypeList.Bug || defendingType == TypeList.Fire || defendingType == TypeList.Ice;
    }

    @Override
    public boolean isEnemyImmuneTo(TypeList defendingType) {
        return false;
    }

    @Override
    public boolean isImmuneTo(TypeList attackingType) {
        return false;
    }

    @Override
    public boolean dealsNotEffectiveDamage(TypeList defendingType) {
        return defendingType == TypeList.Fighting || defendingType == TypeList.Ground || defendingType == TypeList.Steel;
    }

    @Override
    public boolean takesNotEffectiveDamage(TypeList attackingType) {
        return attackingType == TypeList.Normal || attackingType == TypeList.Flying || attackingType == TypeList.Poison || attackingType == TypeList.Fire;
    }
}
