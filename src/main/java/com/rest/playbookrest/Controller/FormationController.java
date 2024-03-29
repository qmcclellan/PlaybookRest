package com.rest.playbookrest.Controller;

import com.rest.playbookrest.Entity.Formation;
import com.rest.playbookrest.Service.FormationService;
import com.rest.playbookrest.Service.SchemeService;
import org.springframework.beans.factory.annotation.Autowired;
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

    private SchemeService schemeService;

  //  public FormationController(FormationService formationService) {
//        this.formationService = formationService;
//    }

    @Autowired
    public FormationController(FormationService formationService, SchemeService schemeService) {
        this.formationService = formationService;
        this.schemeService = schemeService;
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
        Formation formation = formationService.retrieve(formationId);

        return formation;
    }

    @GetMapping("/FormationListByName/{name}")
    public List<Formation> findFormationByName(@PathVariable("name") String name){

        List<Formation> formations = formationService.findFormationByName(name);

        return formations;

    }
    @DeleteMapping("/DeleteFormation/{formationId}")
    public void deleteFormation(@PathVariable("formationId") int formationId){

        formationService.deleteById(formationId);
    }

}
