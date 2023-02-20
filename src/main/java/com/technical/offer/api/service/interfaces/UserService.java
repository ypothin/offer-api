package com.technical.offer.api.service.interfaces;

import com.technical.offer.api.model.User;

public interface UserService {
    User create(User user);
    Iterable<User> fetchAll();
}
