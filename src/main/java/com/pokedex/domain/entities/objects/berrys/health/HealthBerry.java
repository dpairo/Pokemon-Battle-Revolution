package com.pokedex.domain.entities.objects.berrys.health;

import com.pokedex.domain.entities.objects.Consumable;
import com.pokedex.domain.entities.pokemon.Pokemon;

public class HealthBerry implements Consumable {
    private final HealthBerryType type;

    public HealthBerry(HealthBerryType type) {
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

    public HealthBerryType getBerryType() {
        return type;
    }

    public int getHpToRestore(Pokemon pokemon) {
        consume(pokemon);
        if (type.isPercentageBased()) {
            int maxHp = pokemon.getStats().getHpAtLevel();
            return (int) (maxHp * type.getRestorationValue());
        }
        return (int) type.getRestorationValue();
    }
}
