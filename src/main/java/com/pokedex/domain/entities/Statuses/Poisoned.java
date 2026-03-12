package com.pokedex.domain.entities.statuses;

public class Poisoned extends DamageOverTimeStatus {
    private static final double DAMAGE_FRACTION = 1.0 / 8.0;

    @Override
    public StatusList getStatusType() {
        return StatusList.Poisoned;
    }

    @Override
    protected double getDamageFraction() {
        return DAMAGE_FRACTION;
    }
}
