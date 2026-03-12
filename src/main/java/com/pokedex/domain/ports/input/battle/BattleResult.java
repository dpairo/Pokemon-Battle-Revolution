package com.pokedex.domain.ports.input.battle;

import java.util.List;

public record BattleResult(String winner, List<String> eventLog, boolean battleEnded) {}
