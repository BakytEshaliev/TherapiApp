package com.example.therapiapp.model;

import com.example.therapiapp.model.enum_model.WikiType;

import java.util.UUID;

public class WikiModel {
    String name;
    String description;
    String source;
    WikiType type;
    String id;

    public WikiModel(String name, String description, String source, WikiType type){
        this.name = name;
        this.description = description;
        this.source = source;
        this.type = type;
        id = UUID.randomUUID().toString();
    }

    public String getName() {
        return name;
    }

    public WikiType getType() {
        return type;
    }

    public String getSource() {
        return source;
    }

    public String getDescription() {
        return description;
    }
}
