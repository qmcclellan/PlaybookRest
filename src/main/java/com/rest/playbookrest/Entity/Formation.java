package com.rest.playbookrest.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.hibernate.annotations.WhereJoinTable;
import org.springframework.data.annotation.QueryAnnotation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(schema="\"Playbook\"", name="\"formation\"")
public class Formation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="name")
    private String name;

    @Column(name="type")
    private String type;

    @JsonBackReference
    @JsonIgnoreProperties("formations")
    @ManyToOne
    @JoinColumn(name = "playbook_id")
    private Playbook playBook;

    @OneToMany(mappedBy = "formation", cascade = CascadeType.ALL,orphanRemoval = true)
    @JsonManagedReference
    @JsonIgnoreProperties("formation")
    private List<Scheme> schemes = new ArrayList<>();



    public Formation() {
    }

    public Formation(String name) {
        this.name = name;
    }

    public Formation(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Formation(String name, Playbook playBook) {
        this.name = name;
        this.playBook = playBook;
    }

    public Formation(Integer id, String name, Playbook playBook) {
        this.id = id;
        this.name = name;
        this.playBook = playBook;
    }

    public Formation(Integer id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
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

    public Playbook getPlayBook() {
        return playBook;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {

            this.type = type;

    }

    public void setPlayBook(Playbook playBook) {
        this.playBook = playBook;
    }

    public List<Scheme> getSchemes() {
        return schemes;
    }

    public void setSchemes(List<Scheme> schemes) {
        this.schemes = schemes;
    }

    public void addSchemes(List<Scheme> scheme){

        if(schemes == null){

            schemes = new ArrayList<>();
        }

        schemes.addAll(schemes);


    }

    @Override
    public String toString() {
        return "Formation{" +
                "id=" + id +
                ", name='" + name + '\'' +
               // ", playBook=" + playBook +
                '}';
    }
}
