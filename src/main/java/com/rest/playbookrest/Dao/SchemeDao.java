package com.rest.playbookrest.Dao;

import com.rest.playbookrest.Entity.Formation;
import com.rest.playbookrest.Entity.Play;
import com.rest.playbookrest.Entity.Scheme;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SchemeDao extends JpaRepository<Scheme,Integer> {

    public Scheme findByName(String name);

    public Scheme findByFormation(Formation formation);

    public Scheme findByFormation(Integer formationId);

    public List<Scheme> findByType(String type);

    public List<Scheme> findByPlay(Play play);

    public List<Scheme> findByPlay(Integer playId);

}
