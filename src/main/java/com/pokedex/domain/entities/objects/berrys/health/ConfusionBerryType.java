package com.pokedex.domain.entities.objects.berrys.health;

public enum ConfusionBerryType {
    FIGY_BERRY("Figy Berry", Flavor.SPICY),
    WIKI_BERRY("Wiki Berry", Flavor.DRY),
    MAGO_BERRY("Mago Berry", Flavor.SWEET),
    AGUAV_BERRY("Aguav Berry", Flavor.BITTER),
    IAPAPA_BERRY("Iapapa Berry", Flavor.SOUR);

    private final String name;
    private final Flavor flavor;

    ConfusionBerryType(String name, Flavor flavor) {
        this.name = name;
        this.flavor = flavor;
    }

    public String getDisplayName() {
        return name;
    }

    public Flavor getFlavor() {
        return flavor;
    }
}
