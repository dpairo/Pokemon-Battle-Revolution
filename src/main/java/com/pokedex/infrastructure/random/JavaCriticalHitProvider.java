package com.pokedex.infrastructure.random;

import com.pokedex.domain.ports.output.random.CriticalHitProvider;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class JavaCriticalHitProvider implements CriticalHitProvider {
    private final Random random;

    public JavaCriticalHitProvider(Random random) {
        this.random = random;
    }

    @Override
    public boolean execute(int criticalStage) {
        return switch (criticalStage) {
            case 1 -> random.nextInt(8) == 1;
            case 2 -> random.nextInt(2) == 1;
            case 3 -> true;
            default -> random.nextInt(24) == 1;
        };
    }
}
