package com.pokedex.domain.entities.pokemon.types;

public class ElectricType extends Type {
    public ElectricType() {
        type = TypeList.Electric;
    }

    @Override
    public boolean takesSuperEffectiveDamage(TypeList attackingType) {
        return attackingType == TypeList.Ground;
    }

    @Override
    public boolean dealsSuperEffectiveDamage(TypeList defendingType) {
        return defendingType == TypeList.Water || defendingType == TypeList.Flying;
    }

    @Override
    public boolean isEnemyImmuneTo(TypeList defendingType) {
        return defendingType == TypeList.Ground;
    }

    @Override
    public boolean isImmuneTo(TypeList attackingType) {
        return false;
    }

    @Override
    public boolean dealsNotEffectiveDamage(TypeList defendingType) {
        return defendingType == TypeList.Electric || defendingType == TypeList.Grass || defendingType == TypeList.Dragon;
    }

    @Override
    public boolean takesNotEffectiveDamage(TypeList attackingType) {
        return attackingType == TypeList.Electric || attackingType == TypeList.Flying || attackingType == TypeList.Steel;
    }
}
