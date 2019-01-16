package com.stats.service;

import com.stats.dto.BaseResponseDto;
import com.stats.dto.DurationDto;
import com.stats.dto.KillsDto;
import com.stats.dto.StatisticDto;
import org.json.JSONObject;

import java.util.Map;

public interface StatsService {

    public KillsDto getKillsStats(Map params);

    public DurationDto getDurationStats(Map params);

    public StatisticDto getStatsParams();
}
