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
        return null;
    }

    @Override
    public Formation retrieve(Integer id) {
        return null;
    }

    @Override
    public Formation saveAndFlush(Formation formation) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }
}
