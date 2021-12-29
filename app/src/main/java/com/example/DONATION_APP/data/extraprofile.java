package com.example.DONATION_APP.data;

public class extraprofile {
    String  title,start,end,identity,description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public extraprofile(String title, String start, String end, String identity, String description) {
        this.title = title;
        this.start = start;
        this.end = end;
        this.identity = identity;
        this.description = description;
    }
}
