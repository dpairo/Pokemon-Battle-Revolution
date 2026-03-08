package com.pokedex.domain.entities.pokemon.stats;

import com.pokedex.domain.entities.pokemon.stats.stage.StageChangeResult;
import com.pokedex.domain.entities.pokemon.stats.evs.PokemonEvs;
import com.pokedex.domain.entities.pokemon.stats.ivs.PokemonIvs;

public class Statistics {
    private final BaseStats baseStats;
    private final LevelStats levelStats;
    private final BattleStats battleStats;

    private PokemonEvs pokemonEvs;
    private PokemonIvs pokemonIvs;

    public Statistics(Short hp, Short attack, Short defence, Short specialAttack, Short specialDefence, Short speed) {
        this.baseStats = new BaseStats(hp, attack, defence, specialAttack, specialDefence, speed);
        this.levelStats = new LevelStats();
        this.battleStats = new BattleStats();

        this.pokemonEvs = new PokemonEvs();
        this.pokemonIvs = new PokemonIvs();
    }

    public BaseStats getBaseStats() {
        return this.baseStats;
    }

    public LevelStats getLevelStats() {
        return this.levelStats;
    }

    public BattleStats getBattleStats() {
        return this.battleStats;
    }

    public Short getBaseHp() {
        return this.baseStats.getHp();
    }

    public Short getBaseAttack() {
        return this.baseStats.getAttack();
    }

    public Short getBaseDefence() {
        return this.baseStats.getDefence();
    }

    public Short getBaseSpecialAttack() {
        return this.baseStats.getSpecialAttack();
    }

    public Short getBaseSpecialDefence() {
        return this.baseStats.getSpecialDefence();
    }

    public Short getBaseSpeed() {
        return this.baseStats.getSpeed();
    }

    public int getBaseStatsTotal() {
        return this.baseStats.getTotal();
    }

    public Integer getHpAtLevel() {
        return this.levelStats.getHp();
    }

    public void setHpAtLevel(Integer hpAtLevel) {
        this.levelStats.setHp(hpAtLevel);
    }

    public Integer getAttackAtLevel() {
        return this.levelStats.getAttack();
    }

    public void setAttackAtLevel(Integer attackAtLevel) {
        this.levelStats.setAttack(attackAtLevel);
    }

    public Integer getDefenceAtLevel() {
        return this.levelStats.getDefence();
    }

    public void setDefenceAtLevel(Integer defenceAtLevel) {
        this.levelStats.setDefence(defenceAtLevel);
    }

    public Integer getSpecialAttackAtLevel() {
        return this.levelStats.getSpecialAttack();
    }

    public void setSpecialAttackAtLevel(Integer specialAttackAtLevel) {
        this.levelStats.setSpecialAttack(specialAttackAtLevel);
    }

    public Integer getSpecialDefenceAtLevel() {
        return this.levelStats.getSpecialDefence();
    }

    public void setSpecialDefenceAtLevel(Integer specialDefenceAtLevel) {
        this.levelStats.setSpecialDefence(specialDefenceAtLevel);
    }

    public Integer getSpeedAtLevel() {
        return this.levelStats.getSpeed();
    }

    public void setSpeedAtLevel(Integer speedAtLevel) {
        this.levelStats.setSpeed(speedAtLevel);
    }

    public Integer getHpAtBattle() {
        return this.battleStats.getHpAtBattle();
    }

    public void setHpAtBattle(Integer hpAtBattle) {
        this.battleStats.setHpAtStartingBattle(hpAtBattle);
    }

    public Integer getAttackAtBattle() {
        return this.battleStats.getAttackAtBattle();
    }

    public void setAttackAtBattle(Integer attackAtBattle) {
        this.battleStats.setAttackAtBattle(attackAtBattle);
    }

    public Integer getDefenceAtBattle() {
        return this.battleStats.getDefenceAtBattle();
    }

    public void setDefenceAtBattle(Integer defenceAtBattle) {
        this.battleStats.setDefenceAtBattle(defenceAtBattle);
    }

    public Integer getSpecialAttackAtBattle() {
        return this.battleStats.getSpecialAttackAtBattle();
    }

    public void setSpecialAttackAtBattle(Integer specialAttackAtBattle) {
        this.battleStats.setSpecialAttackAtBattle(specialAttackAtBattle);
    }

    public Integer getSpecialDefenceAtBattle() {
        return this.battleStats.getSpecialDefenceAtBattle();
    }

    public void setSpecialDefenceAtBattle(Integer specialDefenceAtBattle) {
        this.battleStats.setSpecialDefenceAtBattle(specialDefenceAtBattle);
    }

    public Integer getSpeedAtBattle() {
        return this.battleStats.getSpeedAtBattle();
    }

    public void setSpeedAtBattle(Integer speedAtBattle) {
        this.battleStats.setSpeedAtBattle(speedAtBattle);
    }

    public int getAttackStageValue() {
        return this.battleStats.getAttackStageValue();
    }

    public int getDefenceStageValue() {
        return this.battleStats.getDefenceStageValue();
    }

    public int getSpecialAttackStageValue() {
        return this.battleStats.getSpecialAttackStageValue();
    }

    public int getSpecialDefenceStageValue() {
        return this.battleStats.getSpecialDefenceStageValue();
    }

    public int getSpeedStageValue() {
        return this.battleStats.getSpeedStageValue();
    }

    public int getAccuracyStageValue() {
        return this.battleStats.getAccuracyStageValue();
    }

    public int getEvasionStageValue() {
        return this.battleStats.getEvasionStageValue();
    }

    public StageChangeResult applyStageChange(StatList stat, int change, String pokemonName) {
        return this.battleStats.applyStageChange(stat, change, pokemonName);
    }

    public void resetAllStages() {
        this.battleStats.resetAllStages();
    }

    public PokemonEvs getPokemonEvs() {
        return this.pokemonEvs;
    }

    public void setPokemonEvs(int hpEvs, int attackEvs, int defenseEvs, int specialAttackEvs, int specialDefenseEvs, int speedEvs) {
        this.pokemonEvs = new PokemonEvs(hpEvs, attackEvs, defenseEvs, specialAttackEvs, specialDefenseEvs, speedEvs);
    }

    public void resetAllEvs() {
        this.pokemonEvs.resetAll();
    }

    public PokemonIvs getPokemonIvs() {
        return this.pokemonIvs;
    }

    public void setPokemonIvs(int hpIvs, int attackIvs, int defenseIvs, int specialAttackIvs, int specialDefenseIvs, int speedIvs) {
        this.pokemonIvs = new PokemonIvs(hpIvs, attackIvs, defenseIvs, specialAttackIvs, specialDefenseIvs, speedIvs);
    }

    public void resetAllIvs() {
        this.pokemonIvs.resetAll();
    }

    public void setAllIvsToMax() {
        this.pokemonIvs.setAllToMax();
    }

    public int getCurrentHp() {
        return this.battleStats.getCurrentHp();
    }

    public int getMaxHp() {
        return this.battleStats.getMaxHp();
    }

    public void takeDamage(int amount) {
        this.battleStats.takeDamage(amount);
    }

    public void heal(int amount) {
        this.battleStats.heal(amount);
    }

    public boolean isFainted() {
        return this.battleStats.isFainted();
    }

    @Override
    public String toString() {
        return String.format("Statistics{%s, %s, %s}", this.baseStats, this.levelStats, this.battleStats);
    }
}
