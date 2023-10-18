package com.rest.playbookrest.Dao;

import com.rest.playbookrest.Entity.Formation;
import com.rest.playbookrest.Entity.Scheme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FormationDao extends JpaRepository<Formation, Integer> {

    public List<Formation> findFormationByName(String name);

}
