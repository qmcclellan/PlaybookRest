package com.rest.playbookrest.Controller;

import com.rest.playbookrest.Entity.Team;
import com.rest.playbookrest.Service.TeamService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Team")
public class TeamController {

    private TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping("/TeamList")
    public List<Team> findAll(){
        return teamService.findAll();
    }

    @PostMapping("/AddTeam")
    public Team addTeam(@RequestBody Team team){
        return teamService.saveAndFlush(team);
    }

    @GetMapping("/GetTeam/{teamId}")
    public Team getTeam(@PathVariable("teamId") Integer teamId){
        return teamService.retrieve(teamId);
    }

    @GetMapping("/FindByCoach/{coachId}")
    public Team findByCoach(@PathVariable Integer coachId){

        return teamService.findByCoach(coachId);
    }

    @PutMapping("/UpdateTeam")
    public Team updateTeam(@RequestBody Team team){

        return teamService.saveAndFlush(team);
    }

    @DeleteMapping("/DeleteTeam/{teamId}")
    public String deleteTeam(@PathVariable("teamid") Integer teamId){

        if(teamId == null){

            return "Team with id "+teamId+" not found!!";
        }

        teamService.deleteById(teamId);

        return "Team deleted with id " +teamId;
    }
}

