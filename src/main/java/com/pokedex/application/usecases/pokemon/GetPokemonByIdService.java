package com.pokedex.application.usecases.pokemon;

import com.pokedex.domain.entities.pokedex.PokedexEntry;
import com.pokedex.domain.ports.input.pokemon.GetPokemonByIdUseCase;
import com.pokedex.domain.ports.output.pokemon.PokemonDataProvider;
import org.springframework.stereotype.Service;

@Service
public class GetPokemonByIdService implements GetPokemonByIdUseCase {
    private final PokemonDataProvider pokemonDataProvider;

    public GetPokemonByIdService(PokemonDataProvider pokemonDataProvider) {
        this.pokemonDataProvider = pokemonDataProvider;
    }

    @Override
    public PokedexEntry execute(int pokedexId) {
        return pokemonDataProvider.findByPokedexId(pokedexId).orElseThrow(()
                -> new IllegalArgumentException("Pokemon no encontrado con id: " + pokedexId));
    }
}
