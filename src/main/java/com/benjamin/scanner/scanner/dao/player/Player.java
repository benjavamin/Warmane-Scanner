package com.benjamin.scanner.scanner.dao.player;

public class Player {
    private String name;
    private String playerClass;
    private String mmr;

    public Player(String name, String playerClass, String mmr) {
        this.name = name;
        this.playerClass = playerClass;
        this.mmr = mmr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlayerClass() {
        return playerClass;
    }

    public void setPlayerClass(String playerClass) {
        this.playerClass = playerClass;
    }

    public String getMmr() {
        return mmr;
    }

    public void setMmr(String mmr) {
        this.mmr = mmr;
    }
}
