package com.rest.playbookrest.Service;

import com.rest.playbookrest.Dao.CoachDao;
import com.rest.playbookrest.Entity.Coach;
import com.rest.playbookrest.Entity.Play;
import com.rest.playbookrest.Entity.Users;
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
public class CoachService implements Services<Coach> {

    private CoachDao coachDao;

    public CoachService(CoachDao coachDao) {
        this.coachDao = coachDao;
    }

    @Override
    public Coach findByName(String name) {
        return coachDao.findCoachByName(name);
    }

    @Override
    public List<Coach> findByType(String type) {
        return coachDao.findCoachByType(type);
    }

    @Override
    public void flush() {
        coachDao.flush();
    }

    @Override
    public <S extends Coach> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Coach> List<S> saveAllAndFlush(Iterable<S> entities) {
        return coachDao.saveAllAndFlush(entities);
    }

    @Override
    public void deleteAllInBatch(Iterable<Coach> entities) {

        coachDao.deleteAllInBatch(entities);
    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> integers) {

        coachDao.deleteAllByIdInBatch(integers);
    }

    @Override
    public void deleteAllInBatch() {

        coachDao.deleteAllInBatch();
    }

    @Override
    public Coach getOne(Integer integer) {
        return null;
    }

    @Override
    public Coach getById(Integer integer) {
        return coachDao.getById(integer);
    }

    @Override
    public Coach getReferenceById(Integer integer) {
        return coachDao.getReferenceById(integer);
    }

    @Override
    public <S extends Coach> Optional<S> findOne(Example<S> example) {
        return coachDao.findOne(example);
    }

    @Override
    public <S extends Coach> List<S> findAll(Example<S> example) {
        return coachDao.findAll(example);
    }

    @Override
    public <S extends Coach> List<S> findAll(Example<S> example, Sort sort) {
        return coachDao.findAll(example,sort);
    }

    @Override
    public <S extends Coach> Page<S> findAll(Example<S> example, Pageable pageable) {
        return coachDao.findAll(example, pageable);
    }

    @Override
    public <S extends Coach> long count(Example<S> example) {
        return coachDao.count(example);
    }

    @Override
    public <S extends Coach> boolean exists(Example<S> example) {
        return coachDao.exists(example);
    }

    @Override
    public <S extends Coach, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return coachDao.findBy(example, queryFunction);
    }

    @Override
    public <S extends Coach> S save(S entity) {
        return coachDao.save(entity);
    }

    @Override
    public <S extends Coach> List<S> saveAll(Iterable<S> entities) {
        return coachDao.saveAll(entities);
    }

    @Override
    public Optional<Coach> findById(Integer integer) {
        return coachDao.findById(integer);
    }

    @Override
    public boolean existsById(Integer integer) {
        return coachDao.existsById(integer);
    }

    @Override
    public List<Coach> findAll() {
        return coachDao.findAll();
    }

    @Override
    public List<Coach> findAllById(Iterable<Integer> integers) {
        return coachDao.findAllById(integers);
    }

    @Override
    public long count() {
        return coachDao.count();
    }

    @Override
    public void deleteById(Integer integer) {

        coachDao.deleteById(integer);
    }

    @Override
    public void delete(Coach entity) {

        coachDao.delete(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

        coachDao.deleteAllById(integers);

    }

    @Override
    public void deleteAll(Iterable<? extends Coach> entities) {

        coachDao.deleteAll(entities);
    }

    @Override
    public void deleteAll() {

        coachDao.deleteAll();
    }

    @Override
    public List<Coach> findAll(Sort sort) {
        return coachDao.findAll(sort);
    }

    @Override
    public Page<Coach> findAll(Pageable pageable) {
        return coachDao.findAll(pageable);
    }

    public Coach findCoachByUserId(Integer userId){

        return coachDao.findCoachByUserId(userId);
    }

    public Coach findCoachByUserUserName(String userName){

       return coachDao.findCoachByUserUserName(userName);
    }
}
