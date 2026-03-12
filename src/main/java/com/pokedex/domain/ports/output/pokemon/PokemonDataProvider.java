package com.pokedex.domain.ports.output.pokemon;

import com.pokedex.domain.entities.pokedex.PokedexEntry;

import java.util.Optional;

public interface PokemonDataProvider {
    Optional<PokedexEntry> findByName(String name);
    Optional<PokedexEntry> findByPokedexId(int pokedexId);
}
