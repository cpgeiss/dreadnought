package com.fixmyfolks.venmo.model;

import java.util.Date;

public class Actor {
    private String username;
    private String first_name;
    private String last_name;
    private String email;
    private String phone;
    private String display_name;
    private String about;
    private String profile_picture_url;
    private String id;
    private Date date_joined;

    public String getProfilePictureUrl() {
        return profile_picture_url;
    }

    public void setProfilePictureUrl(String profile_picture_url) {
        this.profile_picture_url = profile_picture_url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getDateJoined() {
        return date_joined;
    }

    public void setDateJoined(Date date_joined) {
        this.date_joined = date_joined;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return first_name;
    }

    public void setFirstName(String first_name) {
        this.first_name = first_name;
    }

    public String getLastName() {
        return last_name;
    }

    public void setLastName(String last_name) {
        this.last_name = last_name;
    }

    public String getDisplayName() {
        return display_name;
    }

    public void setDisplayName(String display_name) {
        this.display_name = display_name;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }
}
