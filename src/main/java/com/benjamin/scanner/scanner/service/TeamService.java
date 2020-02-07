package com.benjamin.scanner.scanner.service;

import com.benjamin.scanner.scanner.dao.team.Team;

import java.io.IOException;
import java.util.List;

public interface TeamService {

    List<Team> getTeams(String bracket) throws IOException;
}
