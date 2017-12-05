package com.shigure.model;

public class Manager {

    private int id;
    private String userName;
    private String password;


    public Manager(String userName, String password) {
        super();
        this.userName = userName;
        this.password = password;
    }

    public Manager() {
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
