package com.example.oauth2.controllers;

import com.example.oauth2.dtos.UserDTO;
import com.example.oauth2.entities.user.User;
import com.example.oauth2.repositories.UserRepository;
import com.example.oauth2.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public String create(
        @RequestBody UserDTO dto
    ){
        return userService.createAndUpdate(dto);
    }
}
