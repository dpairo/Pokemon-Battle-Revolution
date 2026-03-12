package com.pokedex.domain.entities.user;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class User {
    private Long id;
    private String userName;
    private String email;
    private String password;
    private RoleList role;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private List<Team> teams;

    // When created
    public User(String userName, String email, String hashedPassword) {
        this.userName = userName;
        this.email = email;
        this.password = hashedPassword;
        this.role = RoleList.PLAYER;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.teams = new ArrayList<>();
    }

    // When charged from DB
    public User(Long id, String userName, String email, String hashedPassword, RoleList role, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.password = hashedPassword;
        this.role = role;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.teams = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
        this.updatedAt = LocalDateTime.now();
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
        this.updatedAt = LocalDateTime.now();
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String hashedPassword) {
        this.password = hashedPassword;
        this.updatedAt = LocalDateTime.now();
    }

    public RoleList getRole() {
        return role;
    }
    public void setRole(RoleList role) {
        this.role = role;
        this.updatedAt = LocalDateTime.now();
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public List<Team> getAllTeams() {
        return Collections.unmodifiableList(teams);
    }

    public void addTeam(Team team) {
        this.teams.add(team);
        this.updatedAt = LocalDateTime.now();
    }

    public void removeTeam(Team team) {
        this.teams.remove(team);
        this.updatedAt = LocalDateTime.now();
    }

    public Optional<Team> getTeamById(Long teamId) {
        return teams.stream().filter(team -> Objects.equals(team.getId(), teamId)).findFirst();
    }
}
