package com.rest.playbookrest.Service;

import com.rest.playbookrest.Dao.PlaybookDao;
import com.rest.playbookrest.Entity.Playbook;
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
public class PlaybookService implements Services<Playbook> {


    private final PlaybookDao playbookDao;

    @Autowired
    public PlaybookService(PlaybookDao playbookDao) {
        this.playbookDao = playbookDao;
    }

    @Override
    public Playbook findByName(String name) {
        return playbookDao.findByName(name);
    }

    @Override
    public List<Playbook> findByType(String type) {
        return playbookDao.findByType(type);
    }

    @Override
    public void flush() {

        playbookDao.flush();
    }

    @Override
    public <S extends Playbook> S saveAndFlush(S entity) {
        return playbookDao.saveAndFlush(entity);
    }

    @Override
    public <S extends Playbook> List<S> saveAllAndFlush(Iterable<S> entities) {
        return playbookDao.saveAllAndFlush(entities);
    }

    @Override
    public void deleteAllInBatch(Iterable<Playbook> entities) {

        playbookDao.deleteAllInBatch(entities);
    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> integers) {

        playbookDao.deleteAllByIdInBatch(integers);
    }

    @Override
    public void deleteAllInBatch() {

        playbookDao.deleteAllInBatch();
    }

    @Override
    public Playbook getOne(Integer integer) {
        return null;
    }

    @Override
    public Playbook getById(Integer integer) {
        return playbookDao.getReferenceById(integer);
    }

    @Override
    public Playbook getReferenceById(Integer integer) {
        return playbookDao.getReferenceById(integer);
    }

    @Override
    public <S extends Playbook> Optional<S> findOne(Example<S> example) {
        return playbookDao.findOne(example);
    }

    @Override
    public <S extends Playbook> List<S> findAll(Example<S> example) {
        return playbookDao.findAll(example);
    }

    @Override
    public <S extends Playbook> List<S> findAll(Example<S> example, Sort sort) {
        return playbookDao.findAll(example,sort);
    }

    @Override
    public <S extends Playbook> Page<S> findAll(Example<S> example, Pageable pageable) {
        return playbookDao.findAll(example,pageable);
    }

    @Override
    public <S extends Playbook> long count(Example<S> example) {
        return playbookDao.count(example);
    }

    @Override
    public <S extends Playbook> boolean exists(Example<S> example) {
        return playbookDao.exists(example);
    }

    @Override
    public <S extends Playbook, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return playbookDao.findBy(example,queryFunction);
    }

    @Override
    public <S extends Playbook> S save(S entity) {
        return playbookDao.save(entity);
    }

    @Override
    public <S extends Playbook> List<S> saveAll(Iterable<S> entities) {
        return playbookDao.saveAll(entities);
    }

    @Override
    public Optional<Playbook> findById(Integer integer) {
        return playbookDao.findById(integer);
    }

    @Override
    public boolean existsById(Integer integer) {
        return playbookDao.existsById(integer);
    }

    @Override
    public List<Playbook> findAll() {
        return playbookDao.findAll();
    }

    @Override
    public List<Playbook> findAllById(Iterable<Integer> integers) {
        return playbookDao.findAllById(integers);
    }

    @Override
    public long count() {
        return playbookDao.count();
    }

    @Override
    public void deleteById(Integer integer) {

        playbookDao.deleteById(integer);
    }

    @Override
    public void delete(Playbook entity) {

        playbookDao.delete(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

        playbookDao.deleteAllById(integers);
    }

    @Override
    public void deleteAll(Iterable<? extends Playbook> entities) {

        playbookDao.deleteAll(entities);
    }

    @Override
    public void deleteAll() {

        playbookDao.deleteAll();

    }

    @Override
    public List<Playbook> findAll(Sort sort) {
        return playbookDao.findAll(sort);
    }

    @Override
    public Page<Playbook> findAll(Pageable pageable) {
        return playbookDao.findAll(pageable);
    }

    public List<Playbook> findByCoachId(Integer id){

        return playbookDao.findByCoachId(id);
    }
}
