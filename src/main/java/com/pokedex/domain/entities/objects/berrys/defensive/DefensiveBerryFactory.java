package com.pokedex.domain.entities.objects.berrys.defensive;

import com.pokedex.domain.entities.pokemon.types.TypeList;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public final class DefensiveBerryFactory {
    private static final Map<TypeList, DefensiveBerryType> TYPE_TO_BERRY = new HashMap<>();

    static {
        for (DefensiveBerryType berryType : DefensiveBerryType.values()) {
            TYPE_TO_BERRY.put(berryType.getDefendsAgainstType(), berryType);
        }
    }

    private DefensiveBerryFactory() {
        // Private constructor to prevent instantiation
    }

    public static DefensiveBerry create(DefensiveBerryType type) {
        return new DefensiveBerry(type);
    }

    public static Optional<DefensiveBerry> createForType(TypeList attackingType) {
        DefensiveBerryType berryType = TYPE_TO_BERRY.get(attackingType);
        if (berryType == null) {
            return Optional.empty();
        }
        return Optional.of(new DefensiveBerry(berryType));
    }

    public static Optional<DefensiveBerryType> getBerryTypeForAttackType(TypeList attackingType) {
        return Optional.ofNullable(TYPE_TO_BERRY.get(attackingType));
    }
}
