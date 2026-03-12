package com.pokedex.infrastructure.random;

import com.pokedex.domain.ports.output.random.RandomProvider;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class JavaRandomProvider implements RandomProvider {
    private final Random random;

    public JavaRandomProvider() {
        this.random = new Random();
    }

    @Override
    public int nextInt(int bound) {
        return this.random.nextInt(bound);
    }

    @Override
    public boolean rollChance(int percent) {
        if (percent <= 0) {
            return false;
        }
        if (percent >= 100) {
            return true;
        }
        return this.random.nextInt(100) < percent;
    }
}
