package com.pokedex.domain.entities.pokemon.types;

public class BugType extends Type {
    public BugType() {
        type = TypeList.Bug;
    }

    @Override
    public boolean takesSuperEffectiveDamage(TypeList attackingType) {
        return attackingType == TypeList.Fire || attackingType == TypeList.Flying || attackingType == TypeList.Rock;
    }

    @Override
    public boolean dealsSuperEffectiveDamage(TypeList defendingType) {
        return defendingType == TypeList.Grass || defendingType == TypeList.Psychic || defendingType == TypeList.Dark;
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
        return defendingType == TypeList.Fighting || defendingType == TypeList.Flying || defendingType == TypeList.Poison || defendingType == TypeList.Ghost
                || defendingType == TypeList.Steel || defendingType == TypeList.Fire || defendingType == TypeList.Fairy;
    }

    @Override
    public boolean takesNotEffectiveDamage(TypeList attackingType) {
        return attackingType == TypeList.Fighting || attackingType == TypeList.Ground || attackingType == TypeList.Grass;
    }
}
