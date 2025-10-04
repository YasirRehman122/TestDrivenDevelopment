package com.example.learningmockito.service;

import com.example.learningmockito.model.User;

public class UserServiceImpl implements UserService{

    public User createUser(String firstName, String lastName, String password, String repeatPassword){
        return new User(firstName, lastName, password, repeatPassword);
    }
}
