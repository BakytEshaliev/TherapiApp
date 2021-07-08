package com.example.therapiapp.util;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.therapiapp.Wiki;
import com.example.therapiapp.model.Activity;
import com.example.therapiapp.model.DiaryEntry;
import com.example.therapiapp.model.Language;
import com.example.therapiapp.model.User;
import com.example.therapiapp.model.WikiModel;
import com.example.therapiapp.model.enum_model.WikiType;

import java.time.LocalDateTime;
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

    @RequiresApi(api = Build.VERSION_CODES.O)
    private DButil() {
        openActivities = new ArrayList<>();
        closeActivities = new ArrayList<>();
        activitiesAgainstStress = new ArrayList<>();
        activitiesAgainstDepression = new ArrayList<>();
        allWiki = new ArrayList<>();
        addExampleActivities();
        addExampleWiki();

        diary = new ArrayList<>();

        diary.add(new DiaryEntry(LocalDateTime.of(2014,2,12,12,24,35),"Something 1"));
        diary.add(new DiaryEntry(LocalDateTime.of(2014,2,10,23,41,33),"Something 2"));
        diary.add(new DiaryEntry(LocalDateTime.of(2014,2,20,10,13,23),"Something 3"));

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

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static DButil getInstance() {
        if (instance == null) instance = new DButil();
        return instance;
    }

    public void addExampleActivities(){
//        openActivities.add(new Activity("Übung 1",""));
//        openActivities.add(new Activity("Übung 2",""));
//        openActivities.add(new Activity("Übung 3",""));
//
//        activitiesAgainstStress.add(new Activity("Übung gegen Stress 1",""));
//        activitiesAgainstStress.add(new Activity("Übung gegen Stress 2",""));
//        activitiesAgainstStress.add(new Activity("Übung gegen Stress 3",""));
//        activitiesAgainstStress.add(new Activity("Übung gegen Stress 4",""));
//        activitiesAgainstStress.add(new Activity("Übung gegen Stress 5",""));
//        activitiesAgainstStress.add(new Activity("Übung gegen Stress 6",""));

        activitiesAgainstDepression.add(new Activity("Eigenlob","Es heißt “Eigenlob stinkt”, jedoch ist das heute nicht der Fall! Eigenlob kann dich motivieren! Deine heutige Aufgabe ist es, in den nächsten Minuten Dinge aufzuzählen, für die du dich selbst lobst. Sei es deine Kreativität, Kochkünste, Geschicklichkeit - irgendetwas, alles geht. Schreibe diese Lobe bitte hier in der App nieder, dadurch kann der Chatbot auf diesen aufbauen und sich mit dir darüber unterhalten!\n"));
        activitiesAgainstDepression.add(new Activity("Die Schulterbrücke","Die Yogaübung Schulterbrücke - Setu Bandha Sarvangasana.\n" +
                "Lege dich auf den Rücken, und stelle deine Füße hüftbreit vor deinem Becken auf. Lege deine Arme seitlich neben deinen Körper. Hebe mit der Einatmung das Becken und den Rücken nach oben, so dass zwischen deinen Knien und Schultern eine schiefe Ebene entsteht. Achte darauf, dass deine Knie nicht nach innen fallen sondern über deinen Fußgelenken positioniert sind. Führe mit der nächsten Einatmung deine Arme über oben nach hinten. Mit der Ausatmung lege langsam den Rücken und das Becken wieder ab und führe die Arme zurück. Wiederhole dies ruhig und entspannt einige Male. \u200BNimm dir Zeit bei der Ausführung, sei in Kontakt mit deiner Atmung und spüre nach, was sich in deinem Körper verändert. \n"));
//        activitiesAgainstDepression.add(new Activity("Übung gegen Depression 3",""));
//        activitiesAgainstDepression.add(new Activity("Übung gegen Depression 4",""));
//        activitiesAgainstDepression.add(new Activity("Übung gegen Depression 5",""));
//        activitiesAgainstDepression.add(new Activity("Übung gegen Depression 6",""));

//
//        dailyActivity = new Activity("Tagesziel","");
    }

    public void addExampleWiki(){
        allWiki.add(new WikiModel("Stress im Alltag",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent porttitor nibh at sapien dictum, at maximus dolor mollis. Donec id cursus lectus. Suspendisse eget felis a ex commodo tempus. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla facilisi. Donec et ex in nulla imperdiet ultricies. Duis aliquet sem ac ligula iaculis, sit amet gravida est dapibus. Aenean mattis, nisi ut gravida suscipit, sapien odio scelerisque leo, vel finibus quam orci quis dui. Integer at arcu vel diam tristique scelerisque.\n" +
                        "\n" +
                        "Sed dolor leo, mollis accumsan consequat non, laoreet non quam. Fusce convallis eros ut ligula rhoncus porta. Sed vehicula auctor leo, ac vestibulum sapien facilisis sed. Cras sit amet efficitur metus, sed lobortis nibh. Mauris et tristique quam. Aenean convallis, libero quis interdum varius, lectus metus dictum elit, convallis molestie nibh orci eu orci. Suspendisse ornare euismod dolor eget porttitor. Mauris quis eros a quam iaculis posuere. Etiam sit amet lorem quis augue ornare interdum id eu libero. Aliquam sodales mauris a eros hendrerit bibendum. Cras interdum ultrices ante, non porttitor urna porta fermentum. Vivamus sodales neque a placerat fermentum.",
                "https://www.google.com/", WikiType.MAIN));
        allWiki.add(new WikiModel("Allgemeine Definition", "Stress ist eine natürliche körperliche Reaktion auf psychische oder körperliche Belastungen. Sie dient dazu, in angenommenen oder realen Gefahrensituationen kurzfristig die Leistungsbereitschaft zu erhöhen", "https://www.netdoktor.at/krankheit/was-ist-stress-5266", WikiType.SUB));
        allWiki.add(new WikiModel("Ursachen von Stress", "Als Gründe für den Stress werden krankmachende Anforderungen oder Belastungen genannt. Diese Stressfaktoren können unterschiedlichster Art sein, zum Beispiel Gewalt, Schmerz, Verletzung, Zeitdruck, Lärm, Angst, Mobbing, Monotonie, Einsamkeit, Leistungsanforderungen etc. Aber auch sozioökonomische Faktoren, zum Beispiel Arbeitslosigkeit oder ein ungenügendes Einkommen, können Stress verursachen. Kritische Lebensereignisse (z.B. Verlust eines nahestehenden Menschen) können die Entwicklung von Stresserkrankungen beeinflussen.\n", "https://www.mediservice.ch/de/stress.html", WikiType.SUB));
        allWiki.add(new WikiModel("Merkmale von Stress", "Die Symptome von Stress sind vielfältig und betreffen den gesamten Organismus. Die Stress-Reaktion läuft nach dem folgenden Muster ab.\n" +
                "In der Vorphase fährt der Körper alle Stoffwechselvorgänge schlagartig runter, um den Körper auf die bevorstehende Aktivierung vorzubereiten. Die Vorphase bemerken wir mitunter als Schrecksekunde – mit entsprechender Handlungsunfähigkeit.\n" +
                "In der Alarmphase schaltet der Körper mithilfe der Stresshormone (unter anderem Adrenalin und Noradrenalin) um und mobilisiert alle Energie. Der Herzschlag beschleunigt sich, die Muskeln werden aktiviert, der Blutdruck steigt – der „Motor“ läuft auf Hochtouren.\n" +
                "In der Handlungsphase werden wir unter Stress aktiv. In der Frühzeit flüchteten wir vor dem sprichwörtlichen Säbelzahntiger auf einen Baum. Heutzutage kann schon das Einfädeln eines Autos in den fließenden Straßenverkehr mit einer Stress-Reaktion einhergehen. Das Stresserleben hängt in diesem Fall davon ab, wie sicher sich der Fahrer im dichten Stadtverkehr fühlt.\n" +
                "Die Erholungsphase der Stress-Reaktion ist durch Erschöpfung und folgende Erholung gekennzeichnet. Der Körper normalisiert den Hormonspiegel und füllt beispielsweise die Energiereservoire der Muskeln wieder auf.\n", "https://www.mylife.de/entspannung/stress/distress-und-eustress/", WikiType.SUB));
        allWiki.add(new WikiModel("Behandlungsmöglichkeiten", "Behandeln kann man Stress nur, indem man diesen reduziert und, so weit es eben möglich ist, umgeht. Außerdem sollte man die Ursachen erkennen, die zum Stress geführt haben, um dieses Übel an der Wurzel zu bekämpfen.\n" +
                "\n" +
                "Neben dem ist gegen Stress besonders wirksam die Entspannung. Doch oft fällt es schwer im Arbeitsalltag abschalten zu können. Die Gedanken kreisen und das Stresslevel nimmt zu. Besonders bewährt hat sich dazu Autogenes Training. Meditation und Sportarten wie Pilates und Yoga können helfen, mit sich selbst ins Reine zu kommen.\n", "https://medlexi.de/Stress#Behandlung_.26_Therapie", WikiType.SUB));
        allWiki.add(new WikiModel("Was ist eine Depression?", "", "", WikiType.MAIN));
        allWiki.add(new WikiModel("Allgemeine Definition", "Depression ist eine psychische Krankheit, welche allerdings häufig heruntergespielt/nicht als Krankheit akzeptiert und als miese Laune interpretiert wird, was hauptsächlich von normaler Bevölkerung ausgeht. ", "https://www.deutsche-depressionshilfe.de/depression-infos-und-hilfe/was-ist-eine-depression", WikiType.SUB));
        allWiki.add(new WikiModel("Ursachen einer Depression", "Depressionen treten häufig nach einschneidenden Ereignissen auf.\n", "https://www.deutsche-depressionshilfe.de/depression-infos-und-hilfe/ursachen-und-ausloeser", WikiType.SUB));
        allWiki.add(new WikiModel("Merkmale einer Depression", "Depression kann sich durch langanhaltende regelmäßige gedrückte Stimmung, häufiges Grübeln, Antriebslosigkeit und Suizidgedanken auszeichnen. Außerdem äußern sie sich ebenfalls in Form von depressiven Episoden, also Zeiträume mit Symptomen einer Depression. \n", "https://www.landwirt.com/Merkmale-einer-Depression,,9716,,Bericht.html", WikiType.SUB));
        allWiki.add(new WikiModel("Behandlungsmöglichkeiten", "Depressionen erfordern fachspezifische Hilfe in Form einer Psychotherapie. Bei sehr stark ausgeprägten Depressionen werden außerdem Medikamente, bezeichnet als Antidepressiva, verschrieben. Bei schweren Depressionen ist meist eine Kombination aus Psychotherapie und Antidepressiva sinnvoll. Die Therapie findet in den meisten Fällen ambulant statt. Bei schweren Depressionen, weiteren psychischen Erkrankungen oder einem erhöhten Suizidrisiko sollte die Therapie jedoch stationär durchgeführt werden.\n", "https://www.gesundheitsinformation.de/behandlungsmoeglichkeiten-bei-einer-depression.html", WikiType.SUB));
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
        if (dailyActivity == null)
            dailyActivity = activity;
        else
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

    public Activity findOpenActivityById(String id) {
        if (dailyActivity != null) {
            if (dailyActivity.getId().equals(id))
                return dailyActivity;
        }
        for (Activity a : openActivities){
            if (a.getId().equals(id))
                return a;
        }
        return null;
    }

    public void removeOpenActivity(Activity activity){
        if (dailyActivity.equals(activity))
            dailyActivity = null;
        openActivities.remove(activity);
    }

    public Activity findActivityById(String id) {
        if (dailyActivity != null) {
            if (dailyActivity.getId().equals(id))
                return dailyActivity;
        }
        for (Activity a : openActivities){
            if (a.getId().equals(id))
                return a;
        }
        for (Activity a : closeActivities){
            if (a.getId().equals(id))
                return a;
        }
        for (Activity a : activitiesAgainstDepression){
            if (a.getId().equals(id))
                return a;
        }
        for (Activity a : activitiesAgainstStress){
            if (a.getId().equals(id))
                return a;
        }
        return null;
    }
}
