package com.example.therapiapp.util;

import com.example.therapiapp.model.Language;
import com.example.therapiapp.model.User;

public class DButil {
    private static DButil instance;

    private User user;

    private DButil() {
    }

    public User getDefaultUser(){
        if (user == null){
            user = new User("Max Mustermann","test@gmail.com","qwe123", Language.Deutsch);
        }
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public static DButil getInstance() {
        if (instance == null) instance = new DButil();
        return instance;
    }
}
