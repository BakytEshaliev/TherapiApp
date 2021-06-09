package com.example.therapiapp.chat_bot;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Message {
    private boolean floatRight = false;
    private String text = "";

    public Message(boolean floatRight, String text) {
        this.floatRight = floatRight;
        this.text = text;
    }

    public boolean isFloatRight() {
        return floatRight;
    }

    public void setFloatRight(boolean floatRight) {
        this.floatRight = floatRight;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
