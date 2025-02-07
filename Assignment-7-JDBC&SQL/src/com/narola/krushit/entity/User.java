package com.narola.krushit.entity;

public class User {
    private String userEmail;
    private String pass;
    private String userFirstName;
    private String userLastName;
    private String userPhone;

    public User() {
    }

    public User(String userEmail, String pass, String userFirstName, String userLastName, String userPhone) {
        this.userEmail = userEmail;
        this.pass = pass;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userPhone = userPhone;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    @Override
    public String toString() {
        return "User{" +
                ", pass='" + pass + '\'' +
                ", userFirstName='" + userFirstName + '\'' +
                ", userLastName='" + userLastName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userPhone='" + userPhone + '\'' +
                '}';
    }
}
