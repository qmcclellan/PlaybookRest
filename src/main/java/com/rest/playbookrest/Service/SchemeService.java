package com.rest.playbookrest.Service;

import com.rest.playbookrest.Dao.SchemeDao;
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
        return null;
    }

    @Override
    public Scheme retrieve(Integer id) {
        return null;
    }

    @Override
    public Scheme saveAndFlush(Scheme scheme) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }
}
