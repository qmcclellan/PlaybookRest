package com.rest.playbookrest.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="role", schema="\"Playbook\"")
public class Role {
    @Id
    @Column(name="id")
    private Integer id;

    @Column(name="name")
    private String name;
    @ManyToMany(mappedBy = "roles")
    private List<Users> users;

    public Role() {
    }

    public Role(String name) {
        this.name = name;
    }

    public Role(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Users> getUser() {
        return users;
    }

    public void setUser(List<Users> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name  +
                '}';
    }
}

