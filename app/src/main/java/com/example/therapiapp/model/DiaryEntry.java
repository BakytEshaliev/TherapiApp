package com.example.therapiapp.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class DiaryEntry implements Serializable {
    private Date date;
    private String content;

    public DiaryEntry() {
    }

    public DiaryEntry(Date date, String content) {
        this.date = date;
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DiaryEntry that = (DiaryEntry) o;
        return Objects.equals(date, that.date) &&
                Objects.equals(content, that.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, content);
    }
}
