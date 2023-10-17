package com.rest.playbookrest.Dao;

import com.rest.playbookrest.Entity.Play;
import com.rest.playbookrest.Entity.Scheme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PlayDao extends JpaRepository<Play, Integer> {

    public Play findByName(String name);

    public List<Play> findByType(String type);

    public List<Play> findByScheme(Integer schemeId);


}
