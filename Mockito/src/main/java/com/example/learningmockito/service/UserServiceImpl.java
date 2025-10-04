package com.example.learningmockito.service;

import com.example.learningmockito.exception.UserException;
import com.example.learningmockito.model.User;
import com.example.learningmockito.repository.UserRepository;

import java.util.UUID;

public class UserServiceImpl implements UserService{

    UserRepository userRepository;
    EmailService emailService;

    public UserServiceImpl(UserRepository userRepository, EmailService emailService) {
        this.userRepository = userRepository;
        this.emailService = emailService;
    }

    public User createUser(String firstName, String lastName, String password, String repeatPassword){
        if(firstName == null || firstName.isEmpty()){
            throw new IllegalArgumentException("First name can not be empty");
        }

        User user = new User(UUID.randomUUID().toString(),firstName, lastName, password, repeatPassword);
        boolean isUserCreated;
        try{
            isUserCreated = userRepository.save(user);
        } catch (RuntimeException ex){
            throw new UserException(ex.getMessage());
        }
        try{
            emailService.scheduleEmailConfirmation(user);
        } catch (RuntimeException ex){
            throw new UserException(ex.getMessage());
        }
        if(!isUserCreated) throw new UserException("User not created");
        return user;
    }
}
