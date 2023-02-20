package com.technical.offer.api.service;

import com.technical.offer.api.model.User;
import com.technical.offer.api.repository.UserRepository;
import com.technical.offer.api.service.interfaces.UserService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User create(User user) {
        User saveUser = userRepository.save(user);
        return saveUser;
    }

    @Override
    public Iterable<User> fetchAll() {
        return userRepository.findAll();
    }
}
