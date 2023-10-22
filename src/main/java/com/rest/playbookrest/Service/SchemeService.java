package com.rest.playbookrest.Service;

import com.rest.playbookrest.Dao.SchemeDao;
import com.rest.playbookrest.Entity.Formation;
import com.rest.playbookrest.Entity.Play;
import com.rest.playbookrest.Entity.Scheme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchemeService implements Services<Scheme>{

    private SchemeDao schemeDao;

    @Autowired
    public SchemeService(SchemeDao schemeDao) {
        this.schemeDao = schemeDao;
    }

    @Override
    public List<Scheme> findAll() {
        return schemeDao.findAll();
    }

    @Override
    public Scheme retrieve(Integer id) {
        return schemeDao.getReferenceById(id);
    }

    @Override
    public Scheme saveAndFlush(Scheme scheme) {
        return schemeDao.saveAndFlush(scheme);
    }

    @Override
    public void deleteById(Integer id) {

        schemeDao.deleteById(id);
    }

    public Scheme findByName(String name){

        return schemeDao.findByName(name);
    }

    public List<Scheme> findByType(String type){

        List<Scheme> schemes = schemeDao.findByType(type);

        return schemes;
    }
//    public List<Scheme> findByFormationId(Integer formationId){
//
//        return schemeDao.findAllByFormationId(formationId);
//    }

}
