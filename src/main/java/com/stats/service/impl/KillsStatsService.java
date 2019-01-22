package com.stats.service.impl;

import com.stats.builders.QuaryBuilder;
import com.stats.connections.HttpConnection;
import com.stats.dao.LeagueDao;
import com.stats.dao.TeamDao;
import com.stats.dto.KillsDto;
import com.stats.service.StatsService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class KillsStatsService implements StatsService {
    @Autowired
    HttpConnection httpConnection;

    @Autowired
    LeagueDao leagueDao;

    @Autowired
    TeamDao teamDao;

    @Autowired
    QuaryBuilder quaryBuilder;

    @Override
    public KillsDto getStats(Map params) {
        KillsDto killsDto = null;
        try {
            killsDto = new KillsDto();
            String quary = quaryBuilder.buildQueryForKills(params);
//            String quary = quaryBuilder.buildCourierKillsQuary(params);
            JSONObject baseStats = httpConnection.get("https://api.opendota.com/api/explorer", quary);
            buildKillsDto(killsDto, baseStats, params);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return killsDto;
    }

    private void buildKillsDto(KillsDto killsDto, JSONObject json, Map params) {
        Integer killsOfAllMatches = 0;
        int matchCount = json.getJSONArray("rows").length() > 0 ? json.getJSONArray("rows").length() : 1;
        int matchesHigherThenKillPoint = 0;
        int team1Matches = 0;
        int team2Matches = 0;
        int killsTeam1 = 0;
        int killsTeam2 = 0;
        int matchesHigherThenKillPointTeam1 = 0;
        int matchesHigherThenKillPointTeam2 = 0;
        int total = 0;
        int matchesHigherThenSpecifiedTeam1 = 0;
        int matchesHigherThenSpecifiedTeam2 = 0;
        List<Long> matchIds = new ArrayList<>();

        for (int i = 0; i < json.getJSONArray("rows").length(); i++) {
            total = (Integer) json.getJSONArray("rows").getJSONObject(i).get("total");
            matchIds.add((Long) json.getJSONArray("rows").getJSONObject(i).get("match_id"));

            if (json.getJSONArray("rows").getJSONObject(i).get("team_id").equals(params.get("teamId"))) {
                killsTeam1 += total;
                matchesHigherThenSpecifiedTeam1++;
            } else if(json.getJSONArray("rows").getJSONObject(i).get("team_id").equals(params.get("teamId2"))){
                killsTeam2 += total;
                matchesHigherThenSpecifiedTeam2++;
            }

            killsOfAllMatches += (Integer) json.getJSONArray("rows").getJSONObject(i).get("total");

            if (params.get("totalKills") != null) {
                matchesHigherThenKillPoint += total > (Integer) params.get("totalKills") ? 1 : 0;
                if (json.getJSONArray("rows").getJSONObject(i).get("team_id").equals(params.get("teamId"))) {
                    matchesHigherThenKillPointTeam1 += total > (Integer) params.get("totalKills") ? 1 : 0;
                    team1Matches++;
                } else {
                    matchesHigherThenKillPointTeam2 += total > (Integer) params.get("totalKills") ? 1 : 0;
                    team2Matches++;
                }
            }
        }
        couriersKills(killsDto,params,matchCount);
        killsDto.setKills(killsOfAllMatches, matchCount);
        killsDto.setKillsTeam1(killsTeam1, (matchesHigherThenSpecifiedTeam1 > 0) ? matchesHigherThenSpecifiedTeam1 : 1);
        killsDto.setKillsTeam2(killsTeam2, (matchesHigherThenSpecifiedTeam2 > 0)? matchesHigherThenSpecifiedTeam2 : 1);
        killsDto.setTotalKills(params.get("totalKills") != null ? (Integer) params.get("totalKills") : 0);
        killsDto.setTotalKillsPercent(matchesHigherThenKillPoint, matchCount);
        killsDto.setTotalKillsPercentTeam1(matchesHigherThenKillPointTeam1,team1Matches);
        killsDto.setTotalKillsPercentTeam2(matchesHigherThenKillPointTeam2,team2Matches);

        if ((Boolean) params.get("fbInclude")) {
            buildKillsStats(matchIds, (Integer) params.get("teamId"), (Integer) params.get("teamId2"), killsDto);
        }
    }

    private void couriersKills(KillsDto killsDto, Map params, int matchCount) {
        JSONObject json = null;
        try {
            String quary = quaryBuilder.buildCourierKillsQuary(params);
            json = httpConnection.get("https://api.opendota.com/api/explorer", quary);
            int matchesWithCouriersKills = 0;
            int roshanKills = 0;
            boolean breakCounting = false;
            for (int i = 0; i < json.getJSONArray("rows").length(); i++) {
                breakCounting = false;
                for(int j = 0; j < json.getJSONArray("rows").getJSONObject(i).getJSONArray("objectives").length(); j++) {
                    if(!breakCounting && "CHAT_MESSAGE_COURIER_LOST".equals(json.getJSONArray("rows").getJSONObject(i).getJSONArray("objectives").getJSONObject(j).get("type"))) {
                        matchesWithCouriersKills++;
                        breakCounting = true;
                    }
                    if("CHAT_MESSAGE_ROSHAN_KILL".equals(json.getJSONArray("rows").getJSONObject(i).getJSONArray("objectives").getJSONObject(j).get("type"))) {
                        roshanKills++;
                    }
                }
            }
            killsDto.setCouriersKills(matchesWithCouriersKills,matchCount);
            roshansKillls(killsDto,roshanKills,matchCount);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void buildKillsStats(List<Long> ids, Integer firstTeamId, Integer secondTeamId, KillsDto killsDto) {
        List<Map<Integer, Boolean>> stats = new ArrayList<>();
        Integer teamId = null;
        for (Long id : ids) {
            boolean fbRadiant = false;
            Map<Integer, Boolean> teams = new HashMap<>();
            JSONObject match = httpConnection.get("https://api.opendota.com/api/matches/" + id, "");
            JSONArray players = match.getJSONArray("players");
            for (Object player : players) {
                if (player instanceof JSONObject) {
                    if (((JSONObject) player).get("firstblood_claimed") instanceof Integer && 1 == (Integer)((JSONObject) player).get("firstblood_claimed")) {
                        fbRadiant = (boolean) ((JSONObject) player).get("isRadiant");
                    }
                }
            }
            fillInFBMap(teams, firstTeamId, secondTeamId, fbRadiant, match);
            stats.add(teams);
        }
        List<Map<Integer, Boolean>> fbFierstTeam = stats.stream().filter(team -> team.containsKey(firstTeamId)).collect(Collectors.toList());
        killsDto.setFirstTeamFBPercent(getFBPercent(fbFierstTeam));
        if (secondTeamId != null) {
            List<Map<Integer, Boolean>> fbSecondTeam = stats.stream().filter(team -> team.containsKey(secondTeamId)).collect(Collectors.toList());
            killsDto.setSecondTeamFBPercent(getFBPercent(fbSecondTeam));
        }
    }

    private void fillInFBMap(Map<Integer, Boolean> teams, Integer firstTeamId, Integer secondTeamId, boolean fbRadiant, JSONObject match) {
        if (match.get("radiant_team_id").equals(firstTeamId)) {
            teams.put(firstTeamId, fbRadiant);
        } else if (match.get("dire_team_id").equals(firstTeamId)) {
            teams.put(firstTeamId, !fbRadiant);
        } else if (match.get("dire_team_id").equals(secondTeamId)) {
            teams.put(secondTeamId, !fbRadiant);
        } else if (match.get("radiant_team_id").equals(secondTeamId)) {
            teams.put(secondTeamId, fbRadiant);
        }
    }

    private int getFBPercent(List<Map<Integer, Boolean>> allFb) {
        return allFb.size() > 0 ? (int) allFb.stream().filter(team -> team.containsValue(true)).count() * 100 / (allFb.size() > 0 ? allFb.size() : 1) : 0;
    }

    private void roshansKillls(KillsDto killsDto, int kills, int matchCount) {
        killsDto.setAvgRoshanKillsPerMatch(kills, matchCount);
    }
}
