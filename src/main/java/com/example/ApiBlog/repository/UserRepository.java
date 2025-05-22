package com.example.ApiBlog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ApiBlog.models.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

  Optional<User> findByEmail(String email);


  public void deleteByEmail(String email);


}
