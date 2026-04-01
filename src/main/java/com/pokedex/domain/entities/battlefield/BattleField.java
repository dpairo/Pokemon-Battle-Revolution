package com.pokedex.domain.entities.battlefield;

import com.pokedex.domain.entities.battlefield.conditions.Gravity;
import com.pokedex.domain.entities.battlefield.conditions.MagicRoom;
import com.pokedex.domain.entities.battlefield.conditions.TrickRoom;
import com.pokedex.domain.entities.battlefield.conditions.WonderRoom;
import com.pokedex.domain.entities.battlefield.field.FieldSide;
import com.pokedex.domain.entities.battlefield.terrain.Terrain;
import com.pokedex.domain.entities.battlefield.weather.Weather;
import com.pokedex.domain.entities.pokemon.Pokemon;
import com.pokedex.domain.entities.user.Team;

public class BattleField {
    private FieldSide playerOneField;
    private FieldSide playerTwoField;
    private Weather weather;
    private Terrain terrain;
    private TrickRoom trickRoom;
    private MagicRoom magicRoom;
    private WonderRoom wonderRoom;
    private Gravity gravity;

    public BattleField(Team playerOneTeam, Team playerTwoTeam) {
        this.playerOneField = new FieldSide(playerOneTeam);
        this.playerTwoField = new FieldSide(playerTwoTeam);
        this.weather = null;
        this.terrain = null;
        this.trickRoom = null;
        this.magicRoom = null;
        this.wonderRoom = null;
        this.gravity = null;
    }

    public FieldSide getPlayerOneField() {
        return this.playerOneField;
    }

    public FieldSide getPlayerTwoField() {
        return this.playerTwoField;
    }

    public Weather getWeather() {
        return this.weather;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }

    public Terrain getTerrain() {
        return this.terrain;
    }

    public void setTerrain(Terrain terrain) {
        this.terrain = terrain;
    }

    public boolean isTrickRoomUp() {
        return this.trickRoom != null && this.trickRoom.isActive();
    }

    public boolean isMagicRoomUp() {
        return this.magicRoom != null && this.magicRoom.isActive();
    }

    public boolean isWonderRoomUp() {
        return this.wonderRoom != null && this.wonderRoom.isActive();
    }

    public boolean isGravityUp() {
        return this.gravity != null && this.gravity.isActive();
    }

    public TrickRoom getTrickRoom() {
        return this.trickRoom;
    }

    public MagicRoom getMagicRoom() {
        return this.magicRoom;
    }

    public WonderRoom getWonderRoom() {
        return this.wonderRoom;
    }

    public Gravity getGravity() {
        return this.gravity;
    }

    public void trickRoomToggle(Pokemon pokemon) {
        if (this.trickRoom == null || !this.trickRoom.isActive()) {
            this.trickRoom = new TrickRoom(pokemon);
        }
        else {
            this.trickRoom = null;
        }
    }

    public void magicRoomToggle(Pokemon pokemon) {
        if (this.magicRoom == null || !this.magicRoom.isActive()) {
            this.magicRoom = new MagicRoom(pokemon);
        }
        else {
            this.magicRoom = null;
        }
    }

    public void wonderRoomToggle(Pokemon pokemon) {
        if (this.wonderRoom == null || !this.wonderRoom.isActive()) {
            this.wonderRoom = new WonderRoom(pokemon);
        }
        else {
            this.wonderRoom = null;
        }
    }

    public void activateGravity(Pokemon pokemon) {
        if (this.gravity == null || !this.gravity.isActive()) {
            this.gravity = new Gravity(pokemon);
        }
        else {
            this.gravity = null;
        }
    }

    public void endOfTurnConditions() {
        if (this.weather != null) {
            this.weather.decrementCounter();
            if (!this.weather.isActive()) {
                this.weather = null;
            }
        }

        if (this.terrain != null) {
            this.terrain.decrementCounter();
            if (!this.terrain.isActive()) {
                this.terrain = null;
            }
        }

        if (this.trickRoom != null) {
            this.trickRoom.decrementCounter();
            if (!this.trickRoom.isActive()) {
                this.trickRoom = null;
            }
        }

        if (this.magicRoom != null) {
            this.magicRoom.decrementCounter();
            if (!this.magicRoom.isActive()) {
                this.magicRoom = null;
            }
        }

        if (this.wonderRoom != null) {
            this.wonderRoom.decrementCounter();
            if (!this.wonderRoom.isActive()) {
                this.wonderRoom = null;
            }
        }

        if (this.gravity != null) {
            this.gravity.decrementCounter();
            if (!this.gravity.isActive()) {
                this.gravity = null;
            }
        }
    }
}
