package com.pokedex.domain.entities.types;

public class DarkType extends Type {
    public DarkType() {
        type = TypeList.Dark;
    }

    @Override
    public boolean takesSuperEffectiveDamage(TypeList attackingType) {
        return attackingType == TypeList.Fighting || attackingType == TypeList.Bug || attackingType == TypeList.Fairy;
    }

    @Override
    public boolean dealsSuperEffectiveDamage(TypeList defendingType) {
        return defendingType == TypeList.Ghost || defendingType == TypeList.Psychic;
    }

    @Override
    public boolean isEnemyInmuneTo(TypeList defendingType) {
        return false;
    }

    @Override
    public boolean areYouInmuneTo(TypeList attackingType) {
        return attackingType == TypeList.Psychic;
    }

    @Override
    public boolean dealsNotEffectiveDamage(TypeList defendingType) {
        return defendingType == TypeList.Fighting || defendingType == TypeList.Dark || defendingType == TypeList.Fairy;
    }

    @Override
    public boolean takesNotEffectiveDamage(TypeList attackingType) {
        return attackingType == TypeList.Ghost || attackingType == TypeList.Dark;
    }
}
