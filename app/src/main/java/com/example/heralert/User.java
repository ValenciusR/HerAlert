package com.example.heralert;

import java.util.ArrayList;

public class User {
    private String name,email, password, phoneNumber, helpMessage, safeMessage;
    private boolean sound;
    private ArrayList<EmergencyContact> contacts;

    public User(String name, String email, String password, String phoneNumber, ArrayList<EmergencyContact> contacts) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.contacts = contacts;
        this.helpMessage = "I need your help! My location is..";
        this.safeMessage = "I am safe now! Thank you..";
        this.sound = true;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public ArrayList<EmergencyContact> getContacts() {
        return contacts;
    }

    public void setContacts(ArrayList<EmergencyContact> contacts) {
        this.contacts = contacts;
    }

    public String getHelpMessage() {
        return helpMessage;
    }

    public String getSafeMessage() {
        return safeMessage;
    }

    public boolean isSound() {
        return sound;
    }

    public void setHelpMessage(String helpMessage) {
        this.helpMessage = helpMessage;
    }

    public void setSafeMessage(String safeMessage) {
        this.safeMessage = safeMessage;
    }

    public void setSound(boolean sound) {
        this.sound = sound;
    }
}
