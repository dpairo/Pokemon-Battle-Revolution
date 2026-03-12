package com.pokedex.domain.ports.input.team;

import com.pokedex.domain.entities.user.Team;

public interface ValidateTeamUseCase {
    boolean execute(Team team);
}
