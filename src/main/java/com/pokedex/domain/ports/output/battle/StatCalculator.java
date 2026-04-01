package com.pokedex.domain.ports.output.battle;

import com.pokedex.domain.entities.pokemon.stats.Statistics;

public interface StatCalculator {
    void calculateStatsAtLevel(Statistics stats, int level);
    void calculateBattleStats(Statistics stats);
    void recalculateBattleStatsAfterStageChange(Statistics stats);
    int calculateHpAtLevel(int baseHp, int iv, int ev, int level);
    int calculateStatAtLevel(int baseStat, int iv, int ev, int level);
}
