package com.pokedex.domain.entities.pokemon.moves.categories;

import com.pokedex.domain.entities.pokemon.stats.StatList;

public interface Special {
    default StatList getDefendingStat() { return StatList.SpecialDefense; }
    default StatList getAttackingStat() { return StatList.SpecialAttack; }
}
