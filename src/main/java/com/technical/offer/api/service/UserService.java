package com.technical.offer.api.service;

import com.technical.offer.api.model.User;
import com.technical.offer.api.repository.UserRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Optional<User> getUser(final Long id) {
        return userRepository.findById(id);
    }

    public Iterable<User> getUsers() {
        return userRepository.findAll();
    }
    public User save(User user) {
        User saveUser = userRepository.save(user);
        return saveUser;
    }
}
