package com.rest.playbookrest.Service;

import com.rest.playbookrest.Dao.SchemeDao;
import com.rest.playbookrest.Entity.Formation;
import com.rest.playbookrest.Entity.Play;
import com.rest.playbookrest.Entity.Scheme;
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
public class SchemeService implements Services<Scheme>{

    private SchemeDao schemeDao;

    @Autowired
    public SchemeService(SchemeDao schemeDao) {
        this.schemeDao = schemeDao;
    }


    @Override
    public Scheme findByName(String name) {
        return schemeDao.findByName(name);
    }

    @Override
    public List<Scheme> findByType(String type) {
        return schemeDao.findByType(type);
    }

    @Override
    public void flush() {

        schemeDao.flush();
    }

    @Override
    public <S extends Scheme> S saveAndFlush(S entity) {
        return schemeDao.saveAndFlush(entity);
    }

    @Override
    public <S extends Scheme> List<S> saveAllAndFlush(Iterable<S> entities) {
        return schemeDao.saveAllAndFlush(entities);
    }

    @Override
    public void deleteAllInBatch(Iterable<Scheme> entities) {

        schemeDao.deleteAllInBatch(entities);
    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> integers) {

        schemeDao.deleteAllById(integers);
    }

    @Override
    public void deleteAllInBatch() {

        schemeDao.deleteAllInBatch();

    }

    @Override
    public Scheme getOne(Integer integer) {
        return schemeDao.getOne(integer);
    }

    @Override
    public Scheme getById(Integer integer) {
        return schemeDao.getById(integer);
    }

    @Override
    public Scheme getReferenceById(Integer integer) {
        return schemeDao.getReferenceById(integer);
    }

    @Override
    public <S extends Scheme> Optional<S> findOne(Example<S> example) {
        return schemeDao.findOne(example);
    }

    @Override
    public <S extends Scheme> List<S> findAll(Example<S> example) {
        return schemeDao.findAll(example);
    }

    @Override
    public <S extends Scheme> List<S> findAll(Example<S> example, Sort sort) {
        return schemeDao.findAll(example,sort);
    }

    @Override
    public <S extends Scheme> Page<S> findAll(Example<S> example, Pageable pageable) {
        return schemeDao.findAll(example,pageable);
    }

    @Override
    public <S extends Scheme> long count(Example<S> example) {
        return schemeDao.count(example);
    }

    @Override
    public <S extends Scheme> boolean exists(Example<S> example) {
        return schemeDao.exists(example);
    }

    @Override
    public <S extends Scheme, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return schemeDao.findBy(example,queryFunction);
    }

    @Override
    public <S extends Scheme> S save(S entity) {
        return schemeDao.save(entity);
    }

    @Override
    public <S extends Scheme> List<S> saveAll(Iterable<S> entities) {
        return schemeDao.saveAll(entities);
    }

    @Override
    public Optional<Scheme> findById(Integer integer) {
        return schemeDao.findById(integer);
    }

    @Override
    public boolean existsById(Integer integer) {
        return schemeDao.existsById(integer);
    }

    @Override
    public List<Scheme> findAll() {
        return schemeDao.findAll();
    }

    @Override
    public List<Scheme> findAllById(Iterable<Integer> integers) {
        return schemeDao.findAllById(integers);
    }

    @Override
    public long count() {
        return schemeDao.count();
    }

    @Override
    public void deleteById(Integer integer) {

        schemeDao.deleteById(integer);
    }

    @Override
    public void delete(Scheme entity) {

        schemeDao.delete(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

        schemeDao.deleteAllById(integers);
    }

    @Override
    public void deleteAll(Iterable<? extends Scheme> entities) {

        schemeDao.deleteAll(entities);
    }

    @Override
    public void deleteAll() {

        schemeDao.deleteAll();
    }

    @Override
    public List<Scheme> findAll(Sort sort) {
        return schemeDao.findAll(sort);
    }

    @Override
    public Page<Scheme> findAll(Pageable pageable) {
        return schemeDao.findAll(pageable);
    }
}
