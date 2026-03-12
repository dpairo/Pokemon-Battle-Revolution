package com.pokedex.application.usecases.pokemon;

import com.pokedex.domain.entities.pokedex.PokedexEntry;
import com.pokedex.domain.ports.input.pokemon.GetPokemonByNameUseCase;
import com.pokedex.domain.ports.output.pokemon.PokemonDataProvider;
import org.springframework.stereotype.Service;

@Service
public class GetPokemonByNameService implements GetPokemonByNameUseCase {
    private final PokemonDataProvider pokemonDataProvider;

    public GetPokemonByNameService(PokemonDataProvider pokemonDataProvider) {
        this.pokemonDataProvider = pokemonDataProvider;
    }

    @Override
    public PokedexEntry execute(String pokemonName) {
        return pokemonDataProvider.findByName(pokemonName.toLowerCase().trim()).orElseThrow(()
                -> new IllegalArgumentException("Pokemon no encontrado: " + pokemonName));
    }
}
