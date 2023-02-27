package com.technical.offer.api.service.interfaces;

import com.technical.offer.api.model.User;

import java.util.List;

public interface UserService {
    User create(User user);
    List<User> fetchAll();
}
