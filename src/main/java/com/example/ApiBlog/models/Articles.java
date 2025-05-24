package com.example.ApiBlog.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Articles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;
    private String description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @ManyToOne
   @JoinColumn(name = "category_id")
    private Category category;

   @ManyToOne
   @JoinColumn(name = "user_id")
   private User user;


    public Articles(long id, String description, String title) {
        this.id = id;
        this.description = description;
        this.title = title;
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
