package com.rest.playbookrest.Dao;

import com.rest.playbookrest.Entity.Coach;
import com.rest.playbookrest.Entity.Playbook;
import com.rest.playbookrest.Entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PlaybookDao extends JpaRepository<Playbook,Integer> {

    public Playbook findByName(String name);

    public List<Playbook> findByType(String type);

    public List<Playbook> findByCoachId(Integer id);


}
