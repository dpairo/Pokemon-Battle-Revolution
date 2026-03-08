package com.pokedex.domain.entities.pokemon.moves;

import com.pokedex.domain.entities.pokemon.types.Type;

public abstract class Move {
    protected Type type;
    protected String name;
    protected String description;
    protected int accuracy;
    protected int powerPoints;
    protected int currentPowerPoints;
    protected int priority;
    protected boolean makesContact;

    protected boolean boostedByStab(Type type1, Type type2) {
        return type1.equals(this.type) || type2.equals(this.type);
    }
}
