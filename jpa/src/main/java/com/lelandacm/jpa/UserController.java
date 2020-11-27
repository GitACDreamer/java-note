package com.lelandacm.jpa;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author LelandACM
 */
@RestController
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/all")
    public List<UserEntity> all() {
        List<UserEntity> us = userRepository.findAll();
        System.out.println("us"+us.toString());
        return userRepository.findAll();
    }
}
