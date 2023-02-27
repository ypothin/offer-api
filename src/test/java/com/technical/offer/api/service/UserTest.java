package com.technical.offer.api.service;

import com.technical.offer.api.model.User;
import com.technical.offer.api.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class UserTest {

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserRepository userRepository;
    @Test
    public void testCreateUser() {
        User user = new User()
                .setGender("mr")
                .setName("testeur")
                .setBirthDay(new Date("25/12/1980"))
                .setCountry("france")
                .setPhone("+33710203040");

        userService.create(user);
        verify((userRepository), times(1)).save(user);
    }
}
