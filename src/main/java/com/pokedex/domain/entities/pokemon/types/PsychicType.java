package com.pokedex.domain.entities.pokemon.types;

public class PsychicType extends Type {
    public PsychicType() {
        type = TypeList.Psychic;
    }

    @Override
    public boolean takesSuperEffectiveDamage(TypeList attackingType) {
        return attackingType == TypeList.Bug || attackingType == TypeList.Ghost || attackingType == TypeList.Dark;
    }

    @Override
    public boolean dealsSuperEffectiveDamage(TypeList defendingType) {
        return defendingType == TypeList.Fighting || defendingType == TypeList.Poison;
    }

    @Override
    public boolean isEnemyImmuneTo(TypeList defendingType) {
        return defendingType == TypeList.Dark;
    }

    @Override
    public boolean isImmuneTo(TypeList attackingType) {
        return false;
    }

    @Override
    public boolean dealsNotEffectiveDamage(TypeList defendingType) {
        return defendingType == TypeList.Steel || defendingType == TypeList.Psychic;
    }

    @Override
    public boolean takesNotEffectiveDamage(TypeList attackingType) {
        return attackingType == TypeList.Fighting || attackingType == TypeList.Psychic;
    }
}
