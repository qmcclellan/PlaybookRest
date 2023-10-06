package com.rest.playbookrest.Dao;

import com.rest.playbookrest.Entity.Formation;
import com.rest.playbookrest.Entity.Scheme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FormationDao extends JpaRepository<Formation, Integer> {

    public Formation findFormationByPlaybookId(Integer playbookId);

    public List<Formation> findFormationByName(String name);

    public List<Scheme> findSchemeByFormationId(Integer formationId);
}
