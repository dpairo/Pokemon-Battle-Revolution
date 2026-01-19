package com.pokedex.domain.entities.types;

public class FireType extends Type {
    public FireType() {
        type = TypeList.Fire;
    }

    @Override
    public boolean takesSuperEffectiveDamage(TypeList attackingType) {
        return attackingType == TypeList.Ground || attackingType == TypeList.Water || attackingType == TypeList.Rock;
    }

    @Override
    public boolean dealsSuperEffectiveDamage(TypeList defendingType) {
        return defendingType == TypeList.Grass || defendingType == TypeList.Steel || defendingType == TypeList.Bug;
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
        return defendingType == TypeList.Water || defendingType == TypeList.Dragon  || defendingType == TypeList.Fire || defendingType == TypeList.Rock;
    }

    @Override
    public boolean takesNotEffectiveDamage(TypeList attackingType) {
        return attackingType == TypeList.Bug || attackingType == TypeList.Grass || attackingType == TypeList.Fire || attackingType == TypeList.Steel
                || attackingType == TypeList.Ice || attackingType == TypeList.Fairy;
    }
}
