package com.pokedex.domain.entities.stats;

public class Statistics {
    private Short hp;
    private Short attack;
    private Short defence;
    private Short specialAttack;
    private Short specialDefence;
    private Short speed;

    public Statistics() {
    }

    public Statistics(Short hp, Short attack, Short defence, Short specialAttack, Short specialDefence, Short speed) {
        this.hp = hp;
        this.attack = attack;
        this.defence = defence;
        this.specialAttack = specialAttack;
        this.specialDefence = specialDefence;
        this.speed = speed;
    }

    public Short getHp() {
        return hp;
    }

    public void setHp(Short hp) {
        this.hp = hp;
    }

    public Short getAttack() {
        return attack;
    }

    public void setAttack(Short attack) {
        this.attack = attack;
    }

    public Short getDefence() {
        return defence;
    }

    public void setDefence(Short defence) {
        this.defence = defence;
    }

    public Short getSpecialAttack() {
        return specialAttack;
    }

    public void setSpecialAttack(Short specialAttack) {
        this.specialAttack = specialAttack;
    }

    public Short getSpecialDefence() {
        return specialDefence;
    }

    public void setSpecialDefence(Short specialDefence) {
        this.specialDefence = specialDefence;
    }

    public Short getSpeed() {
        return speed;
    }

    public void setSpeed(Short speed) {
        this.speed = speed;
    }

    public int getTotal() {
        return (hp != null ? hp : 0) +
                (attack != null ? attack : 0) +
                (defence != null ? defence : 0) +
                (specialAttack != null ? specialAttack : 0) +
                (specialDefence != null ? specialDefence : 0) +
                (speed != null ? speed : 0);
    }
}
