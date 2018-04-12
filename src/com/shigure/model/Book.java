package com.shigure.model;

public class Book {

    private int bookId;
    private String bookName;
    private String author;
    private String pressName;
    private String bookDesc;
    private int bookTypeId = -1;
    private String BookTypeName;

    public Book(String bookName, String author, String pressName, String bookDesc, String bookTypeName) {
        this.bookName = bookName;
        this.author = author;
        this.pressName = pressName;
        this.bookDesc = bookDesc;
        BookTypeName = bookTypeName;
    }

    public Book(int bookId, String bookName, String author, String pressName, String bookDesc, int bookTypeId) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.author = author;
        this.pressName = pressName;
        this.bookDesc = bookDesc;
        this.bookTypeId = bookTypeId;
    }

    public Book() {
        super();
    }

    public Book(String bookName, String author, int bookTypeId, String pressName) {
        this.bookName = bookName;
        this.author = author;
        this.bookTypeId = bookTypeId;
        this.pressName = pressName;
    }

    public String getBookTypeName() {
        return BookTypeName;
    }

    public void setBookTypeName(String bookTypeName) {
        BookTypeName = bookTypeName;
    }

    public Book(String bookName, String author, String pressName, String bookDesc , int bookTypeId) {
        super();
        this.bookName = bookName;
        this.author = author;
        this.pressName = pressName;
        this.bookDesc = bookDesc;
        this.bookTypeId = bookTypeId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
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


    public String getPressName() {
        return pressName;
    }

    public void setpressName(String pressName) {
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
