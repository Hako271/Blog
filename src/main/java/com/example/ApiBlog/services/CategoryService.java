package com.example.ApiBlog.services;


import com.example.ApiBlog.models.Category;
import com.example.ApiBlog.repository.CategoryRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }



    @PostConstruct
    public void init (){
        if(categoryRepository.findByName("car").isEmpty()) {
            categoryRepository.save(new Category( "car"));
        }
        if(categoryRepository.findByName("work").isEmpty()) {
            categoryRepository.save(new Category( "work"));
        }
        if(categoryRepository.findByName("school").isEmpty()) {
            categoryRepository.save(new Category( "school"));
        }

    }



}
