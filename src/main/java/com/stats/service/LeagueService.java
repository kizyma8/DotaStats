package com.stats.service;

import com.stats.model.Leagues;
import com.stats.model.Teams;
import org.json.JSONObject;

import java.util.List;

public interface LeagueService {

    public void create(Leagues league);

    public void addLeague(JSONObject leagues, Leagues league);

    public List<Leagues> list();
}
