package com.pokedex.domain.entities.user;

import com.pokedex.domain.entities.pokemon.Pokemon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Team {
    private final static int MAX_POKEMONS = 6;
    private List<Pokemon> pokemons;
    private String teamName;
    private Long id;

    public Team(String teamName, Long id) {
        this.pokemons = new ArrayList<Pokemon>(MAX_POKEMONS);
        this.teamName = teamName;
        this.id = id;
    }

    public Team(Team otherTeam) {
        this.teamName = otherTeam.teamName;
        this.pokemons = new ArrayList<Pokemon>(otherTeam.pokemons);
        this.id = otherTeam.id;
    }

    public void addPokemon(Pokemon pokemon) {
        if (isFull()) {
            throw new IllegalStateException("The team already has " + MAX_POKEMONS + " pokemon");
        }
        pokemons.add(pokemon);
    }

    private boolean isFull() {
        return pokemons.size() == MAX_POKEMONS;
    }

    public void removePokemon(Pokemon pokemon) {
        if (pokemon != null && pokemons.contains(pokemon)) {
            pokemons.remove(pokemon);
        }
    }

    public Long getId() {
        return id;
    }

    public String getTeamName() {
        return teamName;
    }
}
