package com.rest.playbookrest.Controller;

import com.rest.playbookrest.Entity.Scheme;
import com.rest.playbookrest.Service.SchemeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Scheme")
public class SchemeController {

    private SchemeService schemeService;

    public SchemeController(SchemeService schemeService) {
        this.schemeService = schemeService;
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

        return schemeService.retrieve(schemeId);
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
