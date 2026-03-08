package com.pokedex.domain.entities.pokemon.types;

public abstract class Type {
    protected TypeList type;

    public TypeList getType() {
        return type;
    }

    public void setType(TypeList type) {
        this.type = type;
    }

    public abstract boolean takesSuperEffectiveDamage(TypeList attackingType);
    public abstract boolean dealsSuperEffectiveDamage(TypeList defendingType);
    public abstract boolean isEnemyImmuneTo(TypeList defendingType);
    public abstract boolean isImmuneTo(TypeList attackingType);
    public abstract boolean dealsNotEffectiveDamage(TypeList defendingType);
    public abstract boolean takesNotEffectiveDamage(TypeList attackingType);

    public boolean equals(Type other) {
        if (other == null) {
            return false;
        }
        return this == other || this.type.equals(other.type);
    }
}
