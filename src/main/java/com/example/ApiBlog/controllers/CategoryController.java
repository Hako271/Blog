package com.example.ApiBlog.controllers;

import com.example.ApiBlog.models.Category;
import com.example.ApiBlog.repository.ArticlesRepository;
import com.example.ApiBlog.repository.CategoryRepository;
import com.example.ApiBlog.services.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Controller
public class CategoryController {

    private final CategoryRepository categoryRepository;
    private final CategoryService categoryService;

    private final ArticlesRepository articlesRepository;

    public CategoryController(CategoryRepository categoryRepository, CategoryService categoryService, ArticlesRepository articlesRepository) {
        this.categoryRepository = categoryRepository;
        this.categoryService = categoryService;
        this.articlesRepository = articlesRepository;
    }



    @GetMapping("/category")
    public String AllCategory(Model model) {
//        model.addAttribute("categories", categoryService.getAllCategories());
//        return "category";
        List<Category> categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);
        return "category";
    }

    @GetMapping("/category/{id}")
    public String articlesByCategory(@PathVariable Long id, Model model){
//        Optional<Category> category = categoryRepository.findById(id);
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        model.addAttribute("category", category);
        model.addAttribute("articles", articlesRepository.findByCategoryId(id));

        return "articles";

    }













//    @GetMapping("/category/{id}")
//    public String getCategoryById(Model model, @PathVariable Long id) {
//        Optional<Category> category = categoryRepository.findById(id);
//        model.addAttribute("category", category);
//        return "category";
//    }


}
