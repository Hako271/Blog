package com.example.ApiBlog.controllers;

import com.example.ApiBlog.models.Category;
import com.example.ApiBlog.repository.CategoryRepository;
import com.example.ApiBlog.services.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CategoryController {

    private final CategoryRepository categoryRepository;
    private final CategoryService categoryService;

    public CategoryController(CategoryRepository categoryRepository, CategoryService categoryService) {
        this.categoryRepository = categoryRepository;
        this.categoryService = categoryService;
    }



    @GetMapping("/category")
    public String AllCategory(Model model) {
//        model.addAttribute("categories", categoryService.getAllCategories());
//        return "category";
        List<Category> categories = categoryService.getAllCategories();
        System.out.println("Rozmiar listy kategorii: " + categories.size());
        for (Category c : categories) {
            System.out.println("Kategoria: " + c.getName());
        }

        model.addAttribute("categories", categories);
        return "category";
    }


}
