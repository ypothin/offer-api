package com.technical.offer.api.controller;

import com.technical.offer.api.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.hamcrest.Matchers.aMapWithSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepository  userRepository;

    @Test
    public void testCreateUser() throws Exception {
        final File jsonFile = new File(Paths.get("src", "test","resources", "init", "user.json").toFile().getAbsolutePath());
        final String userCreate = Files.readString(jsonFile.toPath());

        mockMvc.perform(post("/user/create")
                .contentType("application/json")
                .content(userCreate))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$").isMap())
                .andExpect(jsonPath("$", aMapWithSize(6)));
    }

    @Test
    public void testCreateUserNotFrance() throws Exception {
        final File jsonFile = new File(Paths.get("src", "test","resources", "init", "other.json").toFile().getAbsolutePath());
        final String userCreate = Files.readString(jsonFile.toPath());

        mockMvc.perform(post("/user/create")
                        .contentType("application/json")
                        .content(userCreate))
                .andDo(print())
                .andExpect(status().is(400));
    }

    @Test
     public void testFetchAllUsers() throws  Exception {
         mockMvc.perform(get("/user/fetchAll"))
                 .andDo(print())
                 .andExpect(status().isOk())
                 .andExpect(jsonPath("$").isArray())
                 .andExpect(jsonPath("$.[0].id").value(1))
                 .andExpect(jsonPath("$.[0].name").value("Jul"));

     }

}
