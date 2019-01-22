package com.stats.service;

import com.stats.model.Teams;
import org.json.JSONObject;

import java.util.List;

public interface TeamService {

    public void create(Teams team);

    public void addTeams(JSONObject teams,Teams team);

    public List<Teams> list();
}
