package com.technical.offer.api.service;

import com.technical.offer.api.model.User;
import com.technical.offer.api.repository.UserRepository;
import com.technical.offer.api.service.interfaces.UserService;
import lombok.Data;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User create(User user){
        return userRepository.save(user);
    }

    @Override
    public List<User> fetchAll() {

        return IterableUtils.toList(userRepository.findAll())
                .stream()
                .sorted(Comparator.comparingLong(User::getId))
                .collect(Collectors.toList());
    }



}
