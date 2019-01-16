package com.stats.dao;

import com.stats.model.Leagues;
import com.stats.model.Teams;

import java.util.List;

public interface TeamDao {

    public void create(Teams team);

    public List<Teams> list();

    public Teams getTeamByDotaId(int id);
}
