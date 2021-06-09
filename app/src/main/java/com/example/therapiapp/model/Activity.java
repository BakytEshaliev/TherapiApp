package com.example.therapiapp.model;

import com.example.therapiapp.model.enum_model.ActivityStatus;

import java.util.UUID;


public class Activity {
    String name;
    String id;

    public Activity(String name){
        this.name = name;
        id = UUID.randomUUID().toString();
    }

    public String getName() {
        return name;
    }
}
