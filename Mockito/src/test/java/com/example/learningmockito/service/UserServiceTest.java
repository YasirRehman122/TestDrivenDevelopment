package com.example.learningmockito.service;

import com.example.learningmockito.model.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest {
    UserService userService = new UserServiceImpl();

    String firstName = "John";
    String lastName = "Wick";
    String password = "12345";
    String repeatPassword = "12345";

    @BeforeEach
    void beforeAll(){
        firstName = "John";
        lastName = "Wick";
        password = "12345";
        repeatPassword = "12345";
    }

    @Test
    void testCreateUser_withValidValue_UserObjectNotNull(){
        User user = userService.createUser(firstName, lastName, password, repeatPassword);

        assertNotNull(user);
    }

    @Test
    void testCreateUser_WhenFirstNameIsEmpty_IllegalArgumentExceptionThrown(){
        String firstName = "";
        String exceptionExpectedMessage= "First name can not be empty";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            userService.createUser(firstName, lastName, password, repeatPassword);
        }, "Empty first name should throw illegal argument exception");

        assertEquals(exceptionExpectedMessage, exception.getMessage(),"Exception message incorrect");

    }
}
