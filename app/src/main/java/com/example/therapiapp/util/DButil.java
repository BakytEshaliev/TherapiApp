package com.example.therapiapp.util;

import com.example.therapiapp.model.Activity;
import com.example.therapiapp.model.DiaryEntry;
import com.example.therapiapp.model.Language;
import com.example.therapiapp.model.User;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DButil {
    private static DButil instance;

    private List<DiaryEntry> diary;

    private User user;
    private List<Activity> openActivities;
    private List<Activity> closeActivities;

    private DButil() {
        openActivities = new ArrayList<>();
        closeActivities = new ArrayList<>();
        addExampleActivities();
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

    public void addExampleActivities(){
        openActivities.add(new Activity("Activity1"));
        openActivities.add(new Activity("Activity2"));
        openActivities.add(new Activity("Activity3"));
        openActivities.add(new Activity("Activity4"));
        openActivities.add(new Activity("Activity5"));
        openActivities.add(new Activity("Activity6"));
        openActivities.add(new Activity("Activity7"));
        openActivities.add(new Activity("Activity8"));
        openActivities.add(new Activity("Activity9"));
        openActivities.add(new Activity("Activity10"));
        openActivities.add(new Activity("Activity11"));
        openActivities.add(new Activity("Activity12"));
        openActivities.add(new Activity("Activity13"));
        openActivities.add(new Activity("Activity14"));
    }

    public void closeActivity(Activity activity){
        closeActivities.add(activity);
    }

    public List<Activity> getOpenActivities(){
        return openActivities;
    }
    public List<Activity> getCloseActivities() {
        return closeActivities;
    }

    public void addToDiary(DiaryEntry diaryEntry){
        diary.add(diaryEntry);
    }

    public List<DiaryEntry> getDiary() {
        return diary;
    }
}
