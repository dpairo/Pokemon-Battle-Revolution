package com.pokedex.domain.entities.pokemon.types;

import java.util.Objects;

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

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || this.getClass() != other.getClass()) {
            return false;
        }
        return this.type == ((Type) other).type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.type);
    }
}
