package com.example.heralert;

public class Escape {
    String nameEscape;
    String descEscape;
    int imageEscape;

    public Escape(String nameEscape, String emailEscape, int imageEscape) {
        this.nameEscape = nameEscape;
        this.descEscape = emailEscape;
        this.imageEscape = imageEscape;
    }

    public String getNameEscape() {
        return nameEscape;
    }

    public void setNameEscape(String nameEscape) {
        this.nameEscape = nameEscape;
    }

    public String getEmailEscape() {
        return descEscape;
    }

    public void setEmailEscape(String emailEscape) {
        this.descEscape = emailEscape;
    }

    public int getImageEscape() {
        return imageEscape;
    }

    public void setImageEscape(int imageEscape) {
        this.imageEscape = imageEscape;
    }
}
