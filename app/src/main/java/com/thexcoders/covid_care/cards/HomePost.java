package com.thexcoders.covid_care.cards;

import android.graphics.Color;

import org.ocpsoft.prettytime.PrettyTime;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class HomePost {
    private Date date;
    private String title;
    private String body;
    private int likes;
    private int comments;
    private List<Tag> tagList;

    private boolean isUserLiked = false;

    public HomePost(Date date, String title, String body, int likes, int comments, List<Tag> tagList) {
        this.date = date;
        this.title = title;
        this.body = body;
        this.likes = likes;
        this.comments = comments;
        this.tagList = tagList;
    }

    public HomePost(Date date, String title, String body, int likes, int comments, List<Tag> tagList,boolean isLiked) {
        this.date = date;
        this.title = title;
        this.body = body;
        this.likes = likes;
        this.comments = comments;
        this.tagList = tagList;
        isUserLiked = isLiked;
    }

    public boolean isUserLiked() {
        return isUserLiked;
    }

    public void setUserLiked(boolean userLiked) {
        isUserLiked = userLiked;
    }

    public HomePost(Date date, String title, String body) {
        this.date = date;
        this.title = title;
        this.body = body;
        this.tagList = new ArrayList<>();
    }

    public void addTag(Tag tag){
        this.tagList.add(tag);
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

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getComments() {
        return comments;
    }

    public void setComments(int comments) {
        this.comments = comments;
    }

    public List<Tag> getTagList() {
        return tagList;
    }

    public void setTagList(List<Tag> tagList) {
        this.tagList = tagList;
    }

    public String getFormattedDate() {
        PrettyTime p = new PrettyTime();
        return p.format(date);
    }

    public void dislike() {
        this.likes--;
    }
    public void like(){
        this.likes++;
    }

    public static class Tag{
        String content;
        int backgroundColor;

        public String getContent() {
            return content;
        }

        public int getBackground() {
            return backgroundColor;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public void setBackgroundColor(int backgroundColor) {
            this.backgroundColor = backgroundColor;
        }
    }
}
