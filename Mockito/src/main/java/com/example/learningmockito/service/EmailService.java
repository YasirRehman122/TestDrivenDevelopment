package com.example.learningmockito.service;

import com.example.learningmockito.model.User;

public interface EmailService {
    void scheduleEmailConfirmation(User user);
}
