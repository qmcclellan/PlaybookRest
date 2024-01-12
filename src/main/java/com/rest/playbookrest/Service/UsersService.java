package com.rest.playbookrest.Service;

import com.rest.playbookrest.Dao.RoleDao;
import com.rest.playbookrest.Dao.UsersDao;
import com.rest.playbookrest.Entity.Role;
import com.rest.playbookrest.Entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
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

@Service
public class UsersService implements UserDetailsService, Services<Users> {

    private UsersDao usersDao;

    private RoleDao roleDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UsersService(UsersDao usersDao, RoleDao roleDao) {
        this.usersDao = usersDao;
        this.roleDao = roleDao;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = findByUserName(username);
        if (user == null) {

            throw new UsernameNotFoundException("Invalid username or password.");
        }


        List<GrantedAuthority>authorities = new ArrayList<>();

        authorities.add(new SimpleGrantedAuthority(user.getRoles().toString()));

        return new User(user.getUserName(), user.getPassword().trim(), authorities);
    }

    @Override
    public List<Users> findAll() {
        return usersDao.findAll();
    }

    @Override
    public Users retrieve(Integer id) {
        return usersDao.getReferenceById(id);
    }

    @Override
    public Users saveAndFlush(Users users) {

        users.setPassword(passwordEncoder.encode(users.getPassword()));

        return usersDao.saveAndFlush(users);
    }

    @Override
    public void deleteById(Integer id) {

        Users user= usersDao.getReferenceById(id);

        user.setEnabled(false);

        usersDao.save(user);
    }

    public Users findByUserName(String userName){

        System.out.println(userName);

        Users user = usersDao.findByUserName(userName);

        return user;
    }

    public List<Role> findAllRoles(){

        List<Role> roles = null;

        roles = roleDao.findAll();

        return  roles;
    }



    public Role findRoleByName(String name) {

        return roleDao.findRoleByName(name);
    }
}
