package com.api.queviagem.controllers;

import java.util.Optional;

import org.hibernate.mapping.List;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.queviagem.dtos.UsersDto;
import com.api.queviagem.exceptions.Users.UserNotFoundException;
import com.api.queviagem.models.UserModel;
import com.api.queviagem.services.RatingService;
import com.api.queviagem.services.UserService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping("/users")

public class UserController {
    final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody @Valid UsersDto usersDto) throws Exception {
        var usersModel = new UserModel();
        BeanUtils.copyProperties(usersDto, usersModel);

        Optional<UserModel> userModelOptional = userService.login(usersDto.getEmail(), usersDto.getPassword());
        if (!userModelOptional.isPresent()) {
            UserNotFoundException.throwException();
        }
        return ResponseEntity.status(HttpStatus.OK).body(userModelOptional.get());
    }
}
