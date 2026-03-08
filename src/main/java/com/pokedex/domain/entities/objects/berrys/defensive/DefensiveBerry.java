package com.pokedex.domain.entities.objects.berrys.defensive;

import com.pokedex.domain.entities.objects.Consumable;
import com.pokedex.domain.entities.pokemon.Pokemon;
import com.pokedex.domain.entities.pokemon.types.TypeList;

public class DefensiveBerry implements Consumable {
    private static final double BASE_DAMAGE_MULTIPLIER = 0.5;
    private static final double RIPEN_DAMAGE_MULTIPLIER = 0.25;

    private final DefensiveBerryType type;

    public DefensiveBerry(DefensiveBerryType type) {
        this.type = type;
    }

    @Override
    public void loseObject(Pokemon pokemon) {
        pokemon.setObject(null);
    }

    protected void consume(Pokemon pokemon) {
        loseObject(pokemon);
    }

    @Override
    public String getName() {
        return type.getDisplayName();
    }

    public DefensiveBerryType getBerryType() {
        return type;
    }

    public TypeList getDefendsAgainstType() {
        return type.getDefendsAgainstType();
    }

    public boolean shouldActivate(TypeList attackingType, boolean isSuperEffective) {
        if (attackingType != type.getDefendsAgainstType()) {
            return false;
        }

        return !type.requiresSuperEffective() || isSuperEffective;
    }

    public DefensiveBerryResult applyDamageReduction(Pokemon pokemon, int incomingDamage,
                                                      TypeList attackingType, boolean isSuperEffective) {
        if (!shouldActivate(attackingType, isSuperEffective)) {
            return DefensiveBerryResult.notActivated(incomingDamage);
        }

        consume(pokemon);
        int reducedDamage = calculateReducedDamage(incomingDamage, false);
        return DefensiveBerryResult.activated(incomingDamage, reducedDamage, getName(), pokemon.getName());
    }

    public DefensiveBerryResult applyDamageReductionWithRipen(Pokemon pokemon, int incomingDamage,
                                                               TypeList attackingType, boolean isSuperEffective) {
        if (!shouldActivate(attackingType, isSuperEffective)) {
            return DefensiveBerryResult.notActivated(incomingDamage);
        }

        consume(pokemon);
        int reducedDamage = calculateReducedDamage(incomingDamage, true);
        return DefensiveBerryResult.activated(incomingDamage, reducedDamage, getName(), pokemon.getName());
    }

    public int calculateReducedDamage(int originalDamage, boolean withRipen) {
        double multiplier = withRipen ? RIPEN_DAMAGE_MULTIPLIER : BASE_DAMAGE_MULTIPLIER;
        return (int) (originalDamage * multiplier);
    }

    public double getBaseDamageMultiplier() {
        return BASE_DAMAGE_MULTIPLIER;
    }

    public double getRipenDamageMultiplier() {
        return RIPEN_DAMAGE_MULTIPLIER;
    }

    public boolean requiresSuperEffective() {
        return type.requiresSuperEffective();
    }
}
