package com.rest.playbookrest.Service;

import com.rest.playbookrest.Dao.TeamDao;
import com.rest.playbookrest.Entity.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService implements Services<Team> {

    private TeamDao teamDao;

    @Autowired
    public TeamService(TeamDao teamDao) {
        this.teamDao = teamDao;
    }

    @Override
    public List<Team> findAll() {
        return teamDao.findAll();
    }

    @Override
    public Team retrieve(Integer id) {
        return teamDao.getReferenceById(id);
    }

    @Override
    public Team saveAndFlush(Team team) {
        return teamDao.saveAndFlush(team);
    }

    @Override
    public void deleteById(Integer id) {

        teamDao.deleteById(id);
    }

    public Team findByCoach(Integer coachId){
        return teamDao.findByCoach(coachId);
    }
}
