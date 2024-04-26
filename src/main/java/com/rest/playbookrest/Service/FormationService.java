package com.rest.playbookrest.Service;

import com.rest.playbookrest.Dao.FormationDao;
import com.rest.playbookrest.Entity.Formation;
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
public class FormationService implements Services<Formation>{

    private FormationDao formationDao;

    public FormationService(FormationDao formationDao) {
        this.formationDao = formationDao;
    }


    @Override
    public Formation findByName(String name) {
        return formationDao.findByName(name);
    }

    @Override
    public List<Formation> findByType(String type) {
        //Need to add type to entity and DB
        return null;
    }

    @Override
    public void flush() {

        formationDao.flush();

    }

    @Override
    public <S extends Formation> S saveAndFlush(S entity) {
        return formationDao.saveAndFlush(entity);
    }

    @Override
    public <S extends Formation> List<S> saveAllAndFlush(Iterable<S> entities) {
        return formationDao.saveAllAndFlush(entities);
    }

    @Override
    public void deleteAllInBatch(Iterable<Formation> entities) {

        formationDao.deleteAllInBatch(entities);
    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> integers) {

        formationDao.deleteAllByIdInBatch(integers);
    }

    @Override
    public void deleteAllInBatch() {

        formationDao.deleteAllInBatch();
    }

    @Override
    public Formation getOne(Integer integer) {
        return formationDao.getReferenceById(integer);
    }

    @Override
    public Formation getById(Integer integer) {
        return formationDao.getById(integer);
    }

    @Override
    public Formation getReferenceById(Integer integer) {
        return formationDao.getReferenceById(integer);
    }

    @Override
    public <S extends Formation> Optional<S> findOne(Example<S> example) {
        return formationDao.findOne(example);
    }

    @Override
    public <S extends Formation> List<S> findAll(Example<S> example) {
        return formationDao.findAll(example);
    }

    @Override
    public <S extends Formation> List<S> findAll(Example<S> example, Sort sort) {
        return formationDao.findAll(example, sort);
    }

    @Override
    public <S extends Formation> Page<S> findAll(Example<S> example, Pageable pageable) {
        return formationDao.findAll(example,pageable);
    }

    @Override
    public <S extends Formation> long count(Example<S> example) {
        return formationDao.count(example);
    }

    @Override
    public <S extends Formation> boolean exists(Example<S> example) {
        return formationDao.exists(example);
    }

    @Override
    public <S extends Formation, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return formationDao.findBy(example,queryFunction);
    }

    @Override
    public <S extends Formation> S save(S entity) {
        return formationDao.save(entity);
    }

    @Override
    public <S extends Formation> List<S> saveAll(Iterable<S> entities) {
        return formationDao.saveAll(entities);
    }

    @Override
    public Optional<Formation> findById(Integer integer) {
        return formationDao.findById(integer);
    }

    @Override
    public boolean existsById(Integer integer) {
        return formationDao.existsById(integer);
    }

    @Override
    public List<Formation> findAll() {
        return formationDao.findAll();
    }

    @Override
    public List<Formation> findAllById(Iterable<Integer> integers) {
        return formationDao.findAllById(integers);
    }

    @Override
    public long count() {
        return formationDao.count();
    }

    @Override
    public void deleteById(Integer integer) {

        formationDao.deleteById(integer);
    }

    @Override
    public void delete(Formation entity) {

        formationDao.delete(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

        formationDao.deleteAllById(integers);
    }

    @Override
    public void deleteAll(Iterable<? extends Formation> entities) {

        formationDao.deleteAll(entities);
    }

    @Override
    public void deleteAll() {

        formationDao.deleteAll();
    }

    @Override
    public List<Formation> findAll(Sort sort) {
        return formationDao.findAll(sort);
    }

    @Override
    public Page<Formation> findAll(Pageable pageable) {
        return formationDao.findAll(pageable);
    }

    public List<Formation> findByFormationsName(String name){

        return formationDao.findFormationsByName(name);
    }
}
