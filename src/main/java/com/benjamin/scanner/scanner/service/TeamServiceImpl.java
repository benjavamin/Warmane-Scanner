package com.benjamin.scanner.scanner.service;

import com.benjamin.scanner.scanner.dao.player.Player;
import com.benjamin.scanner.scanner.dao.team.Team;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class TeamServiceImpl implements TeamService {

    @Override
    public List<Team> getTeams(String bracket) throws IOException {

        String mainPage = Jsoup.connect("http://armory.warmane.com/ladder/" + bracket + "/Icecrown").get().toString();
        mainPage = mainPage.replace("/", "&");
        mainPage = mainPage.replace("\"", "");
        Pattern p = Pattern.compile("<td><a href=&team&(.*?)&Icecrown&summary>");
        Matcher m = p.matcher(mainPage);
        List<String> teams = new ArrayList<>();

        while (m.find()) {
            teams.add(m.group());
        }

        for (String s : teams) {
            s = s.replace("&", "/");
            s = s.replace("<td><a href=/team/", "");
            s = s.replace("/Icecrown/summary>", "");
            String newLink = s;
            newLink = "http://armory.warmane.com/team/" + newLink + "/Icecrown/match-history";
            String matchHistory = Jsoup.connect(newLink).get().toString();

            matchHistory = matchHistory.replace("\"", "");
            matchHistory = matchHistory.replace("/", "");

            Pattern p2 = Pattern.compile("<td class=dt-center data-order=(.*?)<td>");
            Matcher m2 = p2.matcher(matchHistory);

            List<String> teamsPlayed = new ArrayList<>();

            while (m2.find()) {
                teamsPlayed.add(m2.group());
            }

            String lastGame = (teamsPlayed.get(teamsPlayed.size() - 1));
            lastGame = lastGame.substring(42);
            lastGame = lastGame.replace("<td>", "");
            s = s.replace("+", " ");
            String finalString = lastGame + " " + "team " + s;
            System.out.println(finalString);
            if (lastGame.toLowerCase().contains("minutes ago")) {
                Team team = new Team();
                team.setName(s);
                team.setFaction("Alliance");
                team.setRating(2300);
                team.setPlayers();
            }
        }
        return new ArrayList<>();
    }
}
