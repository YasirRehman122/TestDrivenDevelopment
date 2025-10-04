package com.example.learningmockito.model;

public class User {
    String firstName;
    String lastName;
    String password;
    String repeatPassword;

    public User(String firstName, String lastName, String password, String repeatPassword) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.repeatPassword = repeatPassword;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }
}
