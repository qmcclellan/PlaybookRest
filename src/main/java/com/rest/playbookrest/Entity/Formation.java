package com.rest.playbookrest.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(schema="\"Playbook\"", name="\"formation\"")
public class Formation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "playbook_id")
    Playbook playBook;

    @OneToMany(mappedBy = "formation")
    private List<Scheme> schemes;



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

    public void setPlayBook(Playbook playBook) {
        this.playBook = playBook;
    }

    public List<Scheme> getSchemes() {
        return schemes;
    }

    public void setSchemes(List<Scheme> schemes) {
        this.schemes = schemes;
    }
}