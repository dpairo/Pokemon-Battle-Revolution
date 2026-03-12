package com.pokedex.application.usecases.team;

import com.pokedex.domain.entities.pokemon.Pokemon;
import com.pokedex.domain.entities.user.Team;
import com.pokedex.domain.ports.input.team.ValidateTeamUseCase;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
public class ValidateTeamService implements ValidateTeamUseCase {
    private boolean haveDuplicatePokemons(Team team) {
        List<Pokemon> pokemons = team.getPokemons();
        return new HashSet<>(pokemons).size() < pokemons.size();
    }

    @Override
    public boolean execute(Team team) {
        if (team == null || team.getPokemons() == null || team.getPokemons().isEmpty() || team.getPokemons().size() > team.getMaxPokemons()) {
            return false;
        }
        return !haveDuplicatePokemons(team);
    }
}
