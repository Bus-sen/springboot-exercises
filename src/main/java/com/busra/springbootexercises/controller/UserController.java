package com.busra.springbootexercises.controller;

import com.busra.springbootexercises.dto.request.UserRequest;
import com.busra.springbootexercises.dto.response.UserResponse;
import com.busra.springbootexercises.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @PostMapping("/create")
    public UserResponse create(@RequestBody UserRequest userRequest) {
        return userService.create(userRequest);
    }

    @GetMapping
    public List<UserResponse> findAllUsers() {
        return userService.findAllUsers();
    }
}
