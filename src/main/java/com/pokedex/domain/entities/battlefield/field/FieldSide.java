package com.pokedex.domain.entities.battlefield.field;

import com.pokedex.domain.entities.battlefield.field.conditions.Tailwind;
import com.pokedex.domain.entities.battlefield.field.hazards.Hazard;
import com.pokedex.domain.entities.battlefield.field.screens.ScreenList;
import com.pokedex.domain.entities.battlefield.field.screens.Screens;

import java.util.ArrayList;
import java.util.List;

public class FieldSide {
    private List<Hazard> hazards;
    private List<Screens> screens;
    private Tailwind tailwind;

    public FieldSide() {
        this.hazards = new ArrayList<>();
        this.screens = new ArrayList<>();
        this.tailwind = null;
    }

    public List<Hazard> getHazards() {
        return this.hazards;
    }

    public List<Screens> getScreens() {
        return this.screens;
    }

    public void addScreen(Screens screen) {
        this.screens.add(screen);
    }

    public void removeScreen(ScreenList type) {
        this.screens.removeIf(screen -> screen.getScreenType() == type);
    }

    public boolean hasScreen(ScreenList type) {
        return this.screens.stream()
                .anyMatch(screen -> screen.getScreenType() == type && screen.isActive());
    }

    public void setTailwind(Tailwind tailwind) {
        this.tailwind = tailwind;
    }

    public Tailwind getTailwind() {
        return this.tailwind;
    }

    public boolean isTailwindActive() {
        return this.tailwind != null && this.tailwind.isActive();
    }
}
