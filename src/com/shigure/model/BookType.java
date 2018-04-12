package com.shigure.model;

public class BookType {

    private int bookTypeId;
    private String bookTypeName;
    private String bookTypeDesc;

    public BookType() {
        super();
    }

    public BookType(String bookTypeName, String bookTypeDesc) {
        super();
        this.bookTypeName = bookTypeName;
        this.bookTypeDesc = bookTypeDesc;
    }

    public BookType(int bookTypeId, String bookTypeName, String bookTypeDesc) {
        super();
        this.bookTypeId = bookTypeId;
        this.bookTypeName = bookTypeName;
        this.bookTypeDesc = bookTypeDesc;
    }

    public String getBookTypeName() {
        return bookTypeName;
    }

    public void setBookTypeName(String bookTypeName) {
        this.bookTypeName = bookTypeName;
    }

    public int getBookTypeId() {
        return bookTypeId;
    }

    public void setBookTypeId(int bookTypeId) {
        this.bookTypeId = bookTypeId;
    }

    public String getBookTypeDesc() {
        return bookTypeDesc;
    }

    public void setBookTypeDesc(String bookTypeDesc) {
        this.bookTypeDesc = bookTypeDesc;
    }

    @Override
    public String toString() {
        return this.getBookTypeName();
    }
}
