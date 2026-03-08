package com.pokedex.domain.entities.objects.berrys.defensive;

public class DefensiveBerryResult {
    private final int originalDamage;
    private final int reducedDamage;
    private final boolean berryActivated;
    private final String berryName;
    private final String message;

    private DefensiveBerryResult(int originalDamage, int reducedDamage, boolean berryActivated, String berryName, String message) {
        this.originalDamage = originalDamage;
        this.reducedDamage = reducedDamage;
        this.berryActivated = berryActivated;
        this.berryName = berryName;
        this.message = message;
    }

    public static DefensiveBerryResult activated(int originalDamage, int reducedDamage, String berryName, String pokemonName) {
        String message = String.format("%s's %s weakened the attack!", pokemonName, berryName);
        return new DefensiveBerryResult(originalDamage, reducedDamage, true, berryName, message);
    }

    public static DefensiveBerryResult notActivated(int damage) {
        return new DefensiveBerryResult(damage, damage, false, null, null);
    }

    public int getOriginalDamage() {
        return originalDamage;
    }

    public int getReducedDamage() {
        return reducedDamage;
    }

    public boolean wasBerryActivated() {
        return berryActivated;
    }

    public String getBerryName() {
        return berryName;
    }

    public String getMessage() {
        return message;
    }

    public int getDamageReduced() {
        return originalDamage - reducedDamage;
    }
}
