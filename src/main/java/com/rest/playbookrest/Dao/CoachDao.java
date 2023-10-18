package com.rest.playbookrest.Dao;

import com.rest.playbookrest.Entity.Coach;
import com.rest.playbookrest.Entity.Playbook;
import com.rest.playbookrest.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CoachDao extends JpaRepository<Coach , Integer> {

    public List<Coach> findCoachByType(String coachType);

    public Coach findCoachByName(String coach);
}
