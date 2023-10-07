package com.rest.playbookrest.Service;

import com.rest.playbookrest.Dao.UsersDao;
import com.rest.playbookrest.Entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService implements UserDetailsService, Services<Users> {

    private UsersDao usersDao;

    @Autowired
    public UsersService(UsersDao usersDao) {
        this.usersDao = usersDao;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }

    @Override
    public List<Users> findAll() {
        return null;
    }

    @Override
    public Users retrieve(Integer id) {
        return null;
    }

    @Override
    public Users saveAndFlush(Users users) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }
}
