package com.rest.playbookrest.Controller;

import com.rest.playbookrest.Entity.Play;
import com.rest.playbookrest.Service.PlayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value ="/Play", produces = MediaType.APPLICATION_JSON_VALUE)
public class PlayController {

    private PlayService playService;

    @Autowired
    public PlayController(PlayService playService) {
        this.playService = playService;
    }

    @GetMapping("/PlayList")
    public List<Play> findAll(){

        return playService.findAll();
    }

    @PostMapping("/AddPlay")
    public Play addPlay(@RequestBody Play play){

        return playService.saveAndFlush(play);
    }

    @GetMapping("/GetPlay/{playId}")
    public Play getPlay(@PathVariable("playId") int playId){

        return playService.getReferenceById(playId);
    }

    @GetMapping("/FindByType/{type}")
    public List<Play> findByType(@PathVariable("type") String type){

        return playService.findByType(type);
    }

    @GetMapping("/FindByName/{playName}")
    public Play findByName(@PathVariable("playName")String playName){

        return playService.findByName(playName);
    }

    @PutMapping("/UpdatePlay")
    public Play UpdatePlay(@RequestBody Play play){

        return playService.saveAndFlush(play);
    }

    @DeleteMapping("/DeletePlay/{playId}")
    public String deletePlay(@PathVariable("playId") Integer playId){

        if(playId == null){

            return "Play with id of "+playId+" not found!!";
        }

        playService.deleteById(playId);

        return"Play deleted with id of " + playId;
    }
}
