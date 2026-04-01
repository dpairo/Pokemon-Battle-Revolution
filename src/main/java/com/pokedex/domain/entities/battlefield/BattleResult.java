package com.pokedex.domain.entities.battlefield;

import java.util.List;

public record BattleResult(String winner, List<String> eventLog, boolean battleEnded) {}
