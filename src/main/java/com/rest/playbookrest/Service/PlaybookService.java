package com.rest.playbookrest.Service;

import com.rest.playbookrest.Dao.PlaybookDao;
import com.rest.playbookrest.Entity.Coach;
import com.rest.playbookrest.Entity.Playbook;
import com.rest.playbookrest.Entity.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaybookService implements Services<Playbook>{

    private PlaybookDao playbookDao;

    @Autowired
    public PlaybookService(PlaybookDao playbookDao) {
        this.playbookDao = playbookDao;
    }

    @Override
    public List<Playbook> findAll() {
        return playbookDao.findAll();
    }

    @Override
    public Playbook retrieve(Integer id) {
        return playbookDao.getReferenceById(id);
    }

    @Override
    public Playbook saveAndFlush(Playbook playbook) {
        return playbookDao.saveAndFlush(playbook);
    }

    @Override
    public void deleteById(Integer id) {

        playbookDao.deleteById(id);
    }

    public Playbook findByName(String name){

       return playbookDao.findByName(name);
    }



    public List<Playbook> findByType(String type){

        List<Playbook> playbooks = playbookDao.findByType(type);

        return playbooks;
    }

    public List<Playbook> findByCoachId(Integer coachId){

        return playbookDao.findPlaybooksByCoach_Id(coachId);
    }
}
