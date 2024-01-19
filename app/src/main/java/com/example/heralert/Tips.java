package com.example.heralert;

public class Tips {
    String nameTips;
    String emailTips;
    int imageTips;

    public Tips(String nameTips, String emailTips, int imageTips) {
        this.nameTips = nameTips;
        this.emailTips = emailTips;
        this.imageTips = imageTips;
    }

    public String getNameTips() {
        return nameTips;
    }

    public void setNameTips(String nameTips) {
        this.nameTips = nameTips;
    }

    public String getEmailTips() {
        return emailTips;
    }

    public void setEmailTips(String emailTips) {
        this.emailTips = emailTips;
    }

    public int getImageTips() {
        return imageTips;
    }

    public void setImageTips(int imageTips) {
        this.imageTips = imageTips;
    }
}
