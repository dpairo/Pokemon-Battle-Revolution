package com.pokedex.domain.entities.pokemon.moves.effects;

import com.pokedex.domain.entities.battlefield.BattleField;
import com.pokedex.domain.ports.output.random.DamageRollProvider;

public record MoveContext(BattleField field, DamageRollProvider random, int damageDealt) {}
