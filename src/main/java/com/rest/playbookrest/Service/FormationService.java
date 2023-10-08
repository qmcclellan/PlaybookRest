package com.rest.playbookrest.Service;

import com.rest.playbookrest.Dao.FormationDao;
import com.rest.playbookrest.Entity.Formation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormationService implements Services<Formation>{

    private FormationDao formationDao;

    @Autowired
    public FormationService(FormationDao formationDao) {
        this.formationDao = formationDao;
    }

    @Override
    public List<Formation> findAll() {
        return formationDao.findAll();
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

    public Formation findFormationByPlaybookId(Integer playbookId){

       Formation formation = formationDao.findFormationByPlaybookId(playbookId);

       return formation;
    }

    public List<Formation> findFormationByName(String name){

        List<Formation> formations = formationDao.findFormationByName(name);

        return formations;
    }
}
