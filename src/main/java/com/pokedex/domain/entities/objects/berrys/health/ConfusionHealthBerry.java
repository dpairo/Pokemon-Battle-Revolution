package com.pokedex.domain.entities.objects.berrys.health;

import com.pokedex.domain.entities.objects.Consumable;
import com.pokedex.domain.entities.pokemon.Pokemon;

public class ConfusionHealthBerry implements Consumable {
    private static final double HP_RESTORATION_PERCENTAGE = 1.0 / 3.0;
    private static final double HP_RESTORATION_PERCENTAGE_WITH_RIPEN = 2.0 / 3.0;

    private final ConfusionBerryType type;

    public ConfusionHealthBerry(ConfusionBerryType type) {
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

    public Flavor getFlavor() {
        return type.getFlavor();
    }

    public ConfusionBerryType getBerryType() {
        return type;
    }

    public double getHpRestorationPercentage() {
        return HP_RESTORATION_PERCENTAGE;
    }

    public double getHpRestorationPercentageWithRipen() {
        return HP_RESTORATION_PERCENTAGE_WITH_RIPEN;
    }

    public int getHpToRestore(Pokemon pokemon) {
        consume(pokemon);
        int maxHp = pokemon.getStats().getHpAtLevel();
        return (int) (maxHp * HP_RESTORATION_PERCENTAGE);
    }

    public int getHpToRestoreWithRipen(Pokemon pokemon) {
        consume(pokemon);
        int maxHp = pokemon.getStats().getHpAtLevel();
        return (int) (maxHp * HP_RESTORATION_PERCENTAGE_WITH_RIPEN);
    }
}
