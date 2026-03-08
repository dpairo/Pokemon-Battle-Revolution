package com.pokedex.domain.entities.pokemon.types;

public class NormalType extends Type {
    public NormalType() {
        type = TypeList.Normal;
    }

    @Override
    public boolean takesSuperEffectiveDamage(TypeList attackingType) {
        return attackingType == TypeList.Fighting;
    }

    @Override
    public boolean dealsSuperEffectiveDamage(TypeList defendingType) {
        return false;
    }

    @Override
    public boolean isEnemyImmuneTo(TypeList defendingType) {
        return defendingType == TypeList.Ghost;
    }

    @Override
    public boolean isImmuneTo(TypeList attackingType) {
        return attackingType == TypeList.Ghost;
    }

    @Override
    public boolean dealsNotEffectiveDamage(TypeList defendingType) {
        return false;
    }

    @Override
    public boolean takesNotEffectiveDamage(TypeList attackingType) {
        return false;
    }
}
