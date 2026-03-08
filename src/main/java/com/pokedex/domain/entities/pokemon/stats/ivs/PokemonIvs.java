package com.pokedex.domain.entities.pokemon.stats.ivs;

import com.pokedex.domain.entities.pokemon.stats.StatList;

import java.util.EnumMap;
import java.util.Map;

public class PokemonIvs {
    public static final int INDIVIDUAL_IV_MAX = IvStat.IV_MAX;

    private final Map<StatList, IvStat> ivStats;

    public PokemonIvs() {
        this.ivStats = new EnumMap<>(StatList.class);
        this.initializeAllStats();
    }

    public PokemonIvs(int hpIvs, int attackIvs, int defenseIvs, int specialAttackIvs, int specialDefenseIvs, int speedIvs) {
        this.ivStats = new EnumMap<>(StatList.class);
        this.initializeWithValues(hpIvs, attackIvs, defenseIvs, specialAttackIvs, specialDefenseIvs, speedIvs);
    }

    private void initializeAllStats() {
        for (StatList stat : StatList.coreStats()) {
            this.ivStats.put(stat, new IvStat(stat));
        }
    }

    private void initializeWithValues(int hp, int attack, int defense, int specialAttack, int specialDefense, int speed) {
        this.ivStats.put(StatList.HP, new IvStat(StatList.HP, hp));
        this.ivStats.put(StatList.Attack, new IvStat(StatList.Attack, attack));
        this.ivStats.put(StatList.Defense, new IvStat(StatList.Defense, defense));
        this.ivStats.put(StatList.SpecialAttack, new IvStat(StatList.SpecialAttack, specialAttack));
        this.ivStats.put(StatList.SpecialDefense, new IvStat(StatList.SpecialDefense, specialDefense));
        this.ivStats.put(StatList.Speed, new IvStat(StatList.Speed, speed));
    }

    public IvChangeResult applyChange(StatList stat, int change, String pokemonName) {
        IvStat ivStat = this.ivStats.get(stat);

        if (ivStat == null) {
            return IvChangeResult.failed(stat, 0, "Stat no encontrada: " + stat);
        }

        return ivStat.applyChange(change, pokemonName);
    }

    public IvChangeResult increase(StatList stat, int amount, String pokemonName) {
        return this.applyChange(stat, Math.abs(amount), pokemonName);
    }

    public IvChangeResult decrease(StatList stat, int amount, String pokemonName) {
        return this.applyChange(stat, -Math.abs(amount), pokemonName);
    }

    public IvChangeResult setIvs(StatList stat, int value, String pokemonName) {
        IvStat ivStat = this.ivStats.get(stat);

        if (ivStat == null) {
            return IvChangeResult.failed(stat, 0, "Stat no encontrada: " + stat);
        }

        int currentValue = ivStat.getCurrentIvs();
        int difference = value - currentValue;

        return this.applyChange(stat, difference, pokemonName);
    }

    public IvStat getIvStat(StatList stat) {
        return this.ivStats.get(stat);
    }

    public int getIvs(StatList stat) {
        IvStat ivStat = this.ivStats.get(stat);

        return ivStat != null ? ivStat.getCurrentIvs() : 0;
    }

    public int getHpIvs() {
        return this.getIvs(StatList.HP);
    }

    public int getAttackIvs() {
        return this.getIvs(StatList.Attack);
    }

    public int getDefenseIvs() {
        return this.getIvs(StatList.Defense);
    }

    public int getSpecialAttackIvs() {
        return this.getIvs(StatList.SpecialAttack);
    }

    public int getSpecialDefenseIvs() {
        return this.getIvs(StatList.SpecialDefense);
    }

    public int getSpeedIvs() {
        return this.getIvs(StatList.Speed);
    }

    public int getTotalIvs() {
        return this.ivStats.values().stream()
                .mapToInt(IvStat::getCurrentIvs)
                .sum();
    }

    public void resetAll() {
        this.ivStats.values().forEach(IvStat::reset);
    }

    public void setAllToMax() {
        this.ivStats.values().forEach(IvStat::setToMax);
    }

    public void reset(StatList stat) {
        IvStat ivStat = this.ivStats.get(stat);

        if (ivStat != null) {
            ivStat.reset();
        }
    }

    public boolean canIncreaseIvs(StatList stat) {
        IvStat ivStat = this.ivStats.get(stat);

        return ivStat != null && ivStat.canIncrease();
    }

    public boolean canDecreaseIvs(StatList stat) {
        IvStat ivStat = this.ivStats.get(stat);

        return ivStat != null && ivStat.canDecrease();
    }

    public boolean isPerfect() {
        return this.ivStats.values().stream().allMatch(IvStat::isPerfect);
    }

    public int getPerfectIvCount() {
        return (int) this.ivStats.values().stream()
                .filter(IvStat::isPerfect)
                .count();
    }

    public boolean isValid() {
        for (IvStat ivStat : this.ivStats.values()) {
            if (ivStat.getCurrentIvs() < IvStat.IV_MIN || ivStat.getCurrentIvs() > IvStat.IV_MAX) {
                return false;
            }
        }

        return true;
    }

    @Override
    public String toString() {
        return String.format(
                "PokemonIvs{HP=%d, Atk=%d, Def=%d, SpAtk=%d, SpDef=%d, Spd=%d, Total=%d}",
                this.getHpIvs(),
                this.getAttackIvs(),
                this.getDefenseIvs(),
                this.getSpecialAttackIvs(),
                this.getSpecialDefenseIvs(),
                this.getSpeedIvs(),
                this.getTotalIvs()
        );
    }
}
