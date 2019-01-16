package com.stats.builders;

import com.stats.model.Leagues;
import com.stats.model.Teams;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class QuaryBuilder {

    public String buildQueryForKills(Map params){
        StringBuilder sb = new StringBuilder();
        /*if(params.get("base") != null && (Boolean)params.get("base")) {
            sb.append("select dire_score,radiant_score,match_id from matches "); //duration,dire_score,radiant_score
        }*/
        /*if (params.get("teamId") != null) {
            sb.append("where (radiant_team_id=").append(params.get("teamId")).append(" or dire_team_id =").append(params.get("teamId"));
        }
        if (params.get("teamId2") != null) {
            sb.append(" or radiant_team_id=").append(params.get("teamId2")).append(" or dire_team_id =").append(params.get("teamId2")).append(") ");
        } else {
            sb.append(") ");
        }*/
        if(params.get("base") != null && (Boolean)params.get("base")) {
            sb.append("select match_id,team_id,dire_score,radiant_score, (dire_score + radiant_score) as \"total\" from matches "); //duration,dire_score,radiant_score
            sb.append("JOIN match_patch using(match_id) ");
            sb.append("JOIN player_matches using(match_id) ");
            sb.append("JOIN heroes on heroes.id = player_matches.hero_id ");
            sb.append("LEFT JOIN notable_players ON notable_players.account_id = player_matches.account_id ");
            sb.append("LEFT JOIN teams using(team_id) ");
        }
        sb.append("WHERE TRUE AND");
        if (params.get("teamId") != null) {
            sb.append(" (notable_players.team_id=").append(params.get("teamId"))/*.append(" or dire_team_id =").append(params.get("teamId"))*/;
        }
        if (params.get("teamId2") != null) {
            sb.append(" or notable_players.team_id=").append(params.get("teamId2")).append(") ")/*.append(" or dire_team_id =").append(params.get("teamId2")).append(") ")*/;
        } else {
            sb.append(") ");
        }
        if(params.get("leagueId") != null) {
            sb.append("and leagueId=").append(params.get("leagueId")).append(" ");
        }
        if(params.get("date") != null){
            sb.append("and start_time>").append(params.get("date"));
        }
        sb.append(" GROUP BY dire_score, teams.name,matches.radiant_score,notable_players.team_id,matches.match_id");
//        sb.append(" ORDER BY teams.name DESC NULLS LAST");
        return sb.toString();
    }
//    public String buildQueryForKills(Map params) {
//
//    }

    public String buildQueryForDuration(Map params) {
        StringBuilder sb = new StringBuilder();
        if(params.get("base") != null && (Boolean)params.get("base")) {
            sb.append("select teams.name, avg(duration) \"avg\", count(distinct matches.match_id) count from matches "); //duration,dire_score,radiant_score
            sb.append("JOIN match_patch using(match_id) ");
            sb.append("JOIN player_matches using(match_id) ");
            sb.append("JOIN heroes on heroes.id = player_matches.hero_id ");
            sb.append("LEFT JOIN notable_players ON notable_players.account_id = player_matches.account_id ");
            sb.append("LEFT JOIN teams using(team_id) ");

        }
        sb.append("WHERE TRUE AND");
        if (params.get("teamId") != null) {
            sb.append("(notable_players.team_id=").append(params.get("teamId"))/*.append(" or dire_team_id =").append(params.get("teamId"))*/;
        }
        if (params.get("teamId2") != null) {
            sb.append(" or notable_players.team_id=").append(params.get("teamId2")).append(") ")/*.append(" or dire_team_id =").append(params.get("teamId2")).append(") ")*/;
        } else {
            sb.append(") ");
        }
        if(params.get("leagueId") != null) {
            sb.append("and leagueId=").append(params.get("leagueId")).append(" ");
        }
        if(params.get("date") != null){
            sb.append("and start_time>").append(params.get("date"));
        }
        sb.append(" GROUP BY teams.name");
        sb.append(" HAVING count (distinct matches.match_id) >= 1 ");
        return sb.toString();
    }

    public String buildQueryBySpecifiedValue(Map params) {
        StringBuilder sb = new StringBuilder();
        sb.append("select teams.name, count(distinct matches.match_id) count from matches "); //duration,dire_score,radiant_score
        sb.append("JOIN match_patch using(match_id) ");
        sb.append("JOIN player_matches using(match_id) ");
        sb.append("JOIN heroes on heroes.id = player_matches.hero_id ");
        sb.append("LEFT JOIN notable_players ON notable_players.account_id = player_matches.account_id ");
        sb.append("LEFT JOIN teams using(team_id) ");
        sb.append("WHERE TRUE AND");
        if (params.get("teamId") != null) {
            sb.append("(notable_players.team_id=").append(params.get("teamId"))/*.append(" or dire_team_id =").append(params.get("teamId"))*/;
        }
        if (params.get("teamId2") != null) {
            sb.append(" or notable_players.team_id=").append(params.get("teamId2")).append(") ")/*.append(" or dire_team_id =").append(params.get("teamId2")).append(") ")*/;
        } else {
            sb.append(") ");
        }
        if(params.get("leagueId") != null) {
            sb.append("and leagueId=").append(params.get("leagueId")).append(" ");
        }
        if(params.get("date") != null){
            sb.append("and start_time>").append(params.get("date"));
        }
        if(params.get("totalTimes") != null) {
            sb.append(" and duration>").append((int)params.get("totalTimes") * 60);
        }
        sb.append(" GROUP BY teams.name");
        sb.append(" HAVING count (distinct matches.match_id) >= 1 ");
        return sb.toString();
    }

    public String buildCourierKillsQuary(Map params) {
        StringBuilder sb = new StringBuilder();
        if(params.get("base") != null && (Boolean)params.get("base")) {
            sb.append("select objectives from matches "); //duration,dire_score,radiant_score
        }
        if (params.get("teamId") != null) {
            sb.append("where (radiant_team_id=").append(params.get("teamId")).append(" or dire_team_id =").append(params.get("teamId"));
        }
        if (params.get("teamId2") != null) {
            sb.append(" or radiant_team_id=").append(params.get("teamId2")).append(" or dire_team_id =").append(params.get("teamId2")).append(") ");
        } else {
            sb.append(") ");
        }
        if(params.get("leagueId") != null) {
            sb.append("and leagueId=").append(params.get("leagueId")).append(" ");
        }
        if(params.get("date") != null){
            sb.append("and start_time>").append(params.get("date"));
        }
        return sb.toString();
    }

    public String buildGetTeamQuary(Teams team){
        StringBuilder sb = new StringBuilder();
        sb.append("select * from teams where name=").append("'").append(team.getName()).append("'")
                .append(" or tag=").append("'").append(team.getName()).append("'");
        return sb.toString();
    }

    public String buildGetLeagueQuary(Leagues league){
        StringBuilder sb = new StringBuilder();
        sb.append("select * from leagues where name=").append("'").append(league.getName()).append("'")
                .append(" or leagueid=").append(league.getName());
        return sb.toString();
    }
}
