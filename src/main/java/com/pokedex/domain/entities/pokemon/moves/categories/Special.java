package com.pokedex.domain.entities.pokemon.moves.categories;

import com.pokedex.domain.entities.pokemon.stats.StatList;

public interface Special {
    public StatList statToDamage = StatList.SpecialDefense;
    public StatList damagingStat = StatList.SpecialAttack;
    public int damage = 0;
}
