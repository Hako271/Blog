package com.example.ApiBlog.controllers;


import com.example.ApiBlog.conf.UserRegistrationDto;
import com.example.ApiBlog.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {
    private final UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;

    }


    @GetMapping("/register")
    public String register(Model model) {
        UserRegistrationDto userRegistrationDto = new UserRegistrationDto();

        model.addAttribute("user", userRegistrationDto);
        return "register";
    }

    @PostMapping("/register")
    public String registerPost(UserRegistrationDto userRegistrationDto) {
        userService.register(userRegistrationDto);
        return "redirect:/login";
    }

}
