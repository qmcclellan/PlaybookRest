package com.rest.playbookrest.Dao;

import com.rest.playbookrest.Entity.Formation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FormationDao extends JpaRepository<Formation, Integer> {

    List<Formation> findFormationsByName(String name);

    Formation findByName(String name);

}