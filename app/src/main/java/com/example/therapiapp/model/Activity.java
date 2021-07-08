package com.example.therapiapp.model;

import com.example.therapiapp.model.enum_model.ActivityStatus;

import java.util.UUID;


public class Activity {
    private String name;
    private String id;
    private String description;
    private String content;

    public Activity(String name, String description){
        this.name = name;
        id = UUID.randomUUID().toString();
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
