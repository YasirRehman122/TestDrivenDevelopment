package com.example.learningmockito.service;

import com.example.learningmockito.model.User;

public class UserServiceImpl implements UserService{

    public User createUser(String firstName, String lastName, String password, String repeatPassword){
        if(firstName == null || firstName.isEmpty()){
            throw new IllegalArgumentException("First name can not be empty");
        }
        return new User(firstName, lastName, password, repeatPassword);
    }
}
