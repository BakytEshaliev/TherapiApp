package com.example.therapiapp.util;

import com.example.therapiapp.Wiki;
import com.example.therapiapp.model.Activity;
import com.example.therapiapp.model.DiaryEntry;
import com.example.therapiapp.model.Language;
import com.example.therapiapp.model.User;
import com.example.therapiapp.model.WikiModel;
import com.example.therapiapp.model.enum_model.WikiType;

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
    private List<Activity> activitiesAgainstStress;
    private List<Activity> activitiesAgainstDepression;
    private List<WikiModel> allWiki;
    private Activity dailyActivity;

    private DButil() {
        openActivities = new ArrayList<>();
        closeActivities = new ArrayList<>();
        activitiesAgainstStress = new ArrayList<>();
        activitiesAgainstDepression = new ArrayList<>();
        allWiki = new ArrayList<>();
        addExampleActivities();
        addExampleWiki();

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
        openActivities.add(new Activity("Übung 1"));
        openActivities.add(new Activity("Übung 2"));
        openActivities.add(new Activity("Übung 3"));

        activitiesAgainstStress.add(new Activity("Übung gegen Stress 1"));
        activitiesAgainstStress.add(new Activity("Übung gegen Stress 2"));
        activitiesAgainstStress.add(new Activity("Übung gegen Stress 3"));
        activitiesAgainstStress.add(new Activity("Übung gegen Stress 4"));
        activitiesAgainstStress.add(new Activity("Übung gegen Stress 5"));
        activitiesAgainstStress.add(new Activity("Übung gegen Stress 6"));

        activitiesAgainstDepression.add(new Activity("Übung gegen Depression 1"));
        activitiesAgainstDepression.add(new Activity("Übung gegen Depression 2"));
        activitiesAgainstDepression.add(new Activity("Übung gegen Depression 3"));
        activitiesAgainstDepression.add(new Activity("Übung gegen Depression 4"));
        activitiesAgainstDepression.add(new Activity("Übung gegen Depression 5"));
        activitiesAgainstDepression.add(new Activity("Übung gegen Depression 6"));


        dailyActivity = new Activity("Tagesziel");
    }

    public void addExampleWiki(){
        allWiki.add(new WikiModel("Stress",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent porttitor nibh at sapien dictum, at maximus dolor mollis. Donec id cursus lectus. Suspendisse eget felis a ex commodo tempus. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla facilisi. Donec et ex in nulla imperdiet ultricies. Duis aliquet sem ac ligula iaculis, sit amet gravida est dapibus. Aenean mattis, nisi ut gravida suscipit, sapien odio scelerisque leo, vel finibus quam orci quis dui. Integer at arcu vel diam tristique scelerisque.\n" +
                        "\n" +
                        "Sed dolor leo, mollis accumsan consequat non, laoreet non quam. Fusce convallis eros ut ligula rhoncus porta. Sed vehicula auctor leo, ac vestibulum sapien facilisis sed. Cras sit amet efficitur metus, sed lobortis nibh. Mauris et tristique quam. Aenean convallis, libero quis interdum varius, lectus metus dictum elit, convallis molestie nibh orci eu orci. Suspendisse ornare euismod dolor eget porttitor. Mauris quis eros a quam iaculis posuere. Etiam sit amet lorem quis augue ornare interdum id eu libero. Aliquam sodales mauris a eros hendrerit bibendum. Cras interdum ultrices ante, non porttitor urna porta fermentum. Vivamus sodales neque a placerat fermentum.",
                "google.com", WikiType.MAIN));
        allWiki.add(new WikiModel("Stress SUB 1", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent porttitor nibh at sapien dictum, at maximus dolor mollis. Donec id cursus lectus. Suspendisse eget felis a ex commodo tempus. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla facilisi. Donec et ex in nulla imperdiet ultricies. Duis aliquet sem ac ligula iaculis, sit amet gravida est dapibus. Aenean mattis, nisi ut gravida suscipit, sapien odio scelerisque leo, vel finibus quam orci quis dui. Integer at arcu vel diam tristique scelerisque.\n" +
                "\n" +
                "Sed dolor leo, mollis accumsan consequat non, laoreet non quam. Fusce convallis eros ut ligula rhoncus porta. Sed vehicula auctor leo, ac vestibulum sapien facilisis sed. Cras sit amet efficitur metus, sed lobortis nibh. Mauris et tristique quam. Aenean convallis, libero quis interdum varius, lectus metus dictum elit, convallis molestie nibh orci eu orci. Suspendisse ornare euismod dolor eget porttitor. Mauris quis eros a quam iaculis posuere. Etiam sit amet lorem quis augue ornare interdum id eu libero. Aliquam sodales mauris a eros hendrerit bibendum. Cras interdum ultrices ante, non porttitor urna porta fermentum. Vivamus sodales neque a placerat fermentum.", "google.com", WikiType.SUB));
        allWiki.add(new WikiModel("Stress SUB 2", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent porttitor nibh at sapien dictum, at maximus dolor mollis. Donec id cursus lectus. Suspendisse eget felis a ex commodo tempus. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla facilisi. Donec et ex in nulla imperdiet ultricies. Duis aliquet sem ac ligula iaculis, sit amet gravida est dapibus. Aenean mattis, nisi ut gravida suscipit, sapien odio scelerisque leo, vel finibus quam orci quis dui. Integer at arcu vel diam tristique scelerisque.\n" +
                "\n" +
                "Sed dolor leo, mollis accumsan consequat non, laoreet non quam. Fusce convallis eros ut ligula rhoncus porta. Sed vehicula auctor leo, ac vestibulum sapien facilisis sed. Cras sit amet efficitur metus, sed lobortis nibh. Mauris et tristique quam. Aenean convallis, libero quis interdum varius, lectus metus dictum elit, convallis molestie nibh orci eu orci. Suspendisse ornare euismod dolor eget porttitor. Mauris quis eros a quam iaculis posuere. Etiam sit amet lorem quis augue ornare interdum id eu libero. Aliquam sodales mauris a eros hendrerit bibendum. Cras interdum ultrices ante, non porttitor urna porta fermentum. Vivamus sodales neque a placerat fermentum.", "google.com", WikiType.SUB));
        allWiki.add(new WikiModel("Stress SUB 3", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent porttitor nibh at sapien dictum, at maximus dolor mollis. Donec id cursus lectus. Suspendisse eget felis a ex commodo tempus. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla facilisi. Donec et ex in nulla imperdiet ultricies. Duis aliquet sem ac ligula iaculis, sit amet gravida est dapibus. Aenean mattis, nisi ut gravida suscipit, sapien odio scelerisque leo, vel finibus quam orci quis dui. Integer at arcu vel diam tristique scelerisque.\n" +
                "\n" +
                "Sed dolor leo, mollis accumsan consequat non, laoreet non quam. Fusce convallis eros ut ligula rhoncus porta. Sed vehicula auctor leo, ac vestibulum sapien facilisis sed. Cras sit amet efficitur metus, sed lobortis nibh. Mauris et tristique quam. Aenean convallis, libero quis interdum varius, lectus metus dictum elit, convallis molestie nibh orci eu orci. Suspendisse ornare euismod dolor eget porttitor. Mauris quis eros a quam iaculis posuere. Etiam sit amet lorem quis augue ornare interdum id eu libero. Aliquam sodales mauris a eros hendrerit bibendum. Cras interdum ultrices ante, non porttitor urna porta fermentum. Vivamus sodales neque a placerat fermentum.", "google.com", WikiType.SUB));
        allWiki.add(new WikiModel("Depression", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent porttitor nibh at sapien dictum, at maximus dolor mollis. Donec id cursus lectus. Suspendisse eget felis a ex commodo tempus. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla facilisi. Donec et ex in nulla imperdiet ultricies. Duis aliquet sem ac ligula iaculis, sit amet gravida est dapibus. Aenean mattis, nisi ut gravida suscipit, sapien odio scelerisque leo, vel finibus quam orci quis dui. Integer at arcu vel diam tristique scelerisque.\n" +
                "\n" +
                "Sed dolor leo, mollis accumsan consequat non, laoreet non quam. Fusce convallis eros ut ligula rhoncus porta. Sed vehicula auctor leo, ac vestibulum sapien facilisis sed. Cras sit amet efficitur metus, sed lobortis nibh. Mauris et tristique quam. Aenean convallis, libero quis interdum varius, lectus metus dictum elit, convallis molestie nibh orci eu orci. Suspendisse ornare euismod dolor eget porttitor. Mauris quis eros a quam iaculis posuere. Etiam sit amet lorem quis augue ornare interdum id eu libero. Aliquam sodales mauris a eros hendrerit bibendum. Cras interdum ultrices ante, non porttitor urna porta fermentum. Vivamus sodales neque a placerat fermentum.", "google.com", WikiType.MAIN));
        allWiki.add(new WikiModel("Depression SUB 1", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent porttitor nibh at sapien dictum, at maximus dolor mollis. Donec id cursus lectus. Suspendisse eget felis a ex commodo tempus. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla facilisi. Donec et ex in nulla imperdiet ultricies. Duis aliquet sem ac ligula iaculis, sit amet gravida est dapibus. Aenean mattis, nisi ut gravida suscipit, sapien odio scelerisque leo, vel finibus quam orci quis dui. Integer at arcu vel diam tristique scelerisque.\n" +
                "\n" +
                "Sed dolor leo, mollis accumsan consequat non, laoreet non quam. Fusce convallis eros ut ligula rhoncus porta. Sed vehicula auctor leo, ac vestibulum sapien facilisis sed. Cras sit amet efficitur metus, sed lobortis nibh. Mauris et tristique quam. Aenean convallis, libero quis interdum varius, lectus metus dictum elit, convallis molestie nibh orci eu orci. Suspendisse ornare euismod dolor eget porttitor. Mauris quis eros a quam iaculis posuere. Etiam sit amet lorem quis augue ornare interdum id eu libero. Aliquam sodales mauris a eros hendrerit bibendum. Cras interdum ultrices ante, non porttitor urna porta fermentum. Vivamus sodales neque a placerat fermentum.", "google.com", WikiType.SUB));
        allWiki.add(new WikiModel("Depression SUB 2", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent porttitor nibh at sapien dictum, at maximus dolor mollis. Donec id cursus lectus. Suspendisse eget felis a ex commodo tempus. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla facilisi. Donec et ex in nulla imperdiet ultricies. Duis aliquet sem ac ligula iaculis, sit amet gravida est dapibus. Aenean mattis, nisi ut gravida suscipit, sapien odio scelerisque leo, vel finibus quam orci quis dui. Integer at arcu vel diam tristique scelerisque.\n" +
                "\n" +
                "Sed dolor leo, mollis accumsan consequat non, laoreet non quam. Fusce convallis eros ut ligula rhoncus porta. Sed vehicula auctor leo, ac vestibulum sapien facilisis sed. Cras sit amet efficitur metus, sed lobortis nibh. Mauris et tristique quam. Aenean convallis, libero quis interdum varius, lectus metus dictum elit, convallis molestie nibh orci eu orci. Suspendisse ornare euismod dolor eget porttitor. Mauris quis eros a quam iaculis posuere. Etiam sit amet lorem quis augue ornare interdum id eu libero. Aliquam sodales mauris a eros hendrerit bibendum. Cras interdum ultrices ante, non porttitor urna porta fermentum. Vivamus sodales neque a placerat fermentum.", "google.com", WikiType.SUB));
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

    public Activity getDailyActivity() {
        return dailyActivity;
    }

    public void deleteDailyActivity() {
        dailyActivity = null;
    }

    public void openActivity(Activity activity) {
        openActivities.add(activity);
    }

    public List<Activity> getActivitiesAgainstStress() {
        return activitiesAgainstStress;
    }

    public void setDailyActivity(Activity activity){
        dailyActivity = activity;
    }

    public List<Activity> getActivitiesAgainstDepression() {
        return activitiesAgainstDepression;
    }

    public List<WikiModel> getAllWiki() {
        return allWiki;
    }
}
