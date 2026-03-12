package com.pokedex.domain.entities.pokemon.moves;

import com.pokedex.domain.entities.pokemon.Pokemon;
import com.pokedex.domain.entities.pokemon.moves.effects.MoveContext;
import com.pokedex.domain.entities.pokemon.moves.effects.MoveEffect;
import com.pokedex.domain.entities.pokemon.moves.effects.MoveEffectResult;
import com.pokedex.domain.entities.pokemon.types.Type;

import java.util.ArrayList;
import java.util.List;

public abstract class Move {
    protected List<MoveEffect> effects;
    protected Type type;
    protected String name;
    protected String description;
    protected Double accuracy;
    protected int powerPoints;
    protected int currentPowerPoints;
    protected int priority;
    protected boolean makesContact;

    public Move(List<MoveEffect> effects) {
        this.effects = new ArrayList<>(effects);
    }

    public List<MoveEffect> getEffects() {
        return this.effects;
    }

    public Type getType() {
        return this.type;
    }

    public Double getAccuracy() {
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

    public boolean boostedByStab(Type type1, Type type2) {
        return type1.equals(this.type) || type2.equals(this.type);
    }

    public List<MoveEffectResult> applyEffects(Pokemon attacker, Pokemon defender, MoveContext context) {
        List<MoveEffectResult> results = new ArrayList<>();
        for (MoveEffect effect : this.effects) {
            if (context.random().rollChance(effect.getChancePercent())) {
                results.add(effect.apply(attacker, defender, context));
            } else {
                results.add(new MoveEffectResult(false, "El efecto secundario no se activ\u00f3."));
            }
        }
        return results;
    }
}
