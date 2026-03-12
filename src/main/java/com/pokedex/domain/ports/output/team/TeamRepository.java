package com.pokedex.domain.ports.output.team;

import com.pokedex.domain.entities.user.Team;

import java.util.List;
import java.util.Optional;

public interface TeamRepository {
    Team saveTeam(Team team, Long userId);
    Optional<Team> findTeamById(Long teamId);
    List<Team> findAllTeams(Long userId);
    void deleteTeam(Long teamId);
}
