package com.pokedex.domain.ports.output.random;

public interface CriticalHitProvider {
    boolean execute(int criticalStage);
}
