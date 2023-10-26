package com.jorge.springboot.web.app1.models;

public class User {
    private String name;
    private String surname;

    public User() {
    }

    public User(String name, String surname) {
        super();
        this.name = name;
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
}
