package com.example.ApiBlog.controllers;


import com.example.ApiBlog.models.Articles;
import com.example.ApiBlog.repository.ArticlesRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ArticleController {
    private final ArticlesRepository articlesRepository;

    public ArticleController(ArticlesRepository articlesRepository) {
        this.articlesRepository = articlesRepository;
    }





//    @GetMapping("/details/{id}")
//    public String dedails(@PathVariable Long id, Model model) {
//        Articles article = articlesRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Article not found"));
//        model.addAttribute("article", article);
//        model.addAttribute("id", articlesRepository.findById(id));
//        return "details";
//    }


    @GetMapping("/details/{id}")
    public String dedails(@PathVariable Long id, Model model) {
        Articles article = articlesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Article not found"));
        model.addAttribute("article", article);
        model.addAttribute("id", articlesRepository.findById(id));
        return "details";
    }

}
