package com.pokedex.application.usecases.team;

import com.pokedex.domain.entities.pokemon.Pokemon;
import com.pokedex.domain.entities.user.Team;
import com.pokedex.domain.ports.input.team.CreateTeamUseCase;
import com.pokedex.domain.ports.input.team.ValidateTeamUseCase;
import com.pokedex.domain.ports.output.team.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreateTeamService implements CreateTeamUseCase {
    private final TeamRepository teamRepository;
    private final ValidateTeamUseCase validateTeamUseCase;

    public CreateTeamService(TeamRepository teamRepository, ValidateTeamUseCase validateTeamUseCase) {
        this.teamRepository = teamRepository;
        this.validateTeamUseCase = validateTeamUseCase;
    }

    @Override
    public Team execute(String teamName, List<Pokemon> pokemons, Long userId) {
        Team newTeam = new Team(teamName, pokemons);

        if (!this.validateTeamUseCase.execute(newTeam)) {
            throw new IllegalArgumentException("El equipo no es v\u00e1lido");
        }

        return teamRepository.saveTeam(newTeam, userId);
    }
}
