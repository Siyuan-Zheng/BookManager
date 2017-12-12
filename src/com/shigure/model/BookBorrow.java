package com.shigure.model;

import java.util.Date;

public class BookBorrow {
    private int id;
    private int userId;
    private int bookId;
    private Date borrowTime;
    private Date originalTime;
    private Date returnTime;

    public BookBorrow(int id, int userId, Date returnTime) {
        this.id = id;
        this.userId = userId;
        this.returnTime = returnTime;
    }

    public BookBorrow(int id, Date originalTime) {
        this.id = id;
        this.originalTime = originalTime;
    }

    public Date getOriginalTime() {
        return originalTime;
    }

    public void setOriginalTime(Date originalTime) {
        this.originalTime = originalTime;
    }

    public Date getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(Date returnTime) {
        this.returnTime = returnTime;
    }

    public BookBorrow() {
        super();
    }

    public BookBorrow(int userId, int bookId, Date borrowTime, Date originalTime, Date returnTime) {
        this.userId = userId;
        this.bookId = bookId;
        this.borrowTime = borrowTime;
        this.originalTime = originalTime;
        this.returnTime = returnTime;
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
