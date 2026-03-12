package com.pokedex.domain.entities.pokemon.moves.categories;

import com.pokedex.domain.entities.pokemon.stats.StatList;

public interface Physical {
    default StatList getDefendingStat() { return StatList.Defense; }
    default StatList getAttackingStat() { return StatList.Attack; }
}
