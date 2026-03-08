package com.pokedex.domain.entities.pokemon.types;

public class PoisonType extends Type {
    public PoisonType() {
        type = TypeList.Poison;
    }

    @Override
    public boolean takesSuperEffectiveDamage(TypeList attackingType) {
        return attackingType == TypeList.Ground || attackingType == TypeList.Psychic;
    }

    @Override
    public boolean dealsSuperEffectiveDamage(TypeList defendingType) {
        return defendingType == TypeList.Grass || defendingType == TypeList.Fairy;
    }

    @Override
    public boolean isEnemyImmuneTo(TypeList defendingType) {
        return defendingType == TypeList.Steel;
    }

    @Override
    public boolean isImmuneTo(TypeList attackingType) {
        return false;
    }

    @Override
    public boolean dealsNotEffectiveDamage(TypeList defendingType) {
        return defendingType == TypeList.Poison || defendingType == TypeList.Ground || defendingType == TypeList.Rock || defendingType == TypeList.Ghost;
    }

    @Override
    public boolean takesNotEffectiveDamage(TypeList attackingType) {
        return attackingType == TypeList.Fighting || attackingType == TypeList.Poison || attackingType == TypeList.Bug || attackingType == TypeList.Grass
                || attackingType == TypeList.Fairy;
    }
}
