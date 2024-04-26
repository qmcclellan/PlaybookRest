package com.rest.playbookrest.Controller;

import com.rest.playbookrest.Entity.Playbook;
import com.rest.playbookrest.Service.PlaybookService;
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
@RequestMapping(value ="/Playbook",produces = MediaType.APPLICATION_JSON_VALUE)
public class PlaybookController {

    private final PlaybookService playbookService;
    private final JobLauncher jobLauncher;
    private final Job job;

    @Autowired
    public PlaybookController(PlaybookService playbookService, JobLauncher jobLauncher, Job job) {
        this.playbookService = playbookService;
        this.jobLauncher = jobLauncher;
        this.job = job;
    }

    @PostMapping("/PlaybookJob")
    public void writeToCSV(){

        JobParameters jobParameters = new JobParametersBuilder()
                .addLong("startAt", System.currentTimeMillis())
                .toJobParameters();

        try {
            jobLauncher.run(job, jobParameters);
        } catch (JobExecutionAlreadyRunningException |
                 JobRestartException |
                 JobInstanceAlreadyCompleteException |
                 JobParametersInvalidException e) {
            throw new RuntimeException(e);
        }
    }
    @GetMapping("/PlaybookList")
    public List<Playbook> findAllPlaybooks(){

        return playbookService.findAll();
    }

    @PostMapping("/AddPlaybook")
    public Playbook addPlaybook(@RequestBody Playbook playbook){

        return playbookService.saveAndFlush(playbook);
    }

    @GetMapping("/GetPlaybook/{playbookId}")
    public Playbook getPlaybook(@PathVariable("playbookId")int playbookId){

        return playbookService.getReferenceById(playbookId);
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



    @GetMapping("FindByType/{type}")
    public List<Playbook> findByType(@PathVariable("type")String type){

        return playbookService.findByType(type);
    }

    @GetMapping("FindByCoachId/{coachId}")
    public List<Playbook> findByCoachId(@PathVariable("coachId") Integer coachId){

        return playbookService.findByCoachId(coachId);
    }
}
