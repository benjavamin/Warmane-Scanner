package com.benjamin.scanner.scanner.dao.player;

public class Player {
    private String name;
    private String playerClass;

    public Player(String name, String playerClass) {
        this.name = name;
        this.playerClass = playerClass;
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

}
