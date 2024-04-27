package com.rest.playbookrest.Service;

import com.rest.playbookrest.Dao.TeamDao;
import com.rest.playbookrest.Entity.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class TeamService implements Services<Team> {

    private TeamDao teamDao;

    @Autowired
    public TeamService(TeamDao teamDao) {
        this.teamDao = teamDao;
    }


    @Override
    public Team findByName(String name) {
        return teamDao.findByName(name);
    }

    @Override
    public List<Team> findByType(String type) {
        return null;
    }

    @Override
    public void flush() {

        teamDao.flush();
    }

    @Override
    public <S extends Team> S saveAndFlush(S entity) {
        return teamDao.saveAndFlush(entity);
    }

    @Override
    public <S extends Team> List<S> saveAllAndFlush(Iterable<S> entities) {
        return teamDao.saveAllAndFlush(entities);
    }

    @Override
    public void deleteAllInBatch(Iterable<Team> entities) {

        teamDao.deleteAllInBatch(entities);
    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> integers) {

        teamDao.deleteAllByIdInBatch(integers);
    }

    @Override
    public void deleteAllInBatch() {

        teamDao.deleteAllInBatch();
    }

    @Override
    public Team getOne(Integer integer) {
        return teamDao.getOne(integer);
    }

    @Override
    public Team getById(Integer integer) {
        return teamDao.getById(integer);
    }

    @Override
    public Team getReferenceById(Integer integer) {
        return teamDao.getReferenceById(integer);
    }

    @Override
    public <S extends Team> Optional<S> findOne(Example<S> example) {
        return teamDao.findOne(example);
    }

    @Override
    public <S extends Team> List<S> findAll(Example<S> example) {
        return teamDao.findAll(example);
    }

    @Override
    public <S extends Team> List<S> findAll(Example<S> example, Sort sort) {
        return teamDao.findAll(example,sort);
    }

    @Override
    public <S extends Team> Page<S> findAll(Example<S> example, Pageable pageable) {
        return teamDao.findAll(example,pageable);
    }

    @Override
    public <S extends Team> long count(Example<S> example) {
        return teamDao.count(example);
    }

    @Override
    public <S extends Team> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Team, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return teamDao.findBy(example,queryFunction);
    }

    @Override
    public <S extends Team> S save(S entity) {
        return teamDao.save(entity);
    }

    @Override
    public <S extends Team> List<S> saveAll(Iterable<S> entities) {
        return teamDao.saveAll(entities);
    }

    @Override
    public Optional<Team> findById(Integer integer) {
        return teamDao.findById(integer);
    }

    @Override
    public boolean existsById(Integer integer) {
        return teamDao.existsById(integer);
    }

    @Override
    public List<Team> findAll() {
        return teamDao.findAll();
    }

    @Override
    public List<Team> findAllById(Iterable<Integer> integers) {
        return teamDao.findAllById(integers);
    }

    @Override
    public long count() {
        return teamDao.count();
    }

    @Override
    public void deleteById(Integer integer) {

        teamDao.deleteById(integer);
    }

    @Override
    public void delete(Team entity) {

        teamDao.delete(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

        teamDao.deleteAllById(integers);
    }

    @Override
    public void deleteAll(Iterable<? extends Team> entities) {

        teamDao.deleteAll(entities);
    }

    @Override
    public void deleteAll() {

        teamDao.deleteAll();
    }

    @Override
    public List<Team> findAll(Sort sort) {
        return teamDao.findAll(sort);
    }

    @Override
    public Page<Team> findAll(Pageable pageable) {
        return teamDao.findAll(pageable);
    }
}
