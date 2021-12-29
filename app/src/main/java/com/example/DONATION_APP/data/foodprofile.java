package com.example.DONATION_APP.data;

public class foodprofile {
    String date,Firsttime,Lasttime,Identity,comment;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFirsttime() {
        return Firsttime;
    }

    public void setFirsttime(String firsttime) {
        Firsttime = firsttime;
    }

    public String getLasttime() {
        return Lasttime;
    }

    public void setLasttime(String lasttime) {
        Lasttime = lasttime;
    }

    public String getIdentity() {
        return Identity;
    }

    public void setIdentity(String identity) {
        Identity = identity;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public foodprofile(String date, String firsttime, String lasttime, String identity, String comment) {
        this.date = date;
        Firsttime = firsttime;
        Lasttime = lasttime;
        Identity = identity;
        this.comment = comment;
    }
}
