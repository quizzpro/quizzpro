package com.quizpro.springboot.entities;

public class LoginResponse {
    private String message;
    private User user;

    // Constructeur
    public LoginResponse(String message, User user) {
        this.message = message;
        this.user = user;
    }

    // Getters et Setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

