package com.pokedex.application.usecases.battle;

import com.pokedex.domain.entities.battlefield.BattleField;
import com.pokedex.domain.entities.battlefield.terrain.TerrainList;
import com.pokedex.domain.entities.battlefield.weather.WeatherList;
import com.pokedex.domain.entities.pokemon.Pokemon;
import com.pokedex.domain.entities.pokemon.moves.Move;
import com.pokedex.domain.entities.pokemon.stats.StatList;
import com.pokedex.domain.entities.pokemon.types.TypeList;
import com.pokedex.domain.ports.input.battle.CalculateDamageUseCase;
import com.pokedex.domain.ports.output.random.AccuracyHitProvider;
import com.pokedex.domain.ports.output.random.CriticalHitProvider;
import com.pokedex.domain.ports.output.random.DamageRollProvider;
import org.springframework.stereotype.Service;

@Service
public class CalculateDamageService implements CalculateDamageUseCase {
    private final DamageRollProvider damageRollProvider;
    private final CriticalHitProvider criticalHitProvider;
    private final AccuracyHitProvider accuracyHitProvider;

    public CalculateDamageService(DamageRollProvider damageRollProvider, CriticalHitProvider criticalHitProvider, AccuracyHitProvider accuracyHitProvider) {
        this.damageRollProvider = damageRollProvider;
        this.criticalHitProvider = criticalHitProvider;
        this.accuracyHitProvider = accuracyHitProvider;
    }

    private int calculateBaseDamage(int pokemonLevel, int movePower, int attack, int defense) {
        if (attack == 0 || defense == 0) {
            return 0;
        }

        return ((2 * pokemonLevel / 5 + 2) * movePower * attack / defense) / 50 + 2;
    }

    private int applyMultiTargetDebuff(boolean isDoubles, boolean hitsAdjacent, boolean hitBothEnemies, int damage) {
        if (!isDoubles) {
            return damage;
        }
        if (hitsAdjacent || hitBothEnemies) {
            return (damage * 3) / 4;
        }

        return damage;
    }

    private int weatherMultiplier(BattleField battleField, Move move, int damage) {
        if (battleField.getWeather().getWeather() == WeatherList.RAIN && move.getType().getType() == TypeList.Water) {
            damage = (damage * 3) / 2;
        }
        if (battleField.getWeather().getWeather() == WeatherList.RAIN && move.getType().getType() == TypeList.Fire) {
            damage = damage / 2;
        }
        if (battleField.getWeather().getWeather() == WeatherList.SUNNY_DAY && move.getType().getType() == TypeList.Water) {
            damage = damage / 2;
        }
        if (battleField.getWeather().getWeather() == WeatherList.SUNNY_DAY && move.getType().getType() == TypeList.Fire) {
            damage = (damage * 3) / 2;
        }

        return damage;
    }

    private int terrainMultiplier(BattleField battleField, Move move, int damage) {
        if (battleField.getTerrain().getTerrain() == TerrainList.ELECTRIC_TERRAIN && move.getType().getType() == TypeList.Electric) {
            damage = (damage * 3) / 2;
        }
        if (battleField.getTerrain().getTerrain() == TerrainList.GRASSY_TERRAIN && move.getType().getType() == TypeList.Grass) {
            damage = (damage * 3) / 2;
        }
        if (battleField.getTerrain().getTerrain() == TerrainList.PSYCHIC_TERRAIN && move.getType().getType() == TypeList.Psychic) {
            damage = (damage * 3) / 2;
        }
        if (battleField.getTerrain().getTerrain() == TerrainList.MISTY_TERRAIN && move.getType().getType() == TypeList.Fairy) {
            damage = (damage * 3) / 2;
        }

        return damage;
    }

    private int criticalHitMultiplier(int damage, Pokemon attacker){
        if (criticalHitProvider.execute(attacker.getStats().getBattleStats().getCriticalStage().getCurrentStage())) {
            damage = (damage * 3) / 2;
        }

        return damage;
    }

    private int applySTABMultiplier(Pokemon attacker, Move move, int damage) {
        if (attacker.getFirstType() == move.getType().getType() || attacker.getSecondType() == move.getType().getType()) {
            damage = (damage * 3) / 2;
        }

        return damage;
    }

    private int applyEffectivnessMultiplier(Move move, Pokemon defender, int damage) {
        if (move.getType().dealsSuperEffectiveDamage(defender.getFirstType())) {
            damage = damage * 2;
        }
        if (move.getType().dealsSuperEffectiveDamage(defender.getSecondType())) {
            damage = damage * 2;
        }
        if (move.getType().dealsNotEffectiveDamage(defender.getFirstType())) {
            damage = damage / 2;
        }
        if (move.getType().dealsNotEffectiveDamage(defender.getSecondType())) {
            damage = damage / 2;
        }
        if (defender.getEntry().getFirstType().isImmuneTo(move.getType().getType()) || defender.getEntry().getSecondType().isImmuneTo(move.getType().getType())) {
            damage = 0;
        }

        return damage;
    }

    private int getStatValue(StatList statType, Pokemon pokemon) {
         return switch (statType) {
             case SpecialAttack-> pokemon.getStats().getBattleStats().getStatValueByStat(StatList.SpecialAttack);
             case Attack -> pokemon.getStats().getBattleStats().getStatValueByStat(StatList.Attack);
             case Defense -> pokemon.getStats().getBattleStats().getStatValueByStat(StatList.Defense);
             case SpecialDefense -> pokemon.getStats().getBattleStats().getStatValueByStat(StatList.SpecialDefense);
             default -> 0;
        };
    }

    @Override
    public int execute(Move move, BattleField battleField, Pokemon attacker, Pokemon defender, boolean isDoubles) {
        if (!accuracyHitProvider.execute(move.getAccuracy())) {
            return 0;
        }

        int attackStat = getStatValue(move.getStatUsed(), attacker);
        int defenseStat = getStatValue(move.getStatTargeted(), defender);
        int finalDamage;

        finalDamage = calculateBaseDamage(attacker.getLevel(), move.getBasePower(), attackStat, defenseStat);
        finalDamage = applyMultiTargetDebuff(isDoubles, move.getHitsAdjacent(), move.getHitsBothEnemies(), finalDamage);
        finalDamage = weatherMultiplier(battleField, move, finalDamage);
        finalDamage = terrainMultiplier(battleField, move, finalDamage);
        finalDamage = criticalHitMultiplier(finalDamage, attacker);
        finalDamage = damageRollProvider.execute(finalDamage);
        finalDamage = applySTABMultiplier(attacker, move, finalDamage);
        finalDamage = applyEffectivnessMultiplier(move, defender, finalDamage);

        return finalDamage;
    }
}
