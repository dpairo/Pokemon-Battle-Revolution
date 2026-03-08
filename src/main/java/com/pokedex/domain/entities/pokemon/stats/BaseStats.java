package com.pokedex.domain.entities.pokemon.stats;

public class BaseStats {

    private final short hp;
    private final short attack;
    private final short defence;
    private final short specialAttack;
    private final short specialDefence;
    private final short speed;

    public BaseStats(short hp, short attack, short defence, short specialAttack, short specialDefence, short speed) {
        this.hp = validateNonNegative(hp, "HP base");
        this.attack = validateNonNegative(attack, "Ataque base");
        this.defence = validateNonNegative(defence, "Defensa base");
        this.specialAttack = validateNonNegative(specialAttack, "Ataque especial base");
        this.specialDefence = validateNonNegative(specialDefence, "Defensa especial base");
        this.speed = validateNonNegative(speed, "Velocidad base");
    }

    private static short validateNonNegative(short value, String statName) {
        if (value < 0) {
            throw new IllegalArgumentException(statName + " no puede ser negativo");
        }
        return value;
    }

    public short getHp() {
        return this.hp;
    }

    public short getAttack() {
        return this.attack;
    }

    public short getDefence() {
        return this.defence;
    }

    public short getSpecialAttack() {
        return this.specialAttack;
    }

    public short getSpecialDefence() {
        return this.specialDefence;
    }

    public short getSpeed() {
        return this.speed;
    }

    public int getTotal() {
        return this.hp + this.attack + this.defence
                + this.specialAttack + this.specialDefence + this.speed;
    }

    @Override
    public String toString() {
        return String.format(
                "BaseStats{HP=%d, Atk=%d, Def=%d, SpAtk=%d, SpDef=%d, Spd=%d, Total=%d}",
                this.hp, this.attack, this.defence,
                this.specialAttack, this.specialDefence, this.speed,
                this.getTotal()
        );
    }
}
