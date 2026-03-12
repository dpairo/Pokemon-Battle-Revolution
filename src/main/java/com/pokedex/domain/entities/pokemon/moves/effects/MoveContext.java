package com.pokedex.domain.entities.pokemon.moves.effects;

import com.pokedex.domain.entities.battlefield.BattleField;
import com.pokedex.domain.ports.output.random.RandomProvider;

public record MoveContext(BattleField field, RandomProvider random, int damageDealt) {}
