package com.example.heralert;

public class Escape {
    String nameEscape;
    String emailEscape;
    int imageEscape;

    public Escape(String nameEscape, String emailEscape, int imageEscape) {
        this.nameEscape = nameEscape;
        this.emailEscape = emailEscape;
        this.imageEscape = imageEscape;
    }

    public String getNameEscape() {
        return nameEscape;
    }

    public void setNameEscape(String nameEscape) {
        this.nameEscape = nameEscape;
    }

    public String getEmailEscape() {
        return emailEscape;
    }

    public void setEmailEscape(String emailEscape) {
        this.emailEscape = emailEscape;
    }

    public int getImageEscape() {
        return imageEscape;
    }

    public void setImageEscape(int imageEscape) {
        this.imageEscape = imageEscape;
    }
}
