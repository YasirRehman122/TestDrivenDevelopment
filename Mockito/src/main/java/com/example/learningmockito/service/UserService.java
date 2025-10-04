package com.example.learningmockito.service;

import com.example.learningmockito.model.User;

public interface UserService {

    User createUser(String firstName, String lastName, String password, String repeatPassword);
}
