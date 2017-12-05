package com.shigure.dao;

import com.shigure.model.Book;
import com.shigure.model.BookBorrow;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

public class BookBorrowDao {

    public int borrowAdd(Connection con, BookBorrow bookBorrow) throws Exception{
        String sql = "insert into t_bookBorrow values(null,?,?,?)";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setInt(1,bookBorrow.getUserId());
        pstmt.setInt(2,bookBorrow.getBookId());
        pstmt.setDate(3, (Date) bookBorrow.getBorrowTime());
        return pstmt.executeUpdate();
    }

}
