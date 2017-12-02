package com.shigure.model;

public class Book {

    private int id;
    private String bookName;
    private String author;
    private float price;
    private String bookDesc;
    private int bookTypeId = -1;
    private String BookTypeName;

    public Book(int id, String bookName, String author, float price, String bookDesc, int bookTypeId) {
        this.id = id;
        this.bookName = bookName;
        this.author = author;
        this.price = price;
        this.bookDesc = bookDesc;
        this.bookTypeId = bookTypeId;
    }

    public Book() {
        super();
    }

    public Book(String bookName, String author, int bookTypeId) {
        this.bookName = bookName;
        this.author = author;
        this.bookTypeId = bookTypeId;
    }

    public String getBookTypeName() {
        return BookTypeName;
    }

    public void setBookTypeName(String bookTypeName) {
        BookTypeName = bookTypeName;
    }

    public Book(String bookName, String author, float price, String bookDesc , int bookTypeId) {
        super();
        this.bookName = bookName;
        this.author = author;
        this.price = price;
        this.bookDesc = bookDesc;
        this.bookTypeId = bookTypeId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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


    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
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
