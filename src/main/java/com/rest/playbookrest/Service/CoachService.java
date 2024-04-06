package com.rest.playbookrest.Service;

import com.rest.playbookrest.Dao.CoachDao;
import com.rest.playbookrest.Entity.Coach;
import com.rest.playbookrest.Entity.Users;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoachService implements Services<Coach> {

    private CoachDao coachDao;

    public CoachService(CoachDao coachDao) {
        this.coachDao = coachDao;
    }

    @Override
    public List<Coach> findAll() {
        return coachDao.findAll();
    }

    @Override
    public Coach retrieve(Integer id) {
        return coachDao.getReferenceById(id);
    }

    @Override
    public Coach saveAndFlush(Coach coach) {
        return coachDao.saveAndFlush(coach);
    }

    @Override
    public void deleteById(Integer id) {

        coachDao.deleteById(id);
    }

    public List<Coach> findCoachByType(String type){

        List<Coach> coaches = coachDao.findCoachByType(type);

        return coaches;
    }

    public Coach findByCoachName(String name){

        Coach coach = coachDao.findCoachByName(name);

        return coach;
    }

    public Coach findCoachByUserId(Integer userId){

        return coachDao.findCoachByUserId(userId);

    }

    public Coach findCoachByUserName(String userNamw){
        return coachDao.findCoachByUserUserName(userNamw);
    }
}
