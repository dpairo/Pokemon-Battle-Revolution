package com.pokedex.domain.entities.pokemon;

import com.pokedex.domain.entities.pokedex.PokedexEntry;
import com.pokedex.domain.entities.pokemon.abilities.Ability;
import com.pokedex.domain.entities.pokemon.moves.Move;
import com.pokedex.domain.entities.statuses.Status;
import com.pokedex.domain.entities.objects.Item;
import com.pokedex.domain.entities.pokemon.stats.Statistics;
import com.pokedex.domain.entities.pokemon.stats.StatList;
import com.pokedex.domain.entities.pokemon.stats.conversor.StatCalculator;
import com.pokedex.domain.entities.pokemon.stats.stage.StageChangeResult;
import com.pokedex.domain.entities.pokemon.stats.evs.EvChangeResult;
import com.pokedex.domain.entities.pokemon.stats.ivs.IvChangeResult;
import com.pokedex.domain.entities.pokemon.types.TypeList;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Pokemon {
    private static final int MIN_LEVEL = 1;
    private static final int MAX_LEVEL = 100;

    private final PokedexEntry entry;
    private Statistics stats;
    private Integer level;
    private Status status;
    private Item item;
    private boolean isStatused;
    private Ability ability;
    private List<Move> moves;
    private final StatCalculator statCalculator;

    public Pokemon(PokedexEntry entry, Statistics stats, Integer level, StatCalculator statCalculator) {
        this.entry = entry;
        this.stats = stats;
        this.level = this.clampLevel(level);
        this.item = null;
        this.isStatused = false;
        this.ability = null;
        this.moves = new ArrayList<>();
        this.statCalculator = statCalculator;

        this.recalculateStats();
    }

    public void recalculateStats() {
        this.statCalculator.calculateStatsAtLevel(this.stats, this.level);
        this.statCalculator.calculateBattleStats(this.stats);
    }

    public void recalculateBattleStats() {
        this.statCalculator.recalculateBattleStatsAfterStageChange(this.stats);
    }

    private int clampLevel(int level) {
        return Math.max(MIN_LEVEL, Math.min(level, MAX_LEVEL));
    }

    public PokedexEntry getEntry() {
        return this.entry;
    }

    public Integer getPokedexId() {
        return this.entry.getPokedexId();
    }

    public String getName() {
        return this.entry.getName();
    }

    public TypeList getFirstType() {
        return this.entry.getFirstType();
    }

    public TypeList getSecondType() {
        return this.entry.getSecondType();
    }

    public Statistics getStats() {
        return this.stats;
    }

    public void setStats(Statistics stats) {
        this.stats = stats;
        this.recalculateStats();
    }

    public Integer getLevel() {
        return this.level;
    }

    public void setLevel(Integer level) {
        this.level = this.clampLevel(level);
        this.recalculateStats();
    }

    public Status getStatus() {
        return this.status;
    }

    public void setStatus(Status status) {
        this.status = status;
        this.isStatused = (status != null);
    }

    public Item getObject() {
        return this.item;
    }

    public void setObject(Item item) {
        this.item = item;
    }

    public boolean isStatused() {
        return this.isStatused;
    }

    public EvChangeResult applyEvChange(StatList stat, int change) {
        EvChangeResult result = this.stats.getPokemonEvs().applyChange(stat, change, this.getName());
        if (result.wasApplied()) {
            this.recalculateStats();
        }
        return result;
    }

    public IvChangeResult applyIvChange(StatList stat, int change) {
        IvChangeResult result = this.stats.getPokemonIvs().applyChange(stat, change, this.getName());
        if (result.wasApplied()) {
            this.recalculateStats();
        }
        return result;
    }

    public StageChangeResult applyStageChange(StatList stat, int change) {
        StageChangeResult result = this.stats.applyStageChange(stat, change, this.getName());
        if (result.wasApplied()) {
            this.recalculateBattleStats();
        }

        return result;
    }

    public void setPokemonEvs(int hpEvs, int attackEvs, int defenseEvs, int specialAttackEvs, int specialDefenseEvs, int speedEvs) {
        this.stats.setPokemonEvs(hpEvs, attackEvs, defenseEvs, specialAttackEvs, specialDefenseEvs, speedEvs);
        this.recalculateStats();
    }

    public void setPokemonIvs(int hpIvs, int attackIvs, int defenseIvs, int specialAttackIvs, int specialDefenseIvs, int speedIvs) {
        this.stats.setPokemonIvs(hpIvs, attackIvs, defenseIvs, specialAttackIvs, specialDefenseIvs, speedIvs);
        this.recalculateStats();
    }

    public void resetAllEvs() {
        this.stats.resetAllEvs();
        this.recalculateStats();
    }

    public void resetAllIvs() {
        this.stats.resetAllIvs();
        this.recalculateStats();
    }

    public void setAllIvsToMax() {
        this.stats.setAllIvsToMax();
        this.recalculateStats();
    }

    public Ability getAbility() {
        return this.ability;
    }

    public void setAbility(Ability ability) {
        this.ability = ability;
    }

    public List<Move> getMoves() {
        return this.moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = new ArrayList<>(moves);
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) {
            return true;
        }
        if (otherObject == null || this.getClass() != otherObject.getClass()) {
            return false;
        }

        Pokemon otherPokemon = (Pokemon) otherObject;
        return Objects.equals(this.getPokedexId(), otherPokemon.getPokedexId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getPokedexId());
    }
}
