package com.example.ApiBlog.services;

import com.example.ApiBlog.conf.UserRegistrationDto;
import com.example.ApiBlog.models.User;
import com.example.ApiBlog.models.UserRole;
import com.example.ApiBlog.repository.UserRepository;
import com.example.ApiBlog.repository.UserRoleRepository;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserService {


    private static final String USER_ROLE = "ROLE_USER";
    private static final String ADMIN_ROLE = "ROLE_ADMIN";
    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, UserRoleRepository userRoleRepository, PasswordEncoder passwordEncoder) {


        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.passwordEncoder = passwordEncoder;
    }




    @PostConstruct
    public void init() {
        if (userRoleRepository.findByName("ROLE_USER").isEmpty()) {
            userRoleRepository.save(new UserRole(null, "ROLE_USER"));
        }
        if (userRoleRepository.findByName("ROLE_ADMIN").isEmpty()) {
            userRoleRepository.save(new UserRole(null, "ROLE_ADMIN"));
        }
    }
    public List<String> findAllByEmail() {
        return userRepository.findAll()
                .stream()
                .map(user -> user.getEmail())
                .toList();
    }

    @Transactional
    public void deleteByEmail (String email) {
        if (isCurrentUserAdmin()) {
            userRepository.deleteByEmail(email);
        } else {
            throw new RuntimeException("You are not authorized to delete this user");
        }
    }

    private boolean isCurrentUserAdmin() {
        return SecurityContextHolder.getContext()
                .getAuthentication()
                .getAuthorities()
                .stream()
                .anyMatch(authority -> authority.getAuthority().equals(ADMIN_ROLE));
    }

    @Transactional
    public void register(UserRegistrationDto registration){
        User user = new User();
        user.setFirstName(registration.getFirstName());
        user.setLastName(registration.getLastName());
        user.setEmail(registration.getEmail());
        String hashPass = passwordEncoder.encode(registration.getPassword());
        user.setPassword(hashPass);
        Optional<UserRole> userRole =userRoleRepository.findByName(USER_ROLE);
        userRole.ifPresentOrElse(
                role -> user.getRoles().add(role),
                () -> {
                    throw new NoSuchElementException();
                }
        );
        userRepository.save(user);

    }





}
