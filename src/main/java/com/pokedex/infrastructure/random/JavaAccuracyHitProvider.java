package com.pokedex.infrastructure.random;

import com.pokedex.domain.ports.output.random.AccuracyHitProvider;
import com.pokedex.domain.ports.output.random.CriticalHitProvider;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Random;

@Component
public class JavaAccuracyHitProvider implements AccuracyHitProvider {
    private final Random random;

    public JavaAccuracyHitProvider(Random random) {
        this.random = random;
    }

    @Override
    public boolean execute(int accuracy) {
        return random.nextInt(100) <= accuracy;
    }
}
