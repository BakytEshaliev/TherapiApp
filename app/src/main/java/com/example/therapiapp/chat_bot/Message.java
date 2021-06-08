package com.example.therapiapp.chat_bot;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Message {
    private boolean floatRight = false;
    private String timestamp;
    private String text = "";

    public Message(boolean floatRight, String text) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        this.timestamp = formatter.format(new Date());
        this.floatRight = floatRight;
        this.text = text;
    }

    public boolean isFloatRight() {
        return floatRight;
    }

    public void setFloatRight(boolean floatRight) {
        this.floatRight = floatRight;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
