package com.stats.service.impl;

import com.stats.builders.QuaryBuilder;
import com.stats.connections.HttpConnection;
import com.stats.dao.LeagueDao;
import com.stats.dao.TeamDao;
import com.stats.dto.DurationDto;
import com.stats.service.StatsService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.function.Predicate;

@Service
public class DurationStatsServiceImpl implements StatsService {
    @Autowired
    HttpConnection httpConnection;

    @Autowired
    LeagueDao leagueDao;

    @Autowired
    TeamDao teamDao;

    @Autowired
    QuaryBuilder quaryBuilder;

    @Override
    public DurationDto getStats(Map params) {
            DurationDto durationDto = null;
            durationDto = new DurationDto();
            String quary = quaryBuilder.buildQueryForDuration(params);
            JSONObject baseStats = httpConnection.get("https://api.opendota.com/api/explorer", quary);
            buildDurationDto(durationDto, baseStats, params);
        return durationDto;
    }

    private void buildDurationDto(DurationDto durationDto, JSONObject json, Map params) {
        int matchCountTeam1 = (Integer) json.getJSONArray("rows").getJSONObject(0).get("count");
        int matchCountTeam2 = 0;
        int durationTeam2 = 0;
        int durationTeam1 = Integer.parseInt(((String) json.getJSONArray("rows").getJSONObject(0).get("avg")).split("\\.", 2)[0]) / 60;
        //specifiedValue is counts of match where duration is higher then value which we past in input field
        JSONObject specifiedValue = null;
        //matchesHigherThenSpecified is counts of match where duration is higher then value which we past in input field
        int matchesHigherThenSpecified = 0;
        int matchesHigherThenSpecifiedTeam1 = 0;
        int matchesHigherThenSpecifiedTeam2 = 0;
        Predicate<JSONObject> hasSecondTeam = object -> object.getJSONArray("rows").length() > 1;
        if (params.get("totalTimes") != null) {
            specifiedValue = getStatsBySpecifiedValue(params);
            matchesHigherThenSpecifiedTeam1 = (Integer) specifiedValue.getJSONArray("rows").getJSONObject(0).get("count");
            if (hasSecondTeam.test(specifiedValue)) {
                matchesHigherThenSpecifiedTeam2 = (Integer) specifiedValue.getJSONArray("rows").getJSONObject(1).get("count");
            }
            matchesHigherThenSpecified = matchesHigherThenSpecifiedTeam1 + matchesHigherThenSpecifiedTeam2;
        }
        if (hasSecondTeam.test(json)) {
            matchCountTeam2 = (Integer) json.getJSONArray("rows").getJSONObject(1).get("count");
            durationTeam2 = Integer.parseInt(((String) json.getJSONArray("rows").getJSONObject(1).get("avg")).split("\\.", 2)[0]) / 60;
        }
        int duration = (durationTeam1 + durationTeam2) / json.getJSONArray("rows").length();
        int allMatchCount = matchCountTeam1 + matchCountTeam2;

        durationDto.setTeamName((String) json.getJSONArray("rows").getJSONObject(0).get("name"));
        durationDto.setDurationTeam1(durationTeam1);
        durationDto.setMatchCountTeam1(matchCountTeam1);
        durationDto.setMatchCount(allMatchCount);
        durationDto.setDuration(duration);
        durationDto.setSpecifiedDuration((params.get("totalTimes") != null) ? (int) params.get("totalTimes") : 0);
        // This value calculate to percent
        durationDto.setHigherThenSpecifiedTeam1(matchesHigherThenSpecifiedTeam1 * 100 / ((matchCountTeam1 >  0) ? matchCountTeam1 : 1));
        durationDto.setHigherThenSpecifiedTeam2(matchesHigherThenSpecifiedTeam2 * 100 / ((matchCountTeam2 > 0) ? matchCountTeam2 : 1));
        durationDto.setDurationHigherThenSpecified(matchesHigherThenSpecified * 100 / allMatchCount);
        if (hasSecondTeam.test(json)) {
            durationDto.setSecondTeamName((String) json.getJSONArray("rows").getJSONObject(1).get("name"));
            durationDto.setDurationTeam2(durationTeam2);
            durationDto.setMatchCountTeam2(matchCountTeam2);
        }
    }

    private JSONObject getStatsBySpecifiedValue(Map params) {
        JSONObject specifiedStats = null;
        try {
            String quary = quaryBuilder.buildQueryBySpecifiedValue(params);
            specifiedStats = httpConnection.get("https://api.opendota.com/api/explorer", quary);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return specifiedStats;
    }
}
