package com.pokedex.domain.entities.pokemon.stats;

import com.pokedex.domain.entities.pokemon.stats.stage.CriticalStage;
import com.pokedex.domain.entities.pokemon.stats.stage.StageChangeResult;
import com.pokedex.domain.entities.pokemon.stats.stage.StatStage;

public class BattleStats {
    private int hpAtBattle;
    private int attackAtBattle;
    private int defenceAtBattle;
    private int specialAttackAtBattle;
    private int specialDefenceAtBattle;
    private int speedAtBattle;

    private final StatStage attackStage;
    private final StatStage defenceStage;
    private final StatStage specialAttackStage;
    private final StatStage specialDefenceStage;
    private final StatStage speedStage;
    private final StatStage accuracyStage;
    private final StatStage evasionStage;
    private final CriticalStage criticalStage;

    private int currentHp;
    private int maxHp;

    public BattleStats() {
        this.hpAtBattle = 0;
        this.attackAtBattle = 0;
        this.defenceAtBattle = 0;
        this.specialAttackAtBattle = 0;
        this.specialDefenceAtBattle = 0;
        this.speedAtBattle = 0;

        this.attackStage = new StatStage(StatList.Attack);
        this.defenceStage = new StatStage(StatList.Defense);
        this.specialAttackStage = new StatStage(StatList.SpecialAttack);
        this.specialDefenceStage = new StatStage(StatList.SpecialDefense);
        this.speedStage = new StatStage(StatList.Speed);
        this.accuracyStage = new StatStage(StatList.Precision);
        this.evasionStage = new StatStage(StatList.Evasion);
        this.criticalStage = new CriticalStage();

        this.currentHp = 0;
        this.maxHp = 0;
    }

    public int getHpAtBattle() {
        return this.hpAtBattle;
    }

    public void setHpAtStartingBattle(int hpAtBattle) {
        this.hpAtBattle = hpAtBattle;
        this.maxHp = hpAtBattle;
        this.currentHp = hpAtBattle;
    }

    public int getAttackAtBattle() {
        return this.attackAtBattle;
    }

    public void setAttackAtBattle(int attackAtBattle) {
        this.attackAtBattle = attackAtBattle;
    }

    public int getDefenceAtBattle() {
        return this.defenceAtBattle;
    }

    public void setDefenceAtBattle(int defenceAtBattle) {
        this.defenceAtBattle = defenceAtBattle;
    }

    public int getSpecialAttackAtBattle() {
        return this.specialAttackAtBattle;
    }

    public void setSpecialAttackAtBattle(int specialAttackAtBattle) {
        this.specialAttackAtBattle = specialAttackAtBattle;
    }

    public int getSpecialDefenceAtBattle() {
        return this.specialDefenceAtBattle;
    }

    public void setSpecialDefenceAtBattle(int specialDefenceAtBattle) {
        this.specialDefenceAtBattle = specialDefenceAtBattle;
    }

    public int getSpeedAtBattle() {
        return this.speedAtBattle;
    }

    public void setSpeedAtBattle(int speedAtBattle) {
        this.speedAtBattle = speedAtBattle;
    }

    public int getAttackStageValue() {
        return this.attackStage.getCurrentStage();
    }

    public int getDefenceStageValue() {
        return this.defenceStage.getCurrentStage();
    }

    public int getSpecialAttackStageValue() {
        return this.specialAttackStage.getCurrentStage();
    }

    public int getSpecialDefenceStageValue() {
        return this.specialDefenceStage.getCurrentStage();
    }

    public int getSpeedStageValue() {
        return this.speedStage.getCurrentStage();
    }

    public int getAccuracyStageValue() {
        return this.accuracyStage.getCurrentStage();
    }

    public int getEvasionStageValue() {
        return this.evasionStage.getCurrentStage();
    }

    public StageChangeResult applyStageChange(StatList stat, int change, String pokemonName) {
        return switch (stat) {
            case Attack -> this.attackStage.applyChange(change, pokemonName);
            case Defense -> this.defenceStage.applyChange(change, pokemonName);
            case SpecialAttack -> this.specialAttackStage.applyChange(change, pokemonName);
            case SpecialDefense -> this.specialDefenceStage.applyChange(change, pokemonName);
            case Speed -> this.speedStage.applyChange(change, pokemonName);
            case Precision -> this.accuracyStage.applyChange(change, pokemonName);
            case Evasion -> this.evasionStage.applyChange(change, pokemonName);
            default -> new StageChangeResult(false, 0, "HP no tiene stages", false);
        };
    }

    public void resetAllStages() {
        this.attackStage.reset();
        this.defenceStage.reset();
        this.specialAttackStage.reset();
        this.specialDefenceStage.reset();
        this.speedStage.reset();
        this.accuracyStage.reset();
        this.evasionStage.reset();
    }

    public int getCurrentHp() {
        return this.currentHp;
    }

    public int getMaxHp() {
        return this.maxHp;
    }

    public void takeDamage(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("El dano no puede ser negativo");
        }
        this.currentHp = Math.max(0, this.currentHp - amount);
    }

    public void heal(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("La curacion no puede ser negativa");
        }
        this.currentHp = Math.min(this.maxHp, this.currentHp + amount);
    }

    public boolean isFainted() {
        return this.currentHp == 0;
    }

    public int getStatValueByStat(StatList stat) {
        return switch (stat) {
            case HP ->  this.currentHp;
            case Attack -> this.attackAtBattle;
            case Defense -> this.defenceAtBattle;
            case SpecialAttack -> this.specialAttackAtBattle;
            case SpecialDefense -> this.specialDefenceAtBattle;
            case Speed -> this.speedAtBattle;
            default -> 0;
        };
    }

    public CriticalStage getCriticalStage() {
        return criticalStage;
    }

    @Override
    public String toString() {
        return String.format("BattleStats{HP=%d/%d, Atk=%d(%+d), Def=%d(%+d), SpAtk=%d(%+d), SpDef=%d(%+d), Spd=%d(%+d), Acc(%+d), Eva(%+d)}",
                this.currentHp, this.maxHp, this.attackAtBattle, this.attackStage.getCurrentStage(), this.defenceAtBattle,
                this.defenceStage.getCurrentStage(), this.specialAttackAtBattle, this.specialAttackStage.getCurrentStage(),
                this.specialDefenceAtBattle, this.specialDefenceStage.getCurrentStage(), this.speedAtBattle, this.speedStage.getCurrentStage(),
                this.accuracyStage.getCurrentStage(), this.evasionStage.getCurrentStage()
        );
    }
}
