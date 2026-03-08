package com.pokedex.domain.entities.pokemon.types;

public class GroundType extends Type {
    public GroundType() {
        type = TypeList.Ground;
    }

    @Override
    public boolean takesSuperEffectiveDamage(TypeList attackingType) {
        return attackingType == TypeList.Water || attackingType == TypeList.Grass || attackingType == TypeList.Ice;
    }

    @Override
    public boolean dealsSuperEffectiveDamage(TypeList defendingType) {
        return defendingType == TypeList.Fire || defendingType == TypeList.Electric || defendingType == TypeList.Poison || defendingType == TypeList.Rock
                || defendingType == TypeList.Steel;
    }

    @Override
    public boolean isEnemyImmuneTo(TypeList defendingType) {
        return defendingType == TypeList.Flying;
    }

    @Override
    public boolean isImmuneTo(TypeList attackingType) {
        return attackingType == TypeList.Electric;
    }

    @Override
    public boolean dealsNotEffectiveDamage(TypeList defendingType) {
        return defendingType == TypeList.Bug || defendingType == TypeList.Grass;
    }

    @Override
    public boolean takesNotEffectiveDamage(TypeList attackingType) {
        return attackingType == TypeList.Poison || attackingType == TypeList.Rock;
    }
}
