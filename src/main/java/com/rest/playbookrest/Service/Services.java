package com.rest.playbookrest.Service;

import java.util.List;

public interface Services <T>{

    public List<T> findAll();

    public T retrieve(Integer id);

    public T saveAndFlush(T t);

    public void deleteById(Integer id);

}
