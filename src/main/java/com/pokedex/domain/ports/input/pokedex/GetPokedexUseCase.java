package com.pokedex.domain.ports.input.pokedex;

import com.pokedex.domain.entities.pokedex.PokedexListEntry;

import java.util.List;

public interface GetPokedexUseCase {
    List<PokedexListEntry> execute(int limit, int offset);
}
