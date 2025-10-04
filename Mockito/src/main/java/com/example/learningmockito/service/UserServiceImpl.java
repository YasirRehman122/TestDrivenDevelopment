package com.example.learningmockito.service;

import com.example.learningmockito.exception.UserException;
import com.example.learningmockito.model.User;
import com.example.learningmockito.repository.UserRepository;
import com.example.learningmockito.repository.UserRepositoryImpl;

import java.util.UUID;

public class UserServiceImpl implements UserService{

    UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(String firstName, String lastName, String password, String repeatPassword){
        if(firstName == null || firstName.isEmpty()){
            throw new IllegalArgumentException("First name can not be empty");
        }

        User user = new User(UUID.randomUUID().toString(),firstName, lastName, password, repeatPassword);
        boolean isUserCreated = userRepository.save(user);
        if(!isUserCreated) throw new UserException("User not created");
        return user;
    }
}
