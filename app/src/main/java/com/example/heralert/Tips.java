package com.example.heralert;

public class Tips {
    String nameTips;
    String descTips;
    int imageTips;

    public Tips(String nameTips, String emailTips, int imageTips) {
        this.nameTips = nameTips;
        this.descTips = emailTips;
        this.imageTips = imageTips;
    }

    public String getNameTips() {
        return nameTips;
    }

    public void setNameTips(String nameTips) {
        this.nameTips = nameTips;
    }

    public String getEmailTips() {
        return descTips;
    }

    public void setEmailTips(String emailTips) {
        this.descTips = emailTips;
    }

    public int getImageTips() {
        return imageTips;
    }

    public void setImageTips(int imageTips) {
        this.imageTips = imageTips;
    }
}
