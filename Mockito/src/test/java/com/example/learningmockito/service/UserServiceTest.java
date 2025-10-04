package com.example.learningmockito.service;

import com.example.learningmockito.model.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest {
    UserService userService = new UserServiceImpl();

    @Test
    void testCreateUser_withValidValue_UserObjectNotNull(){
        String firstName = "John";
        String lastName = "Wick";
        String password = "12345";
        String repeatPassword = "12345";

        User user = userService.createUser(firstName, lastName, password, repeatPassword);

        assertNotNull(user);
    }
}
