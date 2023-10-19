package com.rest.playbookrest.Controller;

import com.rest.playbookrest.Entity.Formation;
import com.rest.playbookrest.Service.FormationService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
1. Add exceptions
2. add string return to delete
3.Add logging
 */
@RestController
@RequestMapping(value="/Formation", produces = MediaType.APPLICATION_JSON_VALUE)
public class FormationController {

    private FormationService formationService;

    public FormationController(FormationService formationService) {
        this.formationService = formationService;
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
