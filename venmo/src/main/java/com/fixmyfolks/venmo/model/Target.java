package com.fixmyfolks.venmo.model;

public class Target {
    private String phone;
    private String email;
    private String type;
    private Actor user;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Actor getUser() {
        return user;
    }

    public void setUser(Actor user) {
        this.user = user;
    }
}
