package com.example.therapiapp.model;

import java.io.Serializable;

public class User implements Serializable {
    private String name;
    private String email;
    private String password;
    private Language language;

    public User() {
    }

    public User(String name, String email, String password, Language language) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.language = language;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Language getLanguage() {
        return language;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", language=" + language +
                '}';
    }
}
