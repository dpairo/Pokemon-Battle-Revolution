package com.pokedex.domain.ports.output.random;

public interface SecondaryEffectProvider {
    boolean execute(int probability);
}
