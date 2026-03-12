package com.pokedex.infrastructure.calculators;

import com.pokedex.domain.entities.pokemon.stats.Statistics;
import com.pokedex.domain.entities.pokemon.stats.conversor.StatCalculator;

public class PokemonStatCalculator implements StatCalculator {

    @Override
    public void calculateStatsAtLevel(Statistics stats, int level) {
        int hpAtLevel = calculateHpAtLevel(stats.getBaseHp(), stats.getPokemonIvs().getHpIvs(), stats.getPokemonEvs().getHpEvs(), level);
        int attackAtLevel = calculateStatAtLevel(stats.getBaseAttack(), stats.getPokemonIvs().getAttackIvs(), stats.getPokemonEvs().getAttackEvs(), level);
        int defenceAtLevel = calculateStatAtLevel(stats.getBaseDefence(), stats.getPokemonIvs().getDefenseIvs(), stats.getPokemonEvs().getDefenseEvs(), level);
        int specialAttackAtLevel = calculateStatAtLevel(stats.getBaseSpecialAttack(), stats.getPokemonIvs().getSpecialAttackIvs(), stats.getPokemonEvs().getSpecialAttackEvs(), level);
        int specialDefenceAtLevel = calculateStatAtLevel(stats.getBaseSpecialDefence(), stats.getPokemonIvs().getSpecialDefenseIvs(), stats.getPokemonEvs().getSpecialDefenseEvs(), level);
        int speedAtLevel = calculateStatAtLevel(stats.getBaseSpeed(), stats.getPokemonIvs().getSpeedIvs(), stats.getPokemonEvs().getSpeedEvs(), level);

        stats.setHpAtLevel(hpAtLevel);
        stats.setAttackAtLevel(attackAtLevel);
        stats.setDefenceAtLevel(defenceAtLevel);
        stats.setSpecialAttackAtLevel(specialAttackAtLevel);
        stats.setSpecialDefenceAtLevel(specialDefenceAtLevel);
        stats.setSpeedAtLevel(speedAtLevel);
    }

    @Override
    public void calculateBattleStats(Statistics stats) {
        stats.setHpAtBattle(stats.getHpAtLevel());
        stats.setAttackAtBattle(applyStageModifier(stats.getAttackAtLevel(), stats.getAttackStageValue()));
        stats.setDefenceAtBattle(applyStageModifier(stats.getDefenceAtLevel(), stats.getDefenceStageValue()));
        stats.setSpecialAttackAtBattle(applyStageModifier(stats.getSpecialAttackAtLevel(), stats.getSpecialAttackStageValue()));
        stats.setSpecialDefenceAtBattle(applyStageModifier(stats.getSpecialDefenceAtLevel(), stats.getSpecialDefenceStageValue()));
        stats.setSpeedAtBattle(applyStageModifier(stats.getSpeedAtLevel(), stats.getSpeedStageValue()));
    }

    @Override
    public void recalculateBattleStatsAfterStageChange(Statistics stats) {
        stats.setAttackAtBattle(applyStageModifier(stats.getAttackAtLevel(), stats.getAttackStageValue()));
        stats.setDefenceAtBattle(applyStageModifier(stats.getDefenceAtLevel(), stats.getDefenceStageValue()));
        stats.setSpecialAttackAtBattle(applyStageModifier(stats.getSpecialAttackAtLevel(), stats.getSpecialAttackStageValue()));
        stats.setSpecialDefenceAtBattle(applyStageModifier(stats.getSpecialDefenceAtLevel(), stats.getSpecialDefenceStageValue()));
        stats.setSpeedAtBattle(applyStageModifier(stats.getSpeedAtLevel(), stats.getSpeedStageValue()));
    }

    @Override
    public int calculateHpAtLevel(int baseHp, int iv, int ev, int level) {
        int evContribution = ev / 4;
        int result = ((2 * baseHp + iv + evContribution) * level / 100) + level + 10;

        return result;
    }

    @Override
    public int calculateStatAtLevel(int baseStat, int iv, int ev, int level) {
        int evContribution = ev / 4;
        int result = ((2 * baseStat + iv + evContribution) * level / 100) + 5;

        return result;
    }

    private int applyStageModifier(int stat, int stage) {
        if (stage == 0) {
            return stat;
        }

        double multiplier;

        if (stage > 0) {
            multiplier = (2.0 + stage) / 2.0;
        }
        else {
            multiplier = 2.0 / (2.0 - stage);
        }

        return (int) (stat * multiplier);
    }
}
