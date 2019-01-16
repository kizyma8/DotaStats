package com.stats.controller;

import com.stats.model.Leagues;
import com.stats.model.Teams;
import com.stats.service.LeagueService;
import com.stats.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LeagueController {
    @Autowired
    LeagueService leagueService;

    @RequestMapping(value = "/league", method = RequestMethod.GET)
    public String create(Model model) {
        model.addAttribute("league", new Leagues());
        return "league";
    }

    @RequestMapping(value = "/league", method = RequestMethod.POST)
    public String create(@ModelAttribute("league") Leagues league, ModelMap model) {
        leagueService.create(league);
        return "redirect:/";
    }
}
