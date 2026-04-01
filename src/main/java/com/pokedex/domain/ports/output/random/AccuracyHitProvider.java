package com.pokedex.domain.ports.output.random;

public interface AccuracyHitProvider {
    boolean execute(int accuracy);
}
