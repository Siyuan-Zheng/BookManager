package com.shigure.model;

public class User {
    private int userId;
    private String userName;
    private String password;
    private String realName;
    private String telPhone;

    public User(String password, int userId) {
        this.userId = userId;
        this.password = password;
    }

    public User(int userId) {
        this.userId = userId;
    }

    public User(String realName,  String telPhone, String password, int userId) {
        this.userId = userId;
        this.realName = realName;
        this.telPhone = telPhone;
        this.password = password;
    }

    public User(String realName,  String telPhone, int userId) {
        this.userId = userId;
        this.realName = realName;
        this.telPhone = telPhone;
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

    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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
