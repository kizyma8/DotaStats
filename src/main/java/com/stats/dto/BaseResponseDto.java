package com.stats.dto;

public class BaseResponseDto {

    private String teamName;
    private String secondTeamName;
//    private int duration;
//    private int kills;
    private int matchCount;
    private int matchCountTeam1;
    private int matchCountTeam2;
//    private int totalKills;
//    private int totalKillsPercent;
//    private int totalTimes;
//    private int totalTimesInMinutes;
//    private int firstTeamFBPercent;
//    private int secondTeamFBPercent;

    public String getSecondTeamName() {
        return secondTeamName;
    }

    public void setSecondTeamName(String secondTeamName) {
        this.secondTeamName = secondTeamName;
    }

//    public int getTotalKills() {
//        return totalKills;
//    }
//
//    public void setTotalKills(int totalKills) {
//        this.totalKills = totalKills;
//    }
//
//    public int getTotalKillsPercent() {
//        return totalKillsPercent;
//    }
//
//    public void setTotalKillsPercent(int totalKillsPercent, int matchCount) {
//        this.totalKillsPercent = totalKillsPercent * 100 / matchCount;
//    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }


//
//    public int getKills() {
//        return kills;
//    }
//
//    public void setKills(int kills, int matchCount) {
//        this.kills = kills / matchCount;
//    }

    public int getMatchCount() {
        return matchCount;
    }

    public void setMatchCount(int matchCount) {
        this.matchCount = matchCount;
    }



//    public int getFirstTeamFBPercent() {
//        return firstTeamFBPercent;
//    }
//
//    public void setFirstTeamFBPercent(int firstTeamFBPercent) {
//        this.firstTeamFBPercent = firstTeamFBPercent;
//    }
//
//    public int getSecondTeamFBPercent() {
//        return secondTeamFBPercent;
//    }
//
//    public void setSecondTeamFBPercent(int secondTeamFBPercent) {
//        this.secondTeamFBPercent = secondTeamFBPercent;
//    }

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

