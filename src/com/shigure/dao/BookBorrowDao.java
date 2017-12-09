package com.shigure.dao;

import com.shigure.model.Book;
import com.shigure.model.BookBorrow;
import com.shigure.model.User;
import com.shigure.util.StringUtil;
import com.shigure.view.ReaderDashBoard;

import java.sql.*;

public class BookBorrowDao {

    public int borrowAdd(Connection con, BookBorrow bookBorrow) throws Exception{
        String sql = "insert into t_bookBorrow values(null,?,?,?)";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setInt(1,bookBorrow.getUserId());
        pstmt.setInt(2,bookBorrow.getBookId());
        pstmt.setDate(3, (Date) bookBorrow.getBorrowTime());
        //pstmt.setTimestamp(3,new Timestamp(bookBorrow.getBorrowTime().getTime()));
        return pstmt.executeUpdate();
    }

    public ResultSet borrowList(Connection con, User user) throws Exception{
        String  sql = "select * from t_book b,t_user u,t_bookBorrow bb, t_bookType bt where u.id=bb.userId and b.id = bb.bookId and b.bookTypeId=bt.id and bb.userId like ?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setInt(1, user.getId());
        return pstmt.executeQuery();
    }

    public int borrowDelete(Connection con,int borrowId) throws Exception{
        String sql = "delete from t_bookBorrow where borrowId=?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, String.valueOf(borrowId));
        return pstmt.executeUpdate();
    }
}
