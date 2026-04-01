package com.pokedex.domain.entities.battlefield.field;

import com.pokedex.domain.entities.battlefield.field.conditions.Tailwind;
import com.pokedex.domain.entities.battlefield.field.hazards.Hazard;
import com.pokedex.domain.entities.battlefield.field.screens.ScreenList;
import com.pokedex.domain.entities.battlefield.field.screens.Screens;
import com.pokedex.domain.entities.pokemon.Pokemon;
import com.pokedex.domain.entities.pokemon.moves.Move;
import com.pokedex.domain.entities.user.Team;

import java.util.ArrayList;
import java.util.List;

public class FieldSide {
    private List<Hazard> hazards;
    private List<Screens> screens;
    private Team team;
    private Tailwind tailwind;
    private Pokemon pokemonAtBattleField;
    private Move moveUsedInTurn;

    public FieldSide(Team newTeam) {
        this.hazards = new ArrayList<>();
        this.screens = new ArrayList<>();
        this.team = new Team(newTeam);
        this.pokemonAtBattleField = null;
        this.tailwind = null;
        this.moveUsedInTurn = null;
    }

    public List<Hazard> getHazards() {
        return this.hazards;
    }

    public List<Screens> getScreens() {
        return this.screens;
    }

    public void addScreen(Screens screen) {
        this.screens.add(screen);
    }

    public void removeScreen(ScreenList type) {
        this.screens.removeIf(screen -> screen.getScreenType() == type);
    }

    public boolean hasScreen(ScreenList type) {
        return this.screens.stream().anyMatch(screen -> screen.getScreenType() == type && screen.isActive());
    }

    public void setTailwind(Tailwind tailwind) {
        this.tailwind = tailwind;
    }

    public Tailwind getTailwind() {
        return this.tailwind;
    }

    public boolean isTailwindActive() {
        return this.tailwind != null && this.tailwind.isActive();
    }

    public List<Pokemon> getPokemons() {
        return this.team.getPokemons();
    }

    public Team getTeam() {
        return this.team;
    }

    public Pokemon getActivePokemon() {
        return this.pokemonAtBattleField;
    }

    public boolean hasActivePokemon() {
        return this.pokemonAtBattleField != null && !this.pokemonAtBattleField.getStats().isFainted();
    }

    public boolean isDefeated() {
        return this.team.isDefeated();
    }

    public void setPokemonAtBattleField(int pokemonTeamId) {
        this.pokemonAtBattleField = this.getPokemons().get(pokemonTeamId);
    }

    public Pokemon getPokemonAtBattleField() {
        return this.pokemonAtBattleField;
    }

    public void setPokemonAtBattleField(Pokemon newPokemonAtBattleField) {
        this.pokemonAtBattleField = newPokemonAtBattleField;
    }

    public Move getMoveUsedInTurn() {
        return this.moveUsedInTurn;
    }

    public void setMoveUsedInTurn(Move moveUsedInTurn) {
        this.moveUsedInTurn = moveUsedInTurn;
    }
}
