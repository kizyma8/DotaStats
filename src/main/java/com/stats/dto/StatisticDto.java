package com.stats.dto;

import com.stats.model.Leagues;
import com.stats.model.Teams;

import java.util.List;

public class StatisticDto {

    private List<Teams> teams;
    private List<Teams> teams2;
    private List<Leagues> leagues;

    public StatisticDto() {
    }

    public List<Teams> getTeams2() {
        return teams2;
    }

    public void setTeams2(List<Teams> teams2) {
        this.teams2 = teams2;
    }

    public StatisticDto(List<Teams> teams, List<Teams> teams2, List<Leagues> leagues) {
        this.teams = teams;
        this.leagues = leagues;
    }

    public List<Teams> getTeams() {
        return teams;
    }

    public void setTeams(List<Teams> teams) {
        this.teams = teams;
    }

    public List<Leagues> getLeagues() {
        return leagues;
    }

    public void setLeagues(List<Leagues> leagues) {
        this.leagues = leagues;
    }
}
