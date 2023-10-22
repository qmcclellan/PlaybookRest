package com.rest.playbookrest.Dao;

import com.rest.playbookrest.Entity.Formation;
import com.rest.playbookrest.Entity.Scheme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FormationDao extends JpaRepository<Formation, Integer> {

    List<Formation> findFormationByName(String name);

    @Query("SELECT f FROM Formation f JOIN FETCH f.schemes")
    List<Formation> findAllWithSchemes();

}