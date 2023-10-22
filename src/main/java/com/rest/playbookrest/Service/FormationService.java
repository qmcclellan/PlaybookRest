package com.rest.playbookrest.Service;

import com.rest.playbookrest.Dao.FormationDao;
import com.rest.playbookrest.Dao.SchemeDao;
import com.rest.playbookrest.Entity.Formation;
import com.rest.playbookrest.Entity.Scheme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FormationService implements Services<Formation>{

    private FormationDao formationDao;
    private SchemeDao schemeDao;
    @Autowired
    public FormationService(FormationDao formationDao, SchemeDao schemeDao) {
        this.formationDao = formationDao;
        this.schemeDao = schemeDao;
    }

//    @Autowired
//    public FormationService(FormationDao formationDao) {
//        this.formationDao = formationDao;
//    }

    @Override
    public List<Formation> findAll() {

    //    List<Formation> formations = formationDao.findAll();

  //      List<Formation> finalList = new ArrayList<>();

//
//        System.out.println(finalList.get(0));
//
//        System.out.println("");
//
//        System.out.println(finalList.get(0).getSchemes());
        return formationDao.findAllWithSchemes();
    }

    @Override
    public Formation retrieve(Integer id) {
        return formationDao.getReferenceById(id);
    }

    @Override
    public Formation saveAndFlush(Formation formation) {
        return formationDao.saveAndFlush(formation);
    }

    @Override
    public void deleteById(Integer id) {

        formationDao.deleteById(id);
    }


    public List<Formation> findFormationByName(String name){

        List<Formation> formations = formationDao.findFormationByName(name);

        return formations;
    }
}
