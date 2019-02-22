package com.stats.dto;

public class BaseResponseDto {

    private String teamName;
    private String secondTeamName;
    private int matchCount;
    private int matchCountTeam1;
    private int matchCountTeam2;


    public String getSecondTeamName() {
        return secondTeamName;
    }

    public void setSecondTeamName(String secondTeamName) {
        this.secondTeamName = secondTeamName;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public void setMatchCount(int matchCount) {
        this.matchCount = matchCount;
    }

    public int getMatchCountTeam1() {
        return matchCountTeam1;
    }

    public void setMatchCountTeam1(int matchCountTeam1) {
        this.matchCountTeam1 = matchCountTeam1;
    }

    public int getMatchCountTeam2() {
        return matchCountTeam2;
    }

    public void setMatchCountTeam2(int matchCountTeam2) {
        this.matchCountTeam2 = matchCountTeam2;
    }
}

