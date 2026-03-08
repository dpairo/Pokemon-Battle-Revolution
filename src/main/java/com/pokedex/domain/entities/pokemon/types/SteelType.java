package com.pokedex.domain.entities.pokemon.types;

public class SteelType extends Type {
    public SteelType() {
        type = TypeList.Steel;
    }

    @Override
    public boolean takesSuperEffectiveDamage(TypeList attackingType) {
        return attackingType == TypeList.Fire || attackingType == TypeList.Fighting || attackingType == TypeList.Ground;
    }

    @Override
    public boolean dealsSuperEffectiveDamage(TypeList defendingType) {
        return defendingType == TypeList.Rock || defendingType == TypeList.Ice || defendingType == TypeList.Fairy;
    }

    @Override
    public boolean isEnemyImmuneTo(TypeList defendingType) {
        return false;
    }

    @Override
    public boolean isImmuneTo(TypeList attackingType) {
        return attackingType == TypeList.Poison;
    }

    @Override
    public boolean dealsNotEffectiveDamage(TypeList defendingType) {
        return defendingType == TypeList.Steel || defendingType == TypeList.Fire || defendingType == TypeList.Water || defendingType == TypeList.Electric;
    }

    @Override
    public boolean takesNotEffectiveDamage(TypeList attackingType) {
        return attackingType == TypeList.Normal || attackingType == TypeList.Flying || attackingType == TypeList.Rock || attackingType == TypeList.Bug
                || attackingType == TypeList.Steel || attackingType == TypeList.Grass || attackingType == TypeList.Psychic || attackingType == TypeList.Ice
                || attackingType == TypeList.Dragon || attackingType == TypeList.Fairy;
    }
}
