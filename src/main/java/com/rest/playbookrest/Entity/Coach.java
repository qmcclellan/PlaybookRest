package com.rest.playbookrest.Entity;


import jakarta.persistence.*;

import java.util.Arrays;
import java.util.List;

@Entity
@Table(schema="\"Playbook\"", name="\"Coach\"")
public class Coach {

    private enum CoachType{HEAD, ASSISTANT, OFFENSE, DEFENSE,SPECIAL_TEAMS, }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="name")
    private String name;
    @Column(name="type")
    private CoachType type;

    @Column(name="image")
    private String imagePath;

    @OneToOne
    private Users user;
    @OneToMany(mappedBy = "coach", fetch = FetchType.LAZY,cascade =CascadeType.MERGE)
    List<Playbook> playBooks;

    @ManyToOne(cascade = {CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinColumn(name="team")
    private Team team;

    public Coach() {
    }


    public Coach(String name, CoachType type, Users user) {
        this.name = name;
        this.type = type;
        this.user = user;
    }

    public Coach(String name, CoachType type, Users user, Team team) {
        this.name = name;
        this.type = type;
        this.user = user;
        this.team = team;
    }

    public Coach(String name, CoachType type, String imagePath) {
        this.name = name;
        this.type = type;
        this.imagePath = imagePath;
    }

    public Coach(String name, CoachType type,Team team, String imagePath) {
        this.name = name;
        this.type = type;
        this.team = team;
        this.imagePath = imagePath;

    }
    public Coach(String name, CoachType type, String imagePath, Users user) {
        this.name = name;
        this.type = type;
        this.imagePath = imagePath;
        this.user = user;
    }

    public Coach(String name, CoachType type,Team team, String imagePath, Users user) {
        this.name = name;
        this.type = type;
        this.team = team;
        this.imagePath = imagePath;
        this.user = user;
    }

    public Coach(Integer id, String name, CoachType type,Team team, String imagePath) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.team = team;
        this.imagePath = imagePath;
    }

    public Coach(Integer id, String name, CoachType type, Team team, String imagePath, Users user) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.team = team;
        this.imagePath = imagePath;
        this.user = user;
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

    public CoachType getType() {
        return type;
    }

    public void setType(CoachType type) {
        this.type = type;
    }


    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public List<Playbook> getPlayBooks() {
        return playBooks;
    }

    public void setPlayBooks(List<Playbook> playBooks) {
        this.playBooks = playBooks;
    }

    public void addPlayBooks(Playbook ...playBooksToAdd){

        playBooks = Arrays.asList(playBooksToAdd);
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    @Override
    public String toString() {
        return "Coach{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", imagePath='" + imagePath + '\'' +
                ", user=" + user +
                ", playBooks=" + playBooks +
                ", team=" + team +
                '}';
    }
}
