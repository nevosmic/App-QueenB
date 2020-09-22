package com.example.queenb;

import java.io.Serializable;

public class ItemsModel implements Serializable { //what will be shown about every girl on the list view
    private String name;
    private String age;
    private String location;
    private int image_of_quote;
    private String phone_number;
    private String instagram_link;
    private String loved_about_queenb;
    private String recommend_queenb;

    //Constructors


    public ItemsModel(String name, String age, String location, int image_of_quote, String phone_number,
                      String instagram_link, String loved_about_queenb, String recommend_queenb) {
        this.name = name;
        this.age = age;
        this.location = location;
        this.image_of_quote = image_of_quote;
        this.phone_number = phone_number;
        this.instagram_link = instagram_link;
        this.loved_about_queenb = loved_about_queenb;
        this.recommend_queenb = recommend_queenb;
    }

    //Getters and Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLoved() {
        return loved_about_queenb;
    }

    public void setLoved(String loved_about_queenb) {
        this.loved_about_queenb = loved_about_queenb;
    }
    public String getRecommend_queenb() {
        return recommend_queenb;
    }

    public void setRecommend_queenb(String recommend_queenb) {
        this.recommend_queenb = recommend_queenb;
    }

    public String getInstagram() {
        return instagram_link;
    }

    public void setInstagram_link(String instagram_link) {
        this.instagram_link = instagram_link;
    }

    public String getPhoneNumber() {
        return phone_number;
    }

    public void setPhoneNumber(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getImage_of_quote() {
        return image_of_quote;
    }

    public void setImage_of_quote(int image_of_quote) {
        this.image_of_quote = image_of_quote;
    }
}