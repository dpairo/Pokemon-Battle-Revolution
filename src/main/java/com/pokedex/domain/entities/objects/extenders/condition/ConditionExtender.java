package com.pokedex.domain.entities.objects.extenders.condition;

import com.pokedex.domain.entities.battlefield.conditions.ConditionList;

public interface ConditionExtender {
    ConditionList getExtendedCondition();
    int getExtensionTurns();
}
