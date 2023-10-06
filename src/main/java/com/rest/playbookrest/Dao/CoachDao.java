package com.rest.playbookrest.Dao;

import com.rest.playbookrest.Entity.Coach;
import com.rest.playbookrest.Entity.Playbook;
import com.rest.playbookrest.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CoachDao extends JpaRepository<Coach , Integer> {

    public Users findUsersByCoachId(Integer coachId);

    public List<Playbook> findPlaybooksByCoachId(Integer CoachId);

    public List<Coach> findCoachByType(String coachType);

    public Coach findCoachByName(String coach);
}
