package com.example.ApiBlog.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity

public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column(unique = true, name = "name")
    private String name;


    @OneToMany(mappedBy = "category")
    private List<Articles> articles = new ArrayList<>();

    public  Category(){}



//    public Category(long id, String name) {
//        this.id = id;
//        this.name = name;
//    }

    public Category(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Category(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
