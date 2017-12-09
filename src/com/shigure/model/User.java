package com.shigure.model;

public class User {
    private int id;
    private String userName;
    private String password;
    private String realName;
    private String telPhone;

    public User(String password, int id) {
        this.id = id;
        this.password = password;
    }

    public User(int id) {
        super();
        this.id = id;
    }

    public User(String realName,  String telPhone, String password, int id) {
        super();
        this.id = id;
        this.realName = realName;
        this.telPhone = telPhone;
        this.password = password;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getTelPhone() {
        return telPhone;
    }

    public void setTelPhone(String telPhone) {
        this.telPhone = telPhone;
    }

    public User(String userName, String password, String realName, String telPhone) {
        super();
        this.userName = userName;
        this.password = password;
        this.realName = realName;
        this.telPhone = telPhone;
    }

    public User() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
