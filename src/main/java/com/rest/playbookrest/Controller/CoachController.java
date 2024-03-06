package com.rest.playbookrest.Controller;

import com.rest.playbookrest.Entity.Coach;
import com.rest.playbookrest.Service.CoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
1. Add Logging
2. Add exception handling
 */

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value= "/Coach", produces = MediaType.APPLICATION_JSON_VALUE)
public class CoachController {

    private CoachService coachService;

    @Autowired
    public CoachController(CoachService coachService) {
        this.coachService = coachService;
    }

    @GetMapping("/CoachList")
    public List<Coach> findAll(){

        return coachService.findAll();
    }

    @PostMapping("/AddCoach")
    public Coach addCoach(@RequestBody Coach coach){

        coach.setId(0);

       return coachService.saveAndFlush(coach);
    }

    @GetMapping("/GetCoach/{coachId}")
    public Coach getCoach(@PathVariable int coachId){

        Coach coach = coachService.retrieve(coachId);

        return coach;
    }

    @GetMapping("/GetCoachByUser/{coachId}")
    public Coach getCoachByUser(@PathVariable int coachId){

        Coach coach = coachService.retrieve(coachId);

        return coach;
    }

    @GetMapping("/FindCoachesByType/{coachType}")
    public List<Coach> findCoachByType(@PathVariable String coachType){

        if(coachType == null){
            //Add exception
        }

        return coachService.findCoachByType(coachType);
    }

    @GetMapping("/FindCoachByName/{coachName}")
    public Coach findCoachByName(@PathVariable String coachName){

        if(coachName == null){
            //Add exception
        }

        return coachService.findByCoachName(coachName);
    }

    @PutMapping("/UpdateCoach")
    public Coach updateCoach(@RequestBody Coach coach){

        return coachService.saveAndFlush(coach);
    }

    @DeleteMapping("/DeleteCoach/{coachId}")
    public void deleteCoach(@PathVariable int coachId){

        coachService.deleteById(coachId);
    }
}
