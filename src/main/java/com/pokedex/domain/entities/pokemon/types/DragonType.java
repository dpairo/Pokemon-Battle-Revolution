package com.pokedex.domain.entities.pokemon.types;

public class DragonType extends Type {
    public DragonType() {
        type = TypeList.Dragon;
    }

    @Override
    public boolean takesSuperEffectiveDamage(TypeList attackingType) {
        return attackingType == TypeList.Ice || attackingType == TypeList.Dragon || attackingType == TypeList.Fairy;
    }

    @Override
    public boolean dealsSuperEffectiveDamage(TypeList defendingType) {
        return defendingType == TypeList.Dragon;
    }

    @Override
    public boolean isEnemyImmuneTo(TypeList defendingType) {
        return defendingType == TypeList.Fairy;
    }

    @Override
    public boolean isImmuneTo(TypeList attackingType) {
        return false;
    }

    @Override
    public boolean dealsNotEffectiveDamage(TypeList defendingType) {
        return defendingType == TypeList.Steel;
    }

    @Override
    public boolean takesNotEffectiveDamage(TypeList attackingType) {
        return attackingType == TypeList.Fire || attackingType == TypeList.Water || attackingType == TypeList.Grass || attackingType == TypeList.Electric;
    }
}
