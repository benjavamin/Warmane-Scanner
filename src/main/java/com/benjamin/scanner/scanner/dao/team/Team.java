package com.benjamin.scanner.scanner.dao.team;

import com.benjamin.scanner.scanner.dao.player.Player;

import java.util.List;

public class Team {
    private String name;
    private Integer rating;
    private List<Player> players;
    private String faction;
    private Integer lastGameTime;

    public Team(String name, Integer rating, List<Player> players, String faction, Integer lastGameTime) {
        this.name = name;
        this.rating = rating;
        this.players = players;
        this.faction = faction;
    }

    public Team() {

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }


    public String getFaction() {
        return faction;
    }

    public void setFaction(String faction) {
        this.faction = faction;
    }
}
