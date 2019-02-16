package com.wed.wedding;

public class Guest {
    private int id;
    private String email;

    public Guest(int id, String email) {
        this.id = id;
        this.email = email;
    }

    public Guest(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
