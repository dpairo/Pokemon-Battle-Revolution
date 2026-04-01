package com.pokedex.application.usecases.pokedex;

import com.pokedex.domain.entities.pokedex.PokedexListEntry;
import com.pokedex.domain.ports.input.pokedex.GetPokedexUseCase;
import com.pokedex.domain.ports.output.pokedex.PokedexProvider;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetPokedexService implements GetPokedexUseCase {
    private final PokedexProvider pokedexProvider;

    public GetPokedexService(PokedexProvider pokedexProvider) {
        this.pokedexProvider = pokedexProvider;
    }

    @Override
    public List<PokedexListEntry> execute(int limit, int offset) {
        return pokedexProvider.findAll(limit, offset);
    }
}
