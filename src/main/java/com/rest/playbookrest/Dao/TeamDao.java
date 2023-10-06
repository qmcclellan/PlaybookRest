package com.rest.playbookrest.Dao;

import com.rest.playbookrest.Entity.Coach;
import com.rest.playbookrest.Entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamDao extends JpaRepository<Team,Integer> {

}
