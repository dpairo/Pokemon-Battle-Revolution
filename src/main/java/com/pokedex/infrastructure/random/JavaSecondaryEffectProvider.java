package com.pokedex.infrastructure.random;

import java.util.Random;

import com.pokedex.domain.ports.output.random.SecondaryEffectProvider;
import org.springframework.stereotype.Component;

@Component
public class JavaSecondaryEffectProvider implements SecondaryEffectProvider {
    private final Random random;

    public JavaSecondaryEffectProvider(Random random) {
        this.random = random;
    }

    @Override
    public boolean execute(int probability) {
        return random.nextInt(100) <= probability;
    }
}
