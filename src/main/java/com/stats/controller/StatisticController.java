package com.stats.controller;

import com.stats.dto.FormulaDto;
import com.stats.service.FormulaService;
import com.stats.service.StatsService;
import com.stats.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class StatisticController {

    @Autowired
    StatsService statsService;

    @Autowired
    FormulaService formulaService;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/stats", method = RequestMethod.GET)
    public ModelAndView stats(Model model) {
        ModelAndView mav = new ModelAndView("stats");
        mav.addObject("stats", statsService.getStatsParams());
        return mav;
    }

    @RequestMapping(value = "/stats", method = POST)
    public String create(@RequestParam(name="teams") Integer teamId,
                         @RequestParam(name="leagues") Integer leagueId,
                         @RequestParam(name="date") String date,
                         @RequestParam(name="totalKills") Integer totalKills,
                         @RequestParam(name="totalTime") Integer totalTime,
                         @RequestParam(name="teams2") Integer teamId2,
                         @RequestParam(name="fbInclude",required=false) boolean fbInclude,
                         ModelMap model) {
        Map<String, Object> params = new HashMap<>();
        params.put("teamId", teamId);
        params.put("teamId2", teamId2);
        params.put("leagueId", leagueId);
        params.put("date", Utils.convertStringDateToTime(date));
        params.put("totalKills", totalKills);
        params.put("totalTimes", totalTime);
        params.put("base", true);
        params.put("fbInclude", fbInclude);
        model.addAttribute("durationDto", statsService.getDurationStats(params));
        model.addAttribute("killsDto", statsService.getKillsStats(params));
        return "baseStats";
    }

    @RequestMapping(value = "/formula", method = RequestMethod.GET)
    public ModelAndView profitFormula() {
        ModelAndView mav = new ModelAndView("formula");
        mav.addObject("formula", new FormulaDto());
        return mav;
    }

    @RequestMapping(value = "/formula", method = POST)
    public String calculateFormula(@RequestParam("coefficient") Double coeff,
                         @RequestParam("profit") Double profit,
                         @RequestParam("moneyLost") Double moneyLost,
                         ModelMap model) {
        Map<String, Double> params = new HashMap<>();
        params.put("coeff",coeff);
        params.put("moneyLost",moneyLost);
        params.put("profit",profit);
        model.addAttribute("response",formulaService.calculateNextBet(params));
        return "formula";
    }
}
