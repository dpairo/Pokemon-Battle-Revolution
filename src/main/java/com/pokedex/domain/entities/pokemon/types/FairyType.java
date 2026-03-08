package com.pokedex.domain.entities.pokemon.types;

public class FairyType extends Type {
    public FairyType() {
        type = TypeList.Fairy;
    }

    @Override
    public boolean takesSuperEffectiveDamage(TypeList attackingType) {
        return attackingType == TypeList.Poison || attackingType == TypeList.Steel;
    }

    @Override
    public boolean dealsSuperEffectiveDamage(TypeList defendingType) {
        return defendingType == TypeList.Fighting || defendingType == TypeList.Dragon || defendingType == TypeList.Dark;
    }

    @Override
    public boolean isEnemyImmuneTo(TypeList defendingType) {
        return false;
    }

    @Override
    public boolean isImmuneTo(TypeList attackingType) {
        return attackingType == TypeList.Dragon;
    }

    @Override
    public boolean dealsNotEffectiveDamage(TypeList defendingType) {
        return defendingType == TypeList.Poison || defendingType == TypeList.Steel || defendingType == TypeList.Fire;
    }

    @Override
    public boolean takesNotEffectiveDamage(TypeList attackingType) {
        return attackingType == TypeList.Fighting || attackingType == TypeList.Bug || attackingType == TypeList.Dark;
    }
}
