package com.rest.playbookrest.Controller;

import com.rest.playbookrest.Entity.Formation;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
1. Add exceptions
2. add string return to delete
3.Add logging
 */
@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping(value="/Formation", produces = MediaType.APPLICATION_JSON_VALUE)
public class FormationController {

    private FormationService formationService;

  //  private SchemeService schemeService;

    private Job job;

    private JobLauncher jobLauncher;

    public FormationController(FormationService formationService, @Qualifier("runFormationJob") Job job, JobLauncher jobLauncher) {
        this.formationService = formationService;
        this.job = job;
        this.jobLauncher = jobLauncher;
    }

    @PostMapping("/writeFormation")
    public void writeFormation(){

        JobParameters jobParameters = new JobParametersBuilder()
                .addLong("startAt", System.currentTimeMillis())
                .toJobParameters();

        try {
            jobLauncher.run(job, jobParameters);
        } catch (JobExecutionAlreadyRunningException | JobInstanceAlreadyCompleteException | JobRestartException |
                 JobParametersInvalidException e) {
            throw new RuntimeException(e);
        }

    }
    @GetMapping("/FormationList")
    public List<Formation> FormationList() {
        return formationService.findAll() ;
    }


    public Formation addFormation(@RequestBody Formation formation){

        formation.setId(0);

        return formationService.saveAndFlush(formation);
    }

    @PutMapping("/UpdateFormation")
    public Formation updateFormation(@RequestBody Formation formation){

        return formationService.saveAndFlush(formation);
    }

    @GetMapping("/GetFormation/{formationId}")
    public Formation getFormation(@PathVariable("formationId") int formationId){
        Formation formation = formationService.getReferenceById(formationId);

        return formation;
    }

    @GetMapping("/FormationListByName/{name}")
    public List<Formation> findFormationByName(@PathVariable("name") String name){

        List<Formation> formations = formationService.findByFormationsName(name);

        return formations;

    }
    @DeleteMapping("/DeleteFormation/{formationId}")
    public void deleteFormation(@PathVariable("formationId") int formationId){

        formationService.deleteById(formationId);
    }

}
