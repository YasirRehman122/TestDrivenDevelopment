package com.example.learningmockito.repository;

import com.example.learningmockito.model.User;

public interface UserRepository {
    boolean save(User user);
}
