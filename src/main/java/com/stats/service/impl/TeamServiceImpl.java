package com.stats.service.impl;

import com.stats.builders.QuaryBuilder;
import com.stats.connections.HttpConnection;
import com.stats.dao.TeamDao;
import com.stats.model.Teams;
import com.stats.service.TeamService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    HttpConnection httpConnection;

    @Autowired
    TeamDao teamDao;

    @Autowired
    QuaryBuilder quaryBuilder;

    @Override
    public void create(Teams team) {
            String quary = quaryBuilder.buildGetTeamQuary(team);
            JSONObject json = httpConnection.get("https://api.opendota.com/api/explorer",quary);
            addTeams(json, team);
    }

    @Override
    public void addTeams(JSONObject teams, Teams team) {
        JSONObject jsonTeam =  teams.getJSONArray("rows").getJSONObject(0);
        team.setDotaId(jsonTeam.getInt("team_id"));
        team.setName(jsonTeam.getString("name"));
        teamDao.create(team);
    }

    @Override
    public List<Teams> list() {
        return teamDao.list();
    }


}
