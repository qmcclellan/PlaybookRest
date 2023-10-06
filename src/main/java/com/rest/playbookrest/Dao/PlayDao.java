package com.rest.playbookrest.Dao;

import com.rest.playbookrest.Entity.Play;
import com.rest.playbookrest.Entity.Scheme;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayDao extends JpaRepository<Play, Integer> {

    public Play findByName(String name);

    public List<Play> findByType(String type);

    public Play findByScheme(Scheme scheme);

    public List<Play> findByScheme(Integer schemeId);


}
