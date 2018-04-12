package com.shigure.model;

public class Manager{

    private int managerId;
    private String userName;
    private String password;


    public Manager(String userName, String password) {
        super();
        this.userName = userName;
        this.password = password;
    }

    public Manager() {

    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
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
