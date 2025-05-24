package com.example.ApiBlog.services;


import com.example.ApiBlog.models.Articles;
import com.example.ApiBlog.repository.ArticlesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticlesService {
    private final ArticlesRepository articlesRepository;

    public ArticlesService(ArticlesRepository articlesRepository) {
        this.articlesRepository = articlesRepository;
    }

    public Articles createArticles(Articles article, String email) {


        return articlesRepository.save(article);

    }







}
