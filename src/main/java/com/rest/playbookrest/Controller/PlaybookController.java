package com.rest.playbookrest.Controller;

import com.rest.playbookrest.Entity.Coach;
import com.rest.playbookrest.Entity.Play;
import com.rest.playbookrest.Entity.Playbook;
import com.rest.playbookrest.Service.PlaybookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Playbook")
public class PlaybookController {

    private PlaybookService playbookService;

    @Autowired
    public PlaybookController(PlaybookService playbookService) {
        this.playbookService = playbookService;
    }

    @GetMapping("/PlaybookList")
    public List<Playbook> findAllPlaybooks(){

       List<Playbook> playbooks = playbookService.findAll();

       return playbooks;
    }

    @PostMapping("/AddPlaybook")
    public Playbook addPlaybook(@RequestBody Playbook playbook){

        return playbookService.saveAndFlush(playbook);
    }

    @GetMapping("/GetPlaybook/{playbookId}")
    public Playbook getPlaybook(@PathVariable("playbookId")int playbookId){

        return playbookService.retrieve(playbookId);
    }

    @PutMapping("/UpdatePlaybook")
    public Playbook updatePlaybook(@RequestBody Playbook playbook){

        return playbookService.saveAndFlush(playbook);
    }

    @DeleteMapping("/DeletePlaybook/{playbookId}")
    public String deletePlaybook(@PathVariable("playbookId") int playbookId){
        if(playbookId <= 0){

            return "playbook not found!!";
        }
        playbookService.deleteById(playbookId);

        return "PlaybookId "+playbookId+" has been deleted";
    }
    @GetMapping("/FindByName/{bookName}")
    public Playbook findByName(@PathVariable("bookName")String bookName){

        return playbookService.findByName(bookName);
    }

    @GetMapping("/FindByCoach/{coachId}")
    public Playbook findByCoach(@PathVariable("coachId") int coachId){

        return playbookService.findByCoach(coachId);
    }

    @GetMapping("/FindByTeam/{teamId}")
    public List<Playbook> findByTeam (@PathVariable("teamId") int teamId){

        return playbookService.findByTeam(teamId);
    }

    @GetMapping("/FindByTeamName/{teamName}")
    public List<Playbook> findByTeam (@PathVariable("teamName") String teamName){

        return playbookService.findByTeam(teamName);
    }

    @GetMapping("FindByType/{type}")
    public List<Playbook> findByType(@PathVariable("type")String type){

        return playbookService.findByType(type);
    }
}
