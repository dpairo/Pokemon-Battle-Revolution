package com.pokedex.domain.ports.output.pokedex;

import com.pokedex.domain.entities.pokedex.PokedexEntry;
import com.pokedex.domain.entities.pokedex.PokedexListEntry;

import java.util.List;

public interface PokedexProvider {
    List<PokedexListEntry> findAll(int limit, int offset);
}
