package com.rest.playbookrest.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(schema="\"Playbook\"", name="\"team\"")
public class Team implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    @Column(name="name")
    private String name;
    @Column(name="image")
    private String image;
    @JsonManagedReference
    @OneToMany(mappedBy="team",cascade = CascadeType.ALL)
    List<Playbook> playBooks;
    @JsonManagedReference
    @OneToMany(mappedBy="team",cascade = CascadeType.ALL)
    List<Coach> coaches;
    public Team() {
    }

    public Team(String name, String image) {
        this.name = name;
        this.image = image;
    }

    public Team(int id, String name, String image) {
        this.id = id;
        this.name = name;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<Playbook> getPlayBooks() {
        return playBooks;
    }

    public void setPlayBooks(List<Playbook> playBook) {
        this.playBooks = playBook;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Coach> getCoaches() {
        return coaches;
    }

    public void setCoaches(List<Coach> coaches) {
        this.coaches = coaches;
    }

    public void addPlayBooks(Playbook ...playbooks){

        if(playBooks == null){
            playBooks= new ArrayList<>();
        }

        playBooks = Arrays.asList(playbooks);
    }

    public void addCoaches(Coach ...theCoaches){

        if(coaches == null){
            coaches= new ArrayList<>();
        }

       coaches = Arrays.asList(theCoaches);
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", playBooks=" + getPlayBooks() +
                ", coaches=" + getCoaches() +
                '}';
    }
}
