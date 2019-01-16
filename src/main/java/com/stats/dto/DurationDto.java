package com.stats.dto;

public class DurationDto extends BaseResponseDto {

    private int duration;
    private int durationTeam1;
    private int durationTeam2;
    private int higherThenSpecifiedTeam1;
    private int higherThenSpecifiedTeam2;
    private int durationHigherThenSpecified;
    private int specifiedDuration;

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getDurationTeam1() {
        return durationTeam1;
    }

    public void setDurationTeam1(int durationTeam1) {
        this.durationTeam1 = durationTeam1;
    }

    public int getDurationTeam2() {
        return durationTeam2;
    }

    public void setDurationTeam2(int durationTeam2) {
        this.durationTeam2 = durationTeam2;
    }

//    public int getTotalTimes() {
//        return totalTimes;
//    }
//
//    public void setTotalTimes(int totalTimes) {
//        this.totalTimes = totalTimes;
//    }


    public int getHigherThenSpecifiedTeam1() {
        return higherThenSpecifiedTeam1;
    }

    public void setHigherThenSpecifiedTeam1(int higherThenSpecifiedTeam1) {
        this.higherThenSpecifiedTeam1 = higherThenSpecifiedTeam1;
    }

    public int getHigherThenSpecifiedTeam2() {
        return higherThenSpecifiedTeam2;
    }

    public void setHigherThenSpecifiedTeam2(int higherThenSpecifiedTeam2) {
        this.higherThenSpecifiedTeam2 = higherThenSpecifiedTeam2;
    }

    public int getDurationHigherThenSpecified() {
        return durationHigherThenSpecified;
    }

    public void setDurationHigherThenSpecified(int durationHigherThenSpecified) {
        this.durationHigherThenSpecified = durationHigherThenSpecified;
    }

    public int getSpecifiedDuration() {
        return specifiedDuration;
    }

    public void setSpecifiedDuration(int specifiedDuration) {
        this.specifiedDuration = specifiedDuration;
    }
}
