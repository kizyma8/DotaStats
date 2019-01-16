package com.stats.service.impl;

import com.stats.builders.QuaryBuilder;
import com.stats.connections.HttpConnection;
import com.stats.dao.LeagueDao;
import com.stats.model.Leagues;
import com.stats.service.LeagueService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeagueServiceImpl implements LeagueService {
    @Autowired
    HttpConnection httpConnection;

    @Autowired
    LeagueDao leagueDao;

    @Autowired
    QuaryBuilder quaryBuilder;

    @Override
    public void create(Leagues league) {
        try {
            String quary = quaryBuilder.buildGetLeagueQuary(league);
            JSONObject json = httpConnection.get("https://api.opendota.com/api/explorer",quary);
            addLeague(json, league);
        } catch (Exception ex){

        }
    }

    @Override
    public void addLeague(JSONObject leagues, Leagues league) {
        JSONObject jsonLeague =  leagues.getJSONArray("rows").getJSONObject(0);
        league.setLeagueId(jsonLeague.getInt("leagueid"));
        league.setName(jsonLeague.getString("name"));
        leagueDao.create(league);
    }
}
