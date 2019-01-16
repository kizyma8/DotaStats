package com.stats.controller;

import com.stats.model.Teams;
import com.stats.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TeamController {
    @Autowired
    TeamService teamService;

    @RequestMapping(value = "/team", method = RequestMethod.GET)
    public String create(Model model) {
        model.addAttribute("team", new Teams());
        return "team";
    }

    @RequestMapping(value = "/team", method = RequestMethod.POST)
    public String create(@ModelAttribute("team") Teams team, ModelMap model) {
        teamService.create(team);
        return "redirect:/stats";
    }
}
