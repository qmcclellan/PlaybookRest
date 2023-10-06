package com.rest.playbookrest.Dao;

import com.rest.playbookrest.Entity.Coach;
import com.rest.playbookrest.Entity.Playbook;
import com.rest.playbookrest.Entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlaybookDao extends JpaRepository<Playbook,Integer> {

    public Playbook findByName(String name);

    public List<Playbook> findByCoach(Coach coach);

    public List<Playbook> findByCoach(Integer coachId);

    public List<Playbook> findByType(String type);

    public List<Playbook> findByTeam (Team team);

    public List<Playbook> findByTeam (Integer teamId);
}
