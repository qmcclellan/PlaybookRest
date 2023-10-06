package com.rest.playbookrest.Dao;

import com.rest.playbookrest.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDao extends JpaRepository<Role,Integer> {

    public Role findRoleByName(String theRoleName);

}
