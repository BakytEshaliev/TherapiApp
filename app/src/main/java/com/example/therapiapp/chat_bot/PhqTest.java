package com.example.therapiapp.chat_bot;

public class PhqTest {

    private String[] questions;
    private String[] answers;
    private int i;

    public PhqTest() {
        questions = new String[] {
                "Hast du wenig Interesse oder Freude an deinen Tätigkeiten?",
                "Fühlst du öfter Niedergeschlagenheit, Schwermut oder Hoffnungslosigkeit?",
                "Hast du Schwierigkeiten ein- oder durchzuschlafen oder schläfst du vermehrt?",
                "Verspürst du Müdigkeit oder das Gefühl, keine Energie zu haben?",
                "Verspürst du verminderten Appetit oder ein übermäßiges Bedürfnis zu essen?",
                "Hast du eine schlechte Meinung von dir selbst; das Gefühl, ein Versager zu sein oder die Familie enttäuscht zu haben?",
                "Hast du Schwierigkeiten, dich auf etwas zu konzentrieren, z.B. beim Zeitunglesen oder Fernsehen?",
                "Waren deine Bewegungen oder deine Sprache so verlangsamt, dass es auch anderen auffallen würde? Oder warst du im Gegenteil „zappelig“ oder ruhelos und hattest dadurch einen stärkeren Bewegungsdrang als sonst?",
                "Hast du Gedanken, dass du lieber tot wärst oder dir Leid zufügen möchtest?",
        };
        answers = new String[9];
        i = 0;
    }

    public String getAnswerFor(String question) {
        if (i == 8) {
            answers[i] = question;
            return "exit";
        }
        else {
            if (question.equals("PHQ-9")) {
                return questions[i];
            } else {
                answers[i] = question;
                i++;
                return questions[i];
            }
        }
    }

    public String getResult() {
        String a = "überhaupt nicht";
        String b = "an einzelnen Tagen";
        String c = "an mehr als der Hälfte der Tage";
        String d = "beinahe jeden Tag";
        int result = 0;
        for (int i = 0; i < 9; i++) {
            if (answers[i].equals(a)) result += 0;
            else if (answers[i].equals(b)) result += 1;
            else if (answers[i].equals(c)) result += 2;
            else if (answers[i].equals(d)) result += 3;
        }
        if (result >= 0 && result <= 4) return "Du hast keine Depression (" + result + "/27)";
        else if (result >= 5 && result <= 9) return "Dein Depressionslevel: Mild (" + result + "/27)";
        else if (result >= 10 && result <= 14) return "Dein Depressionslevel: Moderate (" + result + "/27)";
        else if (result >= 15 && result <= 19) return "Dein Depressionslevel: Moderately Severe (" + result + "/27)";
        else return "Dein Depressionslevel: Severe (" + result + "/27)";
    }
}
