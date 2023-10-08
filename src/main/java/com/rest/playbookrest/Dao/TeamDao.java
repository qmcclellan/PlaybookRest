package com.rest.playbookrest.Dao;

import com.rest.playbookrest.Entity.Coach;
import com.rest.playbookrest.Entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamDao extends JpaRepository<Team,Integer> {

    public Team findByCoach(Integer coachId);

}
