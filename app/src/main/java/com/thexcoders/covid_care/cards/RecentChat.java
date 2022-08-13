package com.thexcoders.covid_care.cards;

import org.ocpsoft.prettytime.PrettyTime;

import java.util.Date;

public class RecentChat {
    private Date date;
    private String title;
    private String content;
    private boolean isSeen;
    private boolean isReceived;
    private int messagesCount = 0;

    public RecentChat(Date date, String title, String content, boolean isSeen, boolean isReceived, int messagesCount) {
        this.date = date;
        this.title = title;
        this.content = content;
        this.isSeen = isSeen;
        this.isReceived = isReceived;
        this.messagesCount = messagesCount;
    }

    public RecentChat(Date date, String title, String content, boolean isSeen, boolean isReceived) {
        this.date = date;
        this.title = title;
        this.content = content;
        this.isSeen = isSeen;
        this.isReceived = isReceived;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isSeen() {
        return isSeen;
    }

    public void setSeen(boolean seen) {
        isSeen = seen;
    }

    public boolean isReceived() {
        return isReceived;
    }

    public void setReceived(boolean received) {
        isReceived = received;
    }

    public int getMessagesCount() {
        return messagesCount;
    }

    public void setMessagesCount(int messagesCount) {
        this.messagesCount = messagesCount;
    }

    public String getFormattedDate() {
        PrettyTime p = new PrettyTime();
        return p.format(date);
    }
}
