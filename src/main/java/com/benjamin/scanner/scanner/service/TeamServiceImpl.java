package com.benjamin.scanner.scanner.service;

import com.benjamin.scanner.scanner.dao.player.Player;
import com.benjamin.scanner.scanner.dao.team.Team;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TeamServiceImpl implements TeamService {

    @Override
    public List<Team> getTeams(String bracket) {

        List<Player> players = Arrays.asList(new Player("Shinta", "Warrior"),
                new Player("Annie", "Paladin"),
                new Player("Progenic", "Shaman"));

        List<Player> players2 = Arrays.asList(new Player("Wreckula", "Mage"),
                new Player("Elowyn", "Priest"),
                new Player("Baby", "Deathknight"));

        return Arrays.asList(new Team("Shinta is shit", 1500, players, "Alliance"),
                new Team("Elowynn so hot", 1600, players2, "Horde"));
    }
}
