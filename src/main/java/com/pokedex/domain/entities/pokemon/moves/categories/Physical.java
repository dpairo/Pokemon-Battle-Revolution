package com.pokedex.domain.entities.pokemon.moves.categories;

import com.pokedex.domain.entities.pokemon.stats.StatList;

public interface Physical {
    public StatList statToDamage = StatList.Defense;
    public StatList damagingStat = StatList.Attack;
    public int damage = 0;
}
