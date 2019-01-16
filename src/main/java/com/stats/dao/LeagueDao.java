package com.stats.dao;

import com.stats.model.Leagues;

import java.util.List;

public interface LeagueDao {

    public void create(Leagues league);

    public List<Leagues> list();

}
