package com.pokedex.domain.entities.pokemon.stats.evs;

import com.pokedex.domain.entities.pokemon.stats.StatList;

import java.util.EnumMap;
import java.util.Map;

public class PokemonEvs {
    public static final int GLOBAL_EV_MAX = 510;
    public static final int INDIVIDUAL_EV_MAX = EvStat.EV_MAX;

    private final Map<StatList, EvStat> evStats;

    public PokemonEvs() {
        this.evStats = new EnumMap<>(StatList.class);
        this.initializeAllStats();
    }

    public PokemonEvs(int hpEvs, int attackEvs, int defenseEvs, int specialAttackEvs, int specialDefenseEvs, int speedEvs) {
        this.evStats = new EnumMap<>(StatList.class);
        this.initializeWithValues(hpEvs, attackEvs, defenseEvs, specialAttackEvs, specialDefenseEvs, speedEvs);
    }

    private void initializeAllStats() {
        for (StatList stat : StatList.coreStats()) {
            this.evStats.put(stat, new EvStat(stat));
        }
    }

    private void initializeWithValues(int hp, int attack, int defense, int specialAttack, int specialDefense, int speed) {
        this.evStats.put(StatList.HP, new EvStat(StatList.HP, hp));
        this.evStats.put(StatList.Attack, new EvStat(StatList.Attack, attack));
        this.evStats.put(StatList.Defense, new EvStat(StatList.Defense, defense));
        this.evStats.put(StatList.SpecialAttack, new EvStat(StatList.SpecialAttack, specialAttack));
        this.evStats.put(StatList.SpecialDefense, new EvStat(StatList.SpecialDefense, specialDefense));
        this.evStats.put(StatList.Speed, new EvStat(StatList.Speed, speed));

        int total = this.getTotalEvs();

        if (total > GLOBAL_EV_MAX) {
            this.adjustToGlobalLimit();
        }
    }

    public EvChangeResult applyChange(StatList stat, int change, String pokemonName) {
        EvStat evStat = this.evStats.get(stat);

        if (evStat == null) {
            return EvChangeResult.failed(stat, 0, "Stat no encontrada: " + stat);
        }

        int availableGlobal = this.getAvailableGlobalEvs();

        return evStat.applyChange(change, availableGlobal, pokemonName);
    }

    public EvChangeResult increase(StatList stat, int amount, String pokemonName) {
        return this.applyChange(stat, Math.abs(amount), pokemonName);
    }

    public EvChangeResult decrease(StatList stat, int amount, String pokemonName) {
        return this.applyChange(stat, -Math.abs(amount), pokemonName);
    }

    public EvChangeResult setEvs(StatList stat, int value, String pokemonName) {
        EvStat evStat = this.evStats.get(stat);

        if (evStat == null) {
            return EvChangeResult.failed(stat, 0, "Stat no encontrada: " + stat);
        }

        int currentValue = evStat.getCurrentEvs();
        int difference = value - currentValue;

        return this.applyChange(stat, difference, pokemonName);
    }

    public EvStat getEvStat(StatList stat) {
        return this.evStats.get(stat);
    }

    public int getEvs(StatList stat) {
        EvStat evStat = this.evStats.get(stat);

        return evStat != null ? evStat.getCurrentEvs() : 0;
    }

    public int getHpEvs() {
        return this.getEvs(StatList.HP);
    }

    public int getAttackEvs() {
        return this.getEvs(StatList.Attack);
    }

    public int getDefenseEvs() {
        return this.getEvs(StatList.Defense);
    }

    public int getSpecialAttackEvs() {
        return this.getEvs(StatList.SpecialAttack);
    }

    public int getSpecialDefenseEvs() {
        return this.getEvs(StatList.SpecialDefense);
    }

    public int getSpeedEvs() {
        return this.getEvs(StatList.Speed);
    }

    public int getTotalEvs() {
        return this.evStats.values().stream().mapToInt(EvStat::getCurrentEvs).sum();
    }

    public int getAvailableGlobalEvs() {
        return GLOBAL_EV_MAX - this.getTotalEvs();
    }

    public boolean isAtGlobalMaximum() {
        return this.getTotalEvs() >= GLOBAL_EV_MAX;
    }

    public boolean isAtGlobalMinimum() {
        return this.getTotalEvs() == 0;
    }

    public void resetAll() {
        this.evStats.values().forEach(EvStat::reset);
    }

    public void reset(StatList stat) {
        EvStat evStat = this.evStats.get(stat);

        if (evStat != null) {
            evStat.reset();
        }
    }

    public boolean canIncreaseEvs(StatList stat) {
        EvStat evStat = this.evStats.get(stat);

        if (evStat == null) {
            return false;
        }

        return evStat.canIncrease() && this.getAvailableGlobalEvs() > 0;
    }

    public boolean canDecreaseEvs(StatList stat) {
        EvStat evStat = this.evStats.get(stat);

        return evStat != null && evStat.canDecrease();
    }

    public int getMaxPossibleIncrease(StatList stat) {
        EvStat evStat = this.evStats.get(stat);

        if (evStat == null) {
            return 0;
        }

        int maxByIndividual = evStat.getRemainingToMax();
        int maxByGlobal = this.getAvailableGlobalEvs();

        return Math.min(maxByIndividual, maxByGlobal);
    }

    private void adjustToGlobalLimit() {
        int total = this.getTotalEvs();

        if (total <= GLOBAL_EV_MAX) {
            return;
        }

        double ratio = (double) GLOBAL_EV_MAX / total;

        for (EvStat evStat : this.evStats.values()) {
            int adjusted = (int) (evStat.getCurrentEvs() * ratio);
            evStat.setEvs(adjusted);
        }

        while (this.getTotalEvs() > GLOBAL_EV_MAX) {
            for (EvStat evStat : this.evStats.values()) {
                if (evStat.getCurrentEvs() > 0 && this.getTotalEvs() > GLOBAL_EV_MAX) {
                    evStat.setEvs(evStat.getCurrentEvs() - 1);
                }
            }
        }
    }

    public boolean isValid() {
        int total = this.getTotalEvs();

        if (total > GLOBAL_EV_MAX) {
            return false;
        }

        for (EvStat evStat : this.evStats.values()) {
            if (evStat.getCurrentEvs() < EvStat.EV_MIN || evStat.getCurrentEvs() > EvStat.EV_MAX) {
                return false;
            }
        }

        return true;
    }

    @Override
    public String toString() {
        return String.format(
                "PokemonEvs{HP=%d, Atk=%d, Def=%d, SpAtk=%d, SpDef=%d, Spd=%d, Total=%d/%d}",
                this.getHpEvs(),
                this.getAttackEvs(),
                this.getDefenseEvs(),
                this.getSpecialAttackEvs(),
                this.getSpecialDefenseEvs(),
                this.getSpeedEvs(),
                this.getTotalEvs(),
                GLOBAL_EV_MAX
        );
    }

    public String toDetailedString() {
        StringBuilder sb = new StringBuilder("PokemonEvs:\n");

        for (StatList stat : StatList.coreStats()) {
            EvStat evStat = this.evStats.get(stat);
            sb.append(String.format("  %s: %d/%d%s%n", stat, evStat.getCurrentEvs(), INDIVIDUAL_EV_MAX, evStat.isAtMaximum() ? " (MAX)" : ""));
        }

        sb.append(String.format("  Total: %d/%d%s", this.getTotalEvs(), GLOBAL_EV_MAX, this.isAtGlobalMaximum() ? " (MAX)" : ""));

        return sb.toString();
    }
}
