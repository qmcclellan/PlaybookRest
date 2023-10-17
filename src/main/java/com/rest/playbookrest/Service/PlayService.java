package com.rest.playbookrest.Service;

import com.rest.playbookrest.Dao.PlayDao;
import com.rest.playbookrest.Entity.Play;
import com.rest.playbookrest.Entity.Scheme;
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
        return playDao.findAll();
    }

    @Override
    public Play retrieve(Integer id) {
        return playDao.getReferenceById(id);
    }

    @Override
    public Play saveAndFlush(Play play) {
        return playDao.saveAndFlush(play);
    }

    @Override
    public void deleteById(Integer id) {

        playDao.deleteById(id);
    }

    public Play findByName(String name){

        return playDao.findByName(name);
    }

    public List<Play> findByType(String type){

        List<Play> plays = playDao.findByType(type);

        return plays;
    }


    public List<Play> findByScheme(Integer schemeId){

        List<Play> plays = playDao.findByScheme(schemeId);

        return plays;
    }
}
