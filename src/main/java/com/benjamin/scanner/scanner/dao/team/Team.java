package com.benjamin.scanner.scanner.dao.team;

import com.benjamin.scanner.scanner.dao.player.Player;

import java.util.List;

public class Team {
    private String name;
    private String rating;
    private List<Player> players;
    private String faction;
    private String lastGameTime;
    private String rank;
    private String realm;
    private String wins;
    private String losses;
    private String mmr;

    public Team(String name, String rating, List<Player> players, String faction, String lastGameTime, String rank, String realm,String wins, String losses, String mmr) {
        this.name = name;
        this.rating = rating;
        this.players = players;
        this.faction = faction;
        this.lastGameTime = lastGameTime;
        this.rank = rank;
        this.realm = realm;
        this.wins = wins;
        this.losses = losses;
        this.mmr = mmr;
    }

    public Team() {

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
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

    public void setLastGameTime(String lastGameTime) {
        this.lastGameTime = lastGameTime;
    }
    public String getLastGameTime() {
        return lastGameTime;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getRealm() {
        return realm;
    }

    public void setRealm(String realm) {
        this.realm = realm;
    }

    public String getWins() {
        return wins;
    }

    public void setWins(String wins) {
        this.wins = wins;
    }

    public String getLosses() {
        return losses;
    }

    public void setLosses(String losses) {
        this.losses = losses;
    }

    public String getMmr() {
        return mmr;
    }

    public void setMmr(String mmr) {
        this.mmr = mmr;
    }
}
