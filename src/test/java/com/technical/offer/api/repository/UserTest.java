package com.technical.offer.api.repository;

import com.technical.offer.api.model.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Date;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void tetCreateAndReadUser() {
        User user = new User()
                .setGender("mr")
                .setName("blablabla")
                .setBirthDay(new Date("25/12/1980"))
                .setCountry("france")
                .setPhone("+33710203040");

        userRepository.save(user);

        Iterable<User> users = userRepository.findAll();
        Assertions.assertThat(users).extracting(User::getName).contains("blablabla");

    }
}
