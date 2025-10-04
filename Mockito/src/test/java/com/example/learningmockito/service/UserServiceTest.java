package com.example.learningmockito.service;

import com.example.learningmockito.exception.UserException;
import com.example.learningmockito.model.User;
import com.example.learningmockito.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @InjectMocks
    UserServiceImpl userService;

    @Mock
    UserRepository userRepository;
    String firstName = "John";
    String lastName = "Wick";
    String password = "12345";
    String repeatPassword = "12345";

    @BeforeEach
    void init(){
        firstName = "John";
        lastName = "Wick";
        password = "12345";
        repeatPassword = "12345";
    }

    @Test
    void testCreateUser_withValidValue_UserObjectNotNull(){
        when(userRepository.save(any(User.class))).thenReturn(true);
        User user = userService.createUser(firstName, lastName, password, repeatPassword);
        verify(userRepository, atMostOnce())
                        .save(any(User.class));
        assertNotNull(user);
    }

    @Test
    @DisplayName("If save() throws Runtime exception then throw UserException")
    void testCreateUser_whenRuntimeExceptionOccurs_ThrowUserException(){
        when(userRepository.save(any(User.class))).thenThrow(RuntimeException.class);

        assertThrows(UserException.class,
                () -> userService.createUser(firstName,lastName,password,repeatPassword),
                "User exception should have been thrown");
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
