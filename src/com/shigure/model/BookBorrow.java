package com.shigure.model;

import java.util.Date;

public class BookBorrow {
    private int borrowId;
    private int userId;
    private int bookId;
    private Long borrowTime;
    private Long originalTime;
    private Long returnTime;
    private int reStatus;

    public int getReStatus() {
        return reStatus;
    }

    public void setReStatus(int reStatus) {
        this.reStatus = reStatus;
    }

    public BookBorrow(int borrowId, int userId, Long returnTime) {
        this.borrowId = borrowId;
        this.userId = userId;
        this.returnTime = returnTime;
    }

    public BookBorrow(int borrowId, Long originalTime) {
        this.borrowId = borrowId;
        this.originalTime = originalTime;
    }

    public Long getOriginalTime() {
        return originalTime;
    }

    public void setOriginalTime(Long originalTime) {
        this.originalTime = originalTime;
    }

    public Long getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(Long returnTime) {
        this.returnTime = returnTime;
    }

    public BookBorrow() {
    }

    public BookBorrow(int userId, int bookId, Long borrowTime, Long originalTime, Long returnTime) {
        this.userId = userId;
        this.bookId = bookId;
        this.borrowTime = borrowTime;
        this.originalTime = originalTime;
        this.returnTime = returnTime;
    }

    public BookBorrow(int borrowId, int userId, int bookId, Long borrowTime) {
        super();
        this.borrowId = borrowId;
        this.userId = userId;
        this.bookId = bookId;
        this.borrowTime = borrowTime;
    }

    public int getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(int borrowId) {
        this.borrowId = borrowId;
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

    public Long getBorrowTime() {
        return borrowTime;
    }

    public void setBorrowTime(Long borrowTime) {
        this.borrowTime = borrowTime;
    }
}
