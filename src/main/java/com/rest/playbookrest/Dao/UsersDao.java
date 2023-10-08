package com.rest.playbookrest.Dao;

import com.rest.playbookrest.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersDao extends JpaRepository<Users, Integer> {

    public Users findByUserName(String userName);



}
