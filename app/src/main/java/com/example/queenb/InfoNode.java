package com.example.queenb;

public class InfoNode {
    int idName;
    String city;
    String place;

    public InfoNode(int idName, String city, String place) {
        this.idName = idName;
        this.city = city;
        this.place = place;
    }

    public int getIdName() {
        return idName;
    }

    public void setIdName(int idName) {
        this.idName = idName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
}

