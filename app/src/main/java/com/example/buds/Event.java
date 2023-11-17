package com.example.buds;

public class Event {
    private String title;
    private String description;
    private String location;
    private int date;

    public Event(){

    }

    public Event(String title, String description, String location, int date){
        this.title=title;
        this.description=description;
        this.location=location;
        this.date=date;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getLocation() {
        return location;
    }

    public int getDate() {
        return date;
    }
}
