package com.shigure.dao;

import com.shigure.model.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class BookDao {

    public int bookAdd(Connection con, Book book) throws Exception{
        String sql = "insert into t_book values(null,?,?,?,?,?)";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1,book.getBookName());
        pstmt.setString(2,book.getAuthor());
        pstmt.setFloat(3,book.getPrice());
        pstmt.setString(4,book.getBookDesc());
        pstmt.setInt(5,book.getBookTypeId());
        return pstmt.executeUpdate();
    }
}
