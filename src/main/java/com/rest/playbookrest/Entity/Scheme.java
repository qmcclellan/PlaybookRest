package com.rest.playbookrest.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(schema="\"Playbook\"", name="\"scheme\"")
public class Scheme implements Serializable {


    private enum SchemeType{}
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="name")
    private String name;

    @Column(name="type")
    private String type;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "formation_id")
    private Formation formation;

    @OneToMany(mappedBy = "scheme", fetch = FetchType.LAZY)
    @JsonManagedReference
    @JsonIgnoreProperties("scheme")
    private List<Play> plays;

    public Scheme() {
    }

    public Scheme(String name, String type, Formation formation) {
        this.name = name;
        this.type = type;
        this.formation = formation;
    }

    public Scheme(Integer id, String name, String type,  Formation formation) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.formation = formation;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Formation getFormation() {
        return formation;
    }

    public void setFormation(Formation formation) {
        this.formation = formation;
    }

    public List<Play> getPlays() {
        return plays;
    }

    public void setPlays(List<Play> plays) {
        this.plays = plays;
    }

    public void addPlay(Play ...newPlays){

        if(plays  == null){
            plays  = new ArrayList<>();
        }

        plays  = Arrays.asList(newPlays);

    }

    @Override
    public String toString() {
        return "Scheme{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", formation=" + formation +
                '}';
    }
}
