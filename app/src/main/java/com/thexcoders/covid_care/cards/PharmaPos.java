package com.thexcoders.covid_care.cards;

public class PharmaPos {
    private String name;
    private String distance;
    private String location;
    private String starsAvg;
    private String starsCount;
    private String saturday;
    private String sunday;
    private int color;

    public PharmaPos(String name, String distance, String location, String starsAvg, String starsCount, String saturday, String sunday) {
        this.name = name;
        this.distance = distance;
        this.location = location;
        this.starsAvg = starsAvg;
        this.starsCount = starsCount;
        this.saturday = saturday;
        this.sunday = sunday;
    }

    public PharmaPos(String name, String distance, String location, String starsAvg, String starsCount, String saturday, String sunday, int color) {
        this.name = name;
        this.distance = distance;
        this.location = location;
        this.starsAvg = starsAvg;
        this.starsCount = starsCount;
        this.saturday = saturday;
        this.sunday = sunday;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStarsAvg() {
        return starsAvg;
    }

    public void setStarsAvg(String starsAvg) {
        this.starsAvg = starsAvg;
    }

    public String getStarsCount() {
        return starsCount;
    }

    public void setStarsCount(String starsCount) {
        this.starsCount = starsCount;
    }

    public String getSaturday() {
        return saturday;
    }

    public void setSaturday(String saturday) {
        this.saturday = saturday;
    }

    public String getSunday() {
        return sunday;
    }

    public void setSunday(String sunday) {
        this.sunday = sunday;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
