package com.pokedex.domain.ports.input.pokemon;

import com.pokedex.domain.entities.pokedex.PokedexEntry;

public interface GetPokemonByIdUseCase {
    PokedexEntry execute(int pokedexId);
}
