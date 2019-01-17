package com.stats.dto;

public class KillsDto {
    private int kills;
    private int killsTeam1;
    private int killsTeam2;
    private int totalKills;
    private int totalKillsPercent;
    private int totalKillsPercentTeam1;
    private int totalKillsPercentTeam2;
    private int firstTeamFBPercent;
    private int secondTeamFBPercent;
    private int couriersKills;
    private int avgRoshanKillsPerMatch;

    public int getTotalKills() {
        return totalKills;
    }

    public void setTotalKills(int totalKills) {
        this.totalKills = totalKills;
    }

    public int getTotalKillsPercent() {
        return totalKillsPercent;
    }

    public void setTotalKillsPercent(int totalKillsPercent, int matchCount) {
        this.totalKillsPercent = totalKillsPercent * 100 / ((matchCount > 0) ? matchCount : 1);
    }

    public int getKills() {
        return kills;
    }

    public void setKills(int kills, int matchCount) {
        this.kills = kills / ((matchCount > 0) ? matchCount : 1);
    }

    public int getFirstTeamFBPercent() {
        return firstTeamFBPercent;
    }

    public void setFirstTeamFBPercent(int firstTeamFBPercent) {
        this.firstTeamFBPercent = firstTeamFBPercent;
    }

    public int getSecondTeamFBPercent() {
        return secondTeamFBPercent;
    }

    public void setSecondTeamFBPercent(int secondTeamFBPercent) {
        this.secondTeamFBPercent = secondTeamFBPercent;
    }

    public int getKillsTeam1() {
        return killsTeam1;
    }

    public void setKillsTeam1(int killsTeam1, int matchCount) {
        this.killsTeam1 = killsTeam1 / ((matchCount > 0) ? matchCount : 1);
    }

    public int getKillsTeam2() {
        return killsTeam2;
    }

    public void setKillsTeam2(int killsTeam2, int matchCount) {
        this.killsTeam2 = killsTeam2 / ((matchCount > 0) ? matchCount : 1);
    }

    public int getTotalKillsPercentTeam1() {
        return totalKillsPercentTeam1;
    }

    public void setTotalKillsPercentTeam1(int totalKillsPercentTeam1, int matchCount) {
        this.totalKillsPercentTeam1 = totalKillsPercentTeam1 * 100 / ((matchCount > 0) ? matchCount : 1) ;;
    }

    public int getTotalKillsPercentTeam2() {
        return totalKillsPercentTeam2;
    }

    public void setTotalKillsPercentTeam2(int totalKillsPercentTeam2, int matchCount) {
        this.totalKillsPercentTeam2 = totalKillsPercentTeam2 * 100 / ((matchCount > 0) ? matchCount : 0);;
    }

    public int getCouriersKills() {
        return couriersKills;
    }

    public void setCouriersKills(int couriersKills, int matchCount) {
        this.couriersKills = couriersKills * 100 / ((matchCount > 0) ? matchCount : 0);
    }

    public int getAvgRoshanKillsPerMatch() {
        return avgRoshanKillsPerMatch;
    }

    public void setAvgRoshanKillsPerMatch(int avgRoshanKillsPerMatch, int matchCount) {
        this.avgRoshanKillsPerMatch = avgRoshanKillsPerMatch / ((matchCount > 0) ? matchCount : 0);
    }
}
