package com.benjamin.scanner.scanner.controller;

import com.benjamin.scanner.scanner.dao.team.Team;
import com.benjamin.scanner.scanner.service.TeamService;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TeamsController {

    private final TeamService teamService;

    public TeamsController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping("teams")
    public List<Team> getTeams(@RequestParam String bracket) throws IOException {
        return teamService.getTeams(bracket);
    }
}
