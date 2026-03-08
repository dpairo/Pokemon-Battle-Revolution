package com.pokedex.domain.entities.objects.berrys.health;

public enum HealthBerryType {
    ORAN_BERRY("Oran Berry", 10),
    SITRUS_BERRY("Sitrus Berry", 0.25),
    ENIGMA_BERRY("Enigma Berry", 0.25),
    BERRY_JUICE("Berry Juice", 20);

    private final String name;
    private final double restorationValue;

    HealthBerryType(String name, double restorationValue) {
        this.name = name;
        this.restorationValue = restorationValue;
    }

    public String getDisplayName() {
        return name;
    }

    public double getRestorationValue() {
        return restorationValue;
    }

    public boolean isPercentageBased() {
        return this == SITRUS_BERRY || this == ENIGMA_BERRY;
    }
}
