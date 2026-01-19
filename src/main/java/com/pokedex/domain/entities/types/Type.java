package com.pokedex.domain.entities.types;

public abstract class Type {
    TypeList type;

    public TypeList getType() {
        return type;
    }

    public void setType(TypeList type) {
        this.type = type;
    }

    public abstract boolean takesSuperEffectiveDamage(TypeList attackingType);
    public abstract boolean dealsSuperEffectiveDamage(TypeList defendingType);
    public abstract boolean isEnemyInmuneTo(TypeList defendingType);
    public abstract boolean areYouInmuneTo(TypeList attackingType);
    public abstract boolean dealsNotEffectiveDamage(TypeList defendingType);
    public abstract boolean takesNotEffectiveDamage(TypeList attackingType);
}
