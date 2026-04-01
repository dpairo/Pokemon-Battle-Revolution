package com.pokedex.infrastructure.random;

import com.pokedex.domain.ports.output.random.DamageRollProvider;
import org.springframework.stereotype.Component;

import java.util.Random;

import static java.lang.Math.floor;

@Component
public class JavaDamageRollProvider implements DamageRollProvider {
    private final Random random;

    public JavaDamageRollProvider() {
        this.random = new Random();
    }


    @Override
    public int execute(int baseDamage) {
        int roll = random.nextInt(16) + 85;
        return (baseDamage * roll) / 100;
    }
}
