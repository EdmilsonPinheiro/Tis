package com.api.queviagem.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.api.queviagem.models.UserModel;
import com.api.queviagem.repositories.UserRepository;

@Service
public class UserService {
    final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<UserModel> login(String email, String password) {
        return userRepository.getUser(email, password);
    }
}
