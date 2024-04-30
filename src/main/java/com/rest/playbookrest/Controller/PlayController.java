package com.rest.playbookrest.Controller;

import com.rest.playbookrest.Entity.Play;
import com.rest.playbookrest.Service.PlayService;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value ="/Play", produces = MediaType.APPLICATION_JSON_VALUE)
public class PlayController {

    private PlayService playService;

    private Job runPlayJob;

    private JobLauncher jobLauncher;

    public PlayController(PlayService playService, Job runPlayJob, JobLauncher jobLauncher) {
        this.playService = playService;
        this.runPlayJob = runPlayJob;
        this.jobLauncher = jobLauncher;
    }

    @PostMapping("/PlayJob")
    public void playJob(){

        JobParameters jobParameters = new JobParametersBuilder()
                .addLong("startAt", System.currentTimeMillis())
                .toJobParameters();

        try {
            jobLauncher.run(runPlayJob, jobParameters);
        } catch (JobExecutionAlreadyRunningException |
                 JobRestartException |
                 JobInstanceAlreadyCompleteException |
                 JobParametersInvalidException e) {
            throw new RuntimeException(e);
        }
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
