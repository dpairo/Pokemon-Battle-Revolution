package com.pokedex.domain.ports.input.team;

import com.pokedex.domain.entities.pokemon.Pokemon;
import com.pokedex.domain.entities.user.Team;

import java.util.List;

public interface CreateTeamUseCase {
    Team execute(String teamName, List<Pokemon> pokemons, Long userId);
}
