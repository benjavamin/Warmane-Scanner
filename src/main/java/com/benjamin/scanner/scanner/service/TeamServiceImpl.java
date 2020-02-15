package com.benjamin.scanner.scanner.service;

import com.benjamin.scanner.scanner.dao.player.Player;
import com.benjamin.scanner.scanner.dao.team.Team;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class TeamServiceImpl implements TeamService {

    @Override
    public List<Team> getTeams(String bracket) throws IOException {

        Document mainPage = Jsoup.connect("http://armory.warmane.com/ladder/" + bracket + "/Icecrown").get();
        Elements teams = mainPage.getElementsByTag("tr");

        List<Team> teamList = new ArrayList<>();
        for (int i = 2; i < teams.size(); i++) {
            Element trElement = teams.get(i);
            String rank = trElement.child(0).text();
            String teamName = trElement.child(1).text();
            List<Player> teamPlayers = new ArrayList<>();
            int teamSize = trElement.child(2).children().size();
            for (int j = 0; j < teamSize; j++) {
                Player player = new Player(trElement.child(2).child(j).child(0).attr("alt"), "Paladin", "1500");
                teamPlayers.add(player);
            }
            String realm = trElement.child(4).text();
            String faction = trElement.child(3).child(0).child(0).attr("alt");
            String wins = trElement.child(5).text();
            String losses = trElement.child(6).text();
            String rating = trElement.child(7).text();
            Team newTeam = new Team(teamName, rating, teamPlayers, faction, "", rank, realm, wins, losses, "");
            teamList.add(newTeam);
        }

        Document matchHistory = null;
        Document teamSummary = null;
        List<Team> recentTeams = new ArrayList<>();
        for (Team team : teamList) {
            matchHistory = Jsoup.connect("http://armory.warmane.com/team/" + team.getName().replace(" ", "+") + "/" + team.getRealm() + "/match-history").get();
            Element tableTrData = matchHistory.getElementsByTag("table").first().child(1);
            String match = tableTrData.child(tableTrData.children().size() - 1).child(4).text();
            if (match.contains("ago")) {
                team.setLastGameTime(match);
                teamSummary = Jsoup.connect("http://armory.warmane.com/team/" + team.getName().replace(" ", "+") + "/" + team.getRealm() + "/summary").get();
                Elements teamPlayers = teamSummary.getElementById("data-table-list").children();
                int playerMMRSum = 0;
                for (int i = 0; i < teamPlayers.size(); i++) {
                    int playerMMR = Integer.parseInt(teamPlayers.get(i).children().last().text());
                    team.getPlayers().get(i).setMmr(String.valueOf(playerMMR));
                    team.getPlayers().get(i).setPlayerClass(teamPlayers.get(i).child(3).child(0).child(0).attr("alt"));
                    playerMMRSum += playerMMR;
                }
                team.setMmr(String.valueOf(playerMMRSum / teamPlayers.size()));
                recentTeams.add(team);
            }
        }
        return recentTeams;
    }
}
