package com.rest.playbookrest.Controller;

import com.rest.playbookrest.Entity.Scheme;
import com.rest.playbookrest.Service.FormationService;
import com.rest.playbookrest.Service.SchemeService;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value ="/Scheme", produces = MediaType.APPLICATION_JSON_VALUE)
public class SchemeController {

    private SchemeService schemeService;

    private Job runSchemeJob;

    private JobLauncher jobLauncher;

    public SchemeController(SchemeService schemeService, Job runSchemeJob, JobLauncher jobLauncher) {
        this.schemeService = schemeService;
        this.runSchemeJob = runSchemeJob;
        this.jobLauncher = jobLauncher;
    }

    @PostMapping("/UpdateType")
    public void schemeBatch(){

        JobParameters jobParameters = new JobParametersBuilder()
                .addLong("startAt", System.currentTimeMillis() )
                .toJobParameters();

        try {
            jobLauncher.run(runSchemeJob, jobParameters);
        } catch (JobExecutionAlreadyRunningException |
                 JobRestartException |
                 JobInstanceAlreadyCompleteException |
                 JobParametersInvalidException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/SchemeList")
    public List<Scheme> findAll(){

        return schemeService.findAll();
    }

    @PostMapping("/AddScheme")
    public Scheme addScheme(@RequestBody Scheme scheme){

        return schemeService.saveAndFlush(scheme);
    }

    @GetMapping("/GetScheme/{schemeId}")
    public Scheme getScheme(@PathVariable("schemeId") int schemeId){

        return schemeService.getReferenceById(schemeId);
    }
    @GetMapping("/FindByName/{schemeName}")
    public Scheme findByName(@PathVariable("schemeName") String schemeName){
       return schemeService.findByName(schemeName);
    }


    @GetMapping("/FindByType")
    public List<Scheme> findByType(@PathVariable("type") String type){

        return schemeService.findByType(type);
    }

    @PutMapping("/UpdateScheme")
    public Scheme updateScheme(@RequestBody Scheme scheme){

        return schemeService.saveAndFlush(scheme);
    }

    @DeleteMapping("/DeleteScheme/{schemeId}")
    public String deleteScheme(@PathVariable("schemeId") Integer schemeId){

        if(schemeId == null){
            return "Scheme with id " + schemeId+ " not found!!";
        }

        schemeService.deleteById(schemeId);

        return "Scheme has been deleted with id of "+ schemeId;

    }

}
