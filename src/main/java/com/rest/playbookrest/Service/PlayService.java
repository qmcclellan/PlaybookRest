package com.rest.playbookrest.Service;

import com.rest.playbookrest.Dao.PlayDao;
import com.rest.playbookrest.Entity.Play;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayService implements Services<Play> {


    private PlayDao playDao;

    @Autowired
    public PlayService(PlayDao playDao) {
        this.playDao = playDao;
    }

    @Override
    public List<Play> findAll() {
        return null;
    }

    @Override
    public Play retrieve(Integer id) {
        return null;
    }

    @Override
    public Play saveAndFlush(Play play) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }
}
