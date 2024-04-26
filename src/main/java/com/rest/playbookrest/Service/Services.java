package com.rest.playbookrest.Service;

import com.rest.playbookrest.Entity.Play;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public interface Services <T>{



    public T findByName(String name);


    public List<T> findByType(String type);


    public void flush();


    public <S extends T> S saveAndFlush(S entity);


    public <S extends T> List<S> saveAllAndFlush(Iterable<S> entities);


    public void deleteAllInBatch(Iterable<T> entities);


    public void deleteAllByIdInBatch(Iterable<Integer> integers);


    public void deleteAllInBatch();


    public T getOne(Integer integer);


    public T getById(Integer integer);


    public T getReferenceById(Integer integer);


    public <S extends T> Optional<S> findOne(Example<S> example);


    public <S extends T> List<S> findAll(Example<S> example);


    public <S extends T> List<S> findAll(Example<S> example, Sort sort);


    public <S extends T> Page<S> findAll(Example<S> example, Pageable pageable);


    public <S extends T> long count(Example<S> example);


    public <S extends T> boolean exists(Example<S> example);


    public <S extends T, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction);


    public <S extends T> S save(S entity);


    public <S extends T> List<S> saveAll(Iterable<S> entities);


    public Optional<T> findById(Integer integer);


    public boolean existsById(Integer integer);


    public List<T> findAll();


    public List<T> findAllById(Iterable<Integer> integers);


    public long count();


    public void deleteById(Integer integer);


    public void delete(T entity);

    public void deleteAllById(Iterable<? extends Integer> integers);


    public void deleteAll(Iterable<? extends T> entities);


    public void deleteAll();


    public List<T> findAll(Sort sort);


    public Page<T> findAll(Pageable pageable);
}
