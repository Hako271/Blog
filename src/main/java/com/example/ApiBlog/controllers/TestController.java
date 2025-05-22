package com.example.ApiBlog.controllers;

import com.example.ApiBlog.repository.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import com.example.ApiBlog.models.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
public class TestController {

    private final UserRepository userRepository;

    public TestController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/siema")
    @ResponseBody
    public String siema() {
        Authentication name = SecurityContextHolder.getContext().getAuthentication();
        String email = name.getName();
        Optional<User> optionalUser = userRepository.findByEmail(email);
        User user = optionalUser.get();



        return "siemano! " + user.getFirstName();
    }
}