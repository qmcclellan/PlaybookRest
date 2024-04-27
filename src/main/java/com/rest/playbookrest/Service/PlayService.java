package com.rest.playbookrest.Service;

import com.rest.playbookrest.Dao.PlayDao;
import com.rest.playbookrest.Entity.Play;
import com.rest.playbookrest.Entity.Scheme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class PlayService implements Services<Play>, PagingAndSortingRepository<Play, Integer> {

    private PlayDao playDao;

    public PlayService(PlayDao playDao) {
        this.playDao = playDao;
    }

    @Override
    public Play findByName(String name) {
        return playDao.findByName(name);
    }

    @Override
    public List<Play> findByType(String type) {
        return playDao.findByType(type);
    }

    @Override
    public void flush() {
        playDao.flush();
    }

    @Override
    public <S extends Play> S saveAndFlush(S entity) {
        return playDao.saveAndFlush(entity);
    }

    @Override
    public <S extends Play> List<S> saveAllAndFlush(Iterable<S> entities) {
        return playDao.saveAllAndFlush(entities);
    }

    @Override
    public void deleteAllInBatch(Iterable<Play> entities) {
        playDao.deleteAllInBatch(entities);
    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> integers) {
        playDao.deleteAllByIdInBatch(integers);
    }

    @Override
    public void deleteAllInBatch() {

        playDao.deleteAllInBatch();
    }

    @Override
    public Play getOne(Integer integer) {
        return playDao.getOne(integer);
    }

    @Override
    public Play getById(Integer integer) {
        return playDao.getById(integer);
    }

    @Override
    public Play getReferenceById(Integer integer) {
        return playDao.getReferenceById(integer);
    }

    @Override
    public <S extends Play> Optional<S> findOne(Example<S> example) {
        return playDao.findOne(example);
    }

    @Override
    public <S extends Play> List<S> findAll(Example<S> example) {
        return playDao.findAll(example);
    }

    @Override
    public <S extends Play> List<S> findAll(Example<S> example, Sort sort) {
        return playDao.findAll(example, sort);
    }

    @Override
    public <S extends Play> Page<S> findAll(Example<S> example, Pageable pageable) {
        return findAll(example, pageable);
    }

    @Override
    public <S extends Play> long count(Example<S> example) {
        return playDao.count(example);
    }

    @Override
    public <S extends Play> boolean exists(Example<S> example) {
        return playDao.exists(example);
    }

    @Override
    public <S extends Play, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return playDao.findBy(example,queryFunction);
    }

    @Override
    public <S extends Play> S save(S entity) {
        return playDao.save(entity);
    }

    @Override
    public <S extends Play> List<S> saveAll(Iterable<S> entities) {
        return playDao.saveAll(entities);
    }

    @Override
    public Optional<Play> findById(Integer integer) {
        return playDao.findById(integer);
    }

    @Override
    public boolean existsById(Integer integer) {
        return playDao.existsById(integer);
    }

    @Override
    public List<Play> findAll() {
        return playDao.findAll();
    }

    @Override
    public List<Play> findAllById(Iterable<Integer> integers) {
        return playDao.findAllById(integers);
    }

    @Override
    public long count() {
        return playDao.count();
    }

    @Override
    public void deleteById(Integer integer) {

        playDao.deleteById(integer);
    }

    @Override
    public void delete(Play entity) {

        playDao.delete(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

        playDao.deleteAllById(integers);
    }

    @Override
    public void deleteAll(Iterable<? extends Play> entities) {

        playDao.deleteAll(entities);
    }

    @Override
    public void deleteAll() {

        playDao.deleteAll();
    }

    @Override
    public List<Play> findAll(Sort sort) {
        return playDao.findAll(sort);
    }

    @Override
    public Page<Play> findAll(Pageable pageable) {
        return playDao.findAll(pageable);
    }
}
