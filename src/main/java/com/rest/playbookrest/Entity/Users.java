package com.rest.playbookrest.Entity;

import jakarta.persistence.*;


import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="\"user\"", schema="\"Playbook\"")
public class Users implements Serializable {

    @Id
    private Integer id;
    @Column(name="username")
    private String userName;
    @Column(name="password")
    private String password;

    @Column(name="enabled")
    private boolean enabled = true;

    @ManyToMany(fetch = FetchType.EAGER,
            cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "\"users_roles\"", schema="\"Playbook\"",
    joinColumns= @JoinColumn(name = "users_id"),
    inverseJoinColumns=@JoinColumn(name="role_id"))
    private List<Role> roles;

    public Users() {
    }

    public Users(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public Users(String userName, String password, boolean enabled) {
        this.userName = userName;
        this.password = password;
        this.enabled = enabled;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Role getRole() {
        return roles.get(0);
    }
    @Override
    public String toString() {
        return "Users{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", enabled=" + enabled +
                '}';
    }
}
