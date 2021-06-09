package com.example.therapiapp.util;

import com.example.therapiapp.model.DiaryEntry;
import com.example.therapiapp.model.Language;
import com.example.therapiapp.model.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DButil {
    private static DButil instance;

    private List<DiaryEntry> diary;

    private User user;

    private DButil() {
        diary = new ArrayList<>();

        diary.add(new DiaryEntry(new Date(2014,2,1,12,23),"Something 1"));
        diary.add(new DiaryEntry(new Date(2014,2,10,23,41),"Something 2"));
        diary.add(new DiaryEntry(new Date(2014,2,20,10,13),"Something 3"));

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
    public void addToDiary(DiaryEntry diaryEntry){
        diary.add(diaryEntry);
    }

    public List<DiaryEntry> getDiary() {
        return diary;
    }
}
