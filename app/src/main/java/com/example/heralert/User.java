package com.example.heralert;

import java.util.ArrayList;

public class User {
    private String name,email, password;
    private ArrayList<String> phoneNumbers;

    public User(String name, String email, String password, ArrayList<String> phoneNumbers) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phoneNumbers = phoneNumbers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(ArrayList<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }
}
