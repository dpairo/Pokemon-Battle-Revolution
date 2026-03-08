package com.pokedex.domain.entities.pokemon.stats;

public class LevelStats {
    private int hp;
    private int attack;
    private int defence;
    private int specialAttack;
    private int specialDefence;
    private int speed;

    public LevelStats() {
        this.hp = 0;
        this.attack = 0;
        this.defence = 0;
        this.specialAttack = 0;
        this.specialDefence = 0;
        this.speed = 0;
    }

    public int getHp() {
        return this.hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAttack() {
        return this.attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefence() {
        return this.defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public int getSpecialAttack() {
        return this.specialAttack;
    }

    public void setSpecialAttack(int specialAttack) {
        this.specialAttack = specialAttack;
    }

    public int getSpecialDefence() {
        return this.specialDefence;
    }

    public void setSpecialDefence(int specialDefence) {
        this.specialDefence = specialDefence;
    }

    public int getSpeed() {
        return this.speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        return String.format("LevelStats{HP=%d, Atk=%d, Def=%d, SpAtk=%d, SpDef=%d, Spd=%d}", this.hp, this.attack, this.defence,
                this.specialAttack, this.specialDefence, this.speed);
    }
}
