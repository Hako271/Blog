package com.example.ApiBlog.repository;

import com.example.ApiBlog.models.Articles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ArticlesRepository extends JpaRepository<Articles, Long> {

    Optional<Articles> findAllById(Long id);
    Optional<Articles> findById(Long id);

//    Articles findByCategoryId(Long id);
    List<Articles> findByCategoryId(Long categoryId);
}
