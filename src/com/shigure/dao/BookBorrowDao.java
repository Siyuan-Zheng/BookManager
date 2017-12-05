package com.shigure.dao;

import com.shigure.model.Book;
import com.shigure.model.BookBorrow;
import com.shigure.util.StringUtil;
import com.shigure.view.ReaderDashBoard;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BookBorrowDao {

    public int borrowAdd(Connection con, BookBorrow bookBorrow) throws Exception{
        String sql = "insert into t_bookBorrow values(null,?,?,?)";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setInt(1,bookBorrow.getUserId());
        pstmt.setInt(2,bookBorrow.getBookId());
        pstmt.setDate(3, (Date) bookBorrow.getBorrowTime());
        return pstmt.executeUpdate();
    }

    public ResultSet borrowList(Connection con, BookBorrow bookBorrow) throws Exception{
        String  sql = "select * from t_book b,t_user u,t_bookBorrow bb, t_bookType bt where u.id=bb.userId and b.id = bb.bookId and b.bookTypeId=bt.id and bb.userId like ?";
        //sb.append(" and bb.userId like '%").append(bookBorrow.getUserId()).append("%'");
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setInt(1, ReaderDashBoard.uid);
        return pstmt.executeQuery();
    }

}
