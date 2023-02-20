package com.technical.offer.api.controller;

import com.technical.offer.api.dto.RegisterUserDto;
import com.technical.offer.api.model.User;
import com.technical.offer.api.service.interfaces.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.rmi.ServerException;

@RequestMapping(value = "/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/fetchAll")
    public Iterable<User> getUsers() {
        return new ResponseEntity<>(userService.fetchAll(), HttpStatus.OK).getBody();
    }

    @PostMapping("/create")
    public ResponseEntity<User> create(@Valid @RequestBody RegisterUserDto registerUserDto) throws ServerException {
        User user = userService.create(registerUserDto.toUser());
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

}
