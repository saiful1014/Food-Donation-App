package com.example.DONATION_APP.data;

public class bookprofile {
    String  ammount,start,end,identity,comment,phone;

    public bookprofile(String ammount, String start, String end, String identity, String comment, String phone) {
        this.ammount = ammount;
        this.start = start;
        this.end = end;
        this.identity = identity;
        this.comment = comment;
        this.phone = phone;
    }

    public String getAmmount() {
        return ammount;
    }

    public void setAmmount(String ammount) {
        this.ammount = ammount;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
