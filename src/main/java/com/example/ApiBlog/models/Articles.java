package com.example.ApiBlog.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Articles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String description;

    @OneToMany
    @JoinColumn(name = "categoryId")
    private List<Category> categories = new ArrayList<>();


    public Articles(long id, String description) {
        this.id = id;
        this.description = description;
    }

    public Articles() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Articles{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
