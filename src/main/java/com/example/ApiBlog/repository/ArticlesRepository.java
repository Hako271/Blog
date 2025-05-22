package com.example.ApiBlog.repository;

import com.example.ApiBlog.models.Articles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ArticlesRepository extends JpaRepository<Articles, Long> {

    Optional<Articles> findAllById(Long id);

}
