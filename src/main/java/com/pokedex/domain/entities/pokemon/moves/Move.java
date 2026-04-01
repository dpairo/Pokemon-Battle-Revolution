package com.pokedex.domain.entities.pokemon.moves;

import com.pokedex.domain.entities.pokemon.moves.effects.MoveEffect;
import com.pokedex.domain.entities.pokemon.stats.StatList;
import com.pokedex.domain.entities.pokemon.types.Type;
import com.pokedex.domain.entities.pokemon.types.TypeList;

import java.util.ArrayList;
import java.util.List;

public abstract class Move {
    protected List<MoveEffect> effects;
    protected Type type;
    protected String name;
    protected String description;
    protected int accuracy;
    protected int basePower;
    protected int powerPoints;
    protected int currentPowerPoints;
    protected int priority;
    protected boolean makesContact;
    protected MoveCategory category;
    protected StatList statUsed;
    protected StatList statTargeted;
    protected boolean hitsAdjacent;
    protected boolean hitsBothEnemies;

    public Move(List<MoveEffect> effects) {
        this.effects = new ArrayList<>(effects);
    }

    public List<MoveEffect> getEffects() {
        return this.effects;
    }

    public Type getType() {
        return this.type;
    }

    public int getAccuracy() {
        return this.accuracy;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public int getPowerPoints() {
        return this.powerPoints;
    }

    public int getCurrentPowerPoints() {
        return this.currentPowerPoints;
    }

    public int getPriority() {
        return this.priority;
    }

    public boolean isMakesContact() {
        return this.makesContact;
    }

    public int getBasePower() {
        return this.basePower;
    }

    public MoveCategory getCategory() {
        return this.category;
    }

    public boolean isPhysical() {
        return this.category == MoveCategory.PHYSICAL;
    }

    public boolean isSpecial() {
        return this.category == MoveCategory.SPECIAL;
    }

    public boolean isStatusMove() {
        return this.category == MoveCategory.STATUS;
    }

    public boolean boostedByStab(Type type1, Type type2) {
        return type1.equals(this.type) || type2.equals(this.type);
    }

    public boolean getHitsAdjacent() {
        return this.hitsAdjacent;
    }

    public boolean getHitsBothEnemies() {
        return this.hitsBothEnemies;
    }

    public StatList getStatUsed() {
        return this.statUsed;
    }

    public StatList getStatTargeted() {
        return this.statTargeted;
    }
}
