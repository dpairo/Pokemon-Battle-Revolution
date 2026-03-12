package com.pokedex.domain.ports.output.random;

public interface RandomProvider {
    int nextInt(int bound);
    boolean rollChance(int percent);
}
