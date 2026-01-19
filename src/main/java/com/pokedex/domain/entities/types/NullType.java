package com.pokedex.domain.entities.types;

public class NullType extends Type {
    public NullType() {
        type = TypeList.Null;
    }

    @Override
    public boolean takesSuperEffectiveDamage(TypeList attackingType) {
        return false;
    }

    @Override
    public boolean dealsSuperEffectiveDamage(TypeList defendingType) {
        return false;
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
        return false;
    }

    @Override
    public boolean takesNotEffectiveDamage(TypeList attackingType) {
        return false;
    }


}
