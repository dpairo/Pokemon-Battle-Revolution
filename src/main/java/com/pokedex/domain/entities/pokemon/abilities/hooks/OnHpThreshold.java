package com.pokedex.domain.entities.pokemon.abilities.hooks;

import com.pokedex.domain.entities.pokemon.Pokemon;
import com.pokedex.domain.entities.pokemon.moves.Move;

public interface OnHpThreshold {
    double getThreshold();
    double onHpThreshold(Pokemon owner, Move move);
}
