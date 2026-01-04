package com.dhurba.docker.model;

import jakarta.persistence.*;

@Entity
@Table(name = "model")
public class Model {

    private String id;
    private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
