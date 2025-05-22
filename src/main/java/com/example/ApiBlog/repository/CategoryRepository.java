package com.example.ApiBlog.repository;

import com.example.ApiBlog.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
//    Category findByName(String name);


    Optional<Category> findByName(String name);

    Category findById(long id);

    List<Category> findAllById(Long id);
}
