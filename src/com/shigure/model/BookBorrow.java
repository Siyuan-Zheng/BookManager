package com.shigure.model;

import java.util.Date;

public class BookBorrow {
    private int id;
    private int userId;
    private int bookId;
    private Date borrowTime;

    public BookBorrow() {
        super();
    }

    public BookBorrow(int userId, int bookId, Date borrowTime) {
        this.userId = userId;
        this.bookId = bookId;
        this.borrowTime = borrowTime;
    }

    public BookBorrow(int id, int userId, int bookId, Date borrowTime) {
        super();
        this.id = id;
        this.userId = userId;
        this.bookId = bookId;
        this.borrowTime = borrowTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public Date getBorrowTime() {
        return borrowTime;
    }

    public void setBorrowTime(Date borrowTime) {
        this.borrowTime = borrowTime;
    }
}
