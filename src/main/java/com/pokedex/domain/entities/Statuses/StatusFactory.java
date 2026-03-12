package com.pokedex.domain.entities.statuses;

import java.util.Optional;

public class StatusFactory {

    private StatusFactory() {}

    public static Optional<Status> create(StatusList type) {
        return switch (type) {
            case Poisoned      -> Optional.of(new Poisoned());
            case BadlyPoisoned -> Optional.of(new BadlyPoisoned());
            case Burned        -> Optional.of(new Burned());
            case Paralyzed     -> Optional.of(new Paralyzed());
            case Sleeping      -> Optional.of(new Sleeping());
            case Null          -> Optional.empty();
        };
    }
}
