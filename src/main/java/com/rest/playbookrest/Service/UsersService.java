package com.rest.playbookrest.Service;

import com.rest.playbookrest.Dao.RoleDao;
import com.rest.playbookrest.Dao.UsersDao;
import com.rest.playbookrest.Entity.Role;
import com.rest.playbookrest.Entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class UsersService implements Services<Users>, UserDetailsService {

    private UsersDao usersDao;

    private RoleDao roleDao;


    private PasswordEncoder passwordEncoder;

    public UsersService(UsersDao usersDao, RoleDao roleDao) {
        this.usersDao = usersDao;
        this.roleDao = roleDao;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = findByName(username);
        if (user == null) {

            throw new UsernameNotFoundException("Invalid username or password.");
        }


        List<GrantedAuthority>authorities = new ArrayList<>();

        authorities.add(new SimpleGrantedAuthority(user.getRoles().toString()));

        return new User(user.getUserName(), user.getPassword().trim(), authorities);
    }

    @Override
    public Users findByName(String name) {
        return usersDao.findByUserName(name);
    }

    @Override
    public List<Users> findByType(String type) {
        return usersDao.findUsersByRoleName(type);
    }

    @Override
    public void flush() {

        usersDao.flush();
    }

    @Override
    public <S extends Users> S saveAndFlush(S entity) {

       String encodedPass = passwordEncoder.encode(entity.getPassword());

       entity.setPassword(encodedPass);

        return usersDao.saveAndFlush(entity);
    }

    @Override
    public <S extends Users> List<S> saveAllAndFlush(Iterable<S> entities) {

        for(Users user: entities){

            String encodedPass = passwordEncoder.encode(user.getPassword());

            user.setPassword(encodedPass);
        }

        return usersDao.saveAllAndFlush(entities);
    }

    @Override
    public void deleteAllInBatch(Iterable<Users> entities) {

        usersDao.deleteAllInBatch(entities);
    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> integers) {

        usersDao.deleteAllByIdInBatch(integers);
    }

    @Override
    public void deleteAllInBatch() {

        usersDao.deleteAllInBatch();
    }

    @Override
    public Users getOne(Integer integer) {
        return usersDao.getOne(integer);
    }

    @Override
    public Users getById(Integer integer) {
        return usersDao.getById(integer);
    }

    @Override
    public Users getReferenceById(Integer integer) {
        return usersDao.getReferenceById(integer);
    }

    @Override
    public <S extends Users> Optional<S> findOne(Example<S> example) {
        return usersDao.findOne(example);
    }

    @Override
    public <S extends Users> List<S> findAll(Example<S> example) {
        return usersDao.findAll(example);
    }

    @Override
    public <S extends Users> List<S> findAll(Example<S> example, Sort sort) {
        return usersDao.findAll(example,sort);
    }

    @Override
    public <S extends Users> Page<S> findAll(Example<S> example, Pageable pageable) {
        return usersDao.findAll(example,pageable);
    }

    @Override
    public <S extends Users> long count(Example<S> example) {
        return usersDao.count(example);
    }

    @Override
    public <S extends Users> boolean exists(Example<S> example) {
        return usersDao.exists(example);
    }

    @Override
    public <S extends Users, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return usersDao.findBy(example,queryFunction);
    }

    @Override
    public <S extends Users> S save(S entity) {

        String encodedPass = passwordEncoder.encode(entity.getPassword());

        entity.setPassword(encodedPass);

        return usersDao.save(entity);
    }

    @Override
    public <S extends Users> List<S> saveAll(Iterable<S> entities) {
        return usersDao.saveAll(entities);
    }

    @Override
    public Optional<Users> findById(Integer integer) {
        return usersDao.findById(integer);
    }

    @Override
    public boolean existsById(Integer integer) {
        return usersDao.existsById(integer);
    }

    @Override
    public List<Users> findAll() {
        return usersDao.findAll();
    }

    @Override
    public List<Users> findAllById(Iterable<Integer> integers) {
        return usersDao.findAllById(integers);
    }

    @Override
    public long count() {
        return usersDao.count();
    }

    @Override
    public void deleteById(Integer integer) {

        usersDao.deleteById(integer);
    }

    @Override
    public void delete(Users entity) {

        usersDao.delete(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

        usersDao.deleteAllById(integers);
    }

    @Override
    public void deleteAll(Iterable<? extends Users> entities) {

        usersDao.deleteAll(entities);
    }

    @Override
    public void deleteAll() {

        usersDao.deleteAll();
    }

    @Override
    public List<Users> findAll(Sort sort) {
        return usersDao.findAll(sort);
    }

    @Override
    public Page<Users> findAll(Pageable pageable) {
        return usersDao.findAll(pageable);
    }
}
