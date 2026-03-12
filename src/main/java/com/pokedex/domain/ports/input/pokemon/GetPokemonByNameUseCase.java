package com.pokedex.domain.ports.input.pokemon;

import com.pokedex.domain.entities.pokedex.PokedexEntry;

public interface GetPokemonByNameUseCase {
    PokedexEntry execute(String pokemonName);
}
