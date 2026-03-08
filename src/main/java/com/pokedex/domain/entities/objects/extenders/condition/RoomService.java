package com.pokedex.domain.entities.objects.extenders.condition;

import com.pokedex.domain.entities.battlefield.conditions.ConditionList;
import com.pokedex.domain.entities.objects.Consumable;
import com.pokedex.domain.entities.pokemon.Pokemon;

public class RoomService implements Consumable, ConditionExtender {
    private static final String NAME = "Room Service";
    private static final int EXTENSION_TURNS = 3;

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public void loseObject(Pokemon pokemon) {
        pokemon.setObject(null);
    }

    @Override
    public ConditionList getExtendedCondition() {
        return ConditionList.TRICK_ROOM;
    }

    @Override
    public int getExtensionTurns() {
        return EXTENSION_TURNS;
    }
}
