package com.shigure.model;

public class BookRecommend {
    private int recommendId;
    private int userId;
    private String bookName;
    private String author;
    private String recommendStatus;
    private String pressName;
    private String bookDesc;
    private int bookTypeId;

    public BookRecommend(int userId, String bookName, String author,String recommendStatus, String pressName, String bookDesc, int bookTypeId) {
        this.userId = userId;
        this.bookName = bookName;
        this.author = author;
        this.recommendStatus = recommendStatus;
        this.pressName = pressName;
        this.bookDesc = bookDesc;
        this.bookTypeId = bookTypeId;
    }

    public BookRecommend() {
        super();
    }

    public BookRecommend(int recommendId, int userId, String bookName, String author, String recommendStatus, String pressName, String bookDesc, int bookTypeId) {
        super();
        this.recommendId = recommendId;
        this.userId = userId;
        this.bookName = bookName;
        this.author = author;
        this.recommendStatus = recommendStatus;
        this.pressName = pressName;
        this.bookDesc = bookDesc;
        this.bookTypeId = bookTypeId;
    }

    public int getRecommendId() {
        return recommendId;
    }

    public void setRecommendId(int recommendId) {
        this.recommendId = recommendId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getRecommendStatus() {
        return recommendStatus;
    }

    public void setRecommendStatus(String recommendStatus) {
        this.recommendStatus = recommendStatus;
    }

    public String getPressName() {
        return pressName;
    }

    public void setPressName(String pressName) {
        this.pressName = pressName;
    }

    public String getBookDesc() {
        return bookDesc;
    }

    public void setBookDesc(String bookDesc) {
        this.bookDesc = bookDesc;
    }

    public int getBookTypeId() {
        return bookTypeId;
    }

    public void setBookTypeId(int bookTypeId) {
        this.bookTypeId = bookTypeId;
    }
}
