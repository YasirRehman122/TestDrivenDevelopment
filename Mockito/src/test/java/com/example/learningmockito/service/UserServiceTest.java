package com.example.learningmockito.service;

import com.example.learningmockito.model.User;
import com.example.learningmockito.repository.UserRepository;
import com.example.learningmockito.repository.UserRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

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
        Mockito.when(userRepository.save(Mockito.any(User.class))).thenReturn(true);
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
