package com.rest.playbookrest.Dao;

import com.rest.playbookrest.Entity.Formation;
import com.rest.playbookrest.Entity.Play;
import com.rest.playbookrest.Entity.Scheme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SchemeDao extends JpaRepository<Scheme,Integer> {

    public Scheme findByName(String name);

    public List<Scheme> findByFormation(Formation formation);

    public Scheme findByFormation(Integer formationId);

    public List<Scheme> findByType(String type);

    public List<Scheme> findByPlay(Play play);

    public Scheme findByPlay(Integer playId);

}
