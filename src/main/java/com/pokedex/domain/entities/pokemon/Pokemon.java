package com.pokedex.domain.entities.pokemon;

import com.pokedex.domain.entities.statuses.Status;
import com.pokedex.domain.entities.objects.Item;
import com.pokedex.domain.entities.pokemon.stats.Statistics;
import com.pokedex.domain.entities.pokemon.stats.StatList;
import com.pokedex.domain.entities.pokemon.stats.conversor.StatCalculator;
import com.pokedex.domain.entities.pokemon.stats.stage.StageChangeResult;
import com.pokedex.domain.entities.pokemon.stats.evs.EvChangeResult;
import com.pokedex.domain.entities.pokemon.stats.ivs.IvChangeResult;
import com.pokedex.domain.entities.pokemon.types.TypeList;

public class Pokemon {
    private static final int MIN_LEVEL = 1;
    private static final int MAX_LEVEL = 100;

    private Integer pokedexId;
    private String name;
    private TypeList firstType;
    private TypeList secondType;
    private Statistics stats;
    private Integer level;
    private Integer height;
    private Integer weight;
    private String spriteUrl;
    private Status status;
    private Item item;
    private boolean isStatused;
    private final StatCalculator statCalculator;

    public Pokemon(Integer pokedexId, String name, TypeList firstType, TypeList secondType, Statistics stats, Integer level, Integer height, Integer weight, String spriteUrl, StatCalculator statCalculator) {
        this.pokedexId = pokedexId;
        this.name = name;
        this.firstType = firstType;
        this.secondType = secondType;
        this.stats = stats;
        this.level = this.clampLevel(level);
        this.height = height;
        this.weight = weight;
        this.spriteUrl = spriteUrl;
        this.item = null;
        this.isStatused = false;
        this.statCalculator = statCalculator;

        this.recalculateStats();
    }

    public void recalculateStats() {
        this.statCalculator.calculateStatsAtLevel(this.stats, this.level);
        this.statCalculator.calculateBattleStats(this.stats);
    }

    public void recalculateBattleStats() {
        this.statCalculator.calculateBattleStats(this.stats);
    }

    private int clampLevel(int level) {
        return Math.max(MIN_LEVEL, Math.min(level, MAX_LEVEL));
    }

    public Integer getPokedexId() {
        return this.pokedexId;
    }

    public void setPokedexId(Integer pokedexId) {
        this.pokedexId = pokedexId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TypeList getFirstType() {
        return this.firstType;
    }

    public void setFirstType(TypeList firstType) {
        this.firstType = firstType;
    }

    public TypeList getSecondType() {
        return this.secondType;
    }

    public void setSecondType(TypeList secondType) {
        this.secondType = secondType;
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

    public Integer getHeight() {
        return this.height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWeight() {
        return this.weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getSpriteUrl() {
        return this.spriteUrl;
    }

    public void setSpriteUrl(String spriteUrl) {
        this.spriteUrl = spriteUrl;
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
        EvChangeResult result = this.stats.getPokemonEvs().applyChange(stat, change, this.name);
        if (result.wasApplied()) {
            this.recalculateStats();
        }
        return result;
    }

    public IvChangeResult applyIvChange(StatList stat, int change) {
        IvChangeResult result = this.stats.getPokemonIvs().applyChange(stat, change, this.name);
        if (result.wasApplied()) {
            this.recalculateStats();
        }
        return result;
    }

    public StageChangeResult applyStageChange(StatList stat, int change) {
        StageChangeResult result = this.stats.applyStageChange(stat, change, this.name);
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
}
