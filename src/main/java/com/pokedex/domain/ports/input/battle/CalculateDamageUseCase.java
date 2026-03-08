package com.pokedex.domain.ports.input.battle;

import com.pokedex.domain.entities.statuses.Status;
import com.pokedex.domain.entities.battlefield.field.hazards.Hazard;
import com.pokedex.domain.entities.pokemon.Pokemon;

public interface CalculateDamageUseCase {
    public Pokemon getAttacker(Pokemon attacker);
    public Pokemon getDefender(Pokemon defender);
    public Hazard getHazards();
    public Status getStatus();
}
