package com.technical.offer.api.controller;

import com.technical.offer.api.model.User;
import com.technical.offer.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.rmi.ServerException;

@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/fetchAll")
    public Iterable<User> getUsers() {
        return userService.getUsers();
    }

    @PostMapping(path="/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> create(@RequestBody User newUser) throws ServerException {
        System.out.println(newUser);
        User user = userService.save(newUser);
        if (user == null) {
            throw  new ServerException("Error create user");
        } else {
            return new ResponseEntity<>(user, HttpStatus.CREATED);
        }
    }

}
