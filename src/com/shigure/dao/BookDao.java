package com.shigure.dao;

import com.shigure.model.Book;
import com.shigure.model.BookType;
import com.shigure.util.StringUtil;

import java.sql.*;

public class BookDao {

    public int bookAdd(Connection con, Book book) throws Exception{
        String sql = "insert into t_book values(null,?,?,?,?,?)";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1,book.getBookName());
        pstmt.setString(2,book.getAuthor());
        pstmt.setString(3,book.getPressName());
        pstmt.setString(4,book.getBookDesc());
        pstmt.setInt(5,book.getBookTypeId());
        return pstmt.executeUpdate();
    }

    public ResultSet bookList(Connection con,Book book) throws Exception{
        StringBuilder sb = new StringBuilder("select * from t_book b,t_bookType bt where b.bookTypeId=bt.id");
        if(StringUtil.isNotEmpty(book.getBookName())){
            sb.append(" and b.bookName like '%").append(book.getBookName()).append("%'");
        }
        if(StringUtil.isNotEmpty(book.getAuthor())){
            sb.append(" and b.author like '%").append(book.getAuthor()).append("%'");
        }
        if(StringUtil.isNotEmpty(book.getPressName())){
            sb.append(" and b.pressName like '%").append(book.getPressName()).append("%'");
        }
        if(book.getBookTypeId() != -1){
            sb.append(" and b.bookTypeId =").append(book.getBookTypeId());
        }
        PreparedStatement pstmt = con.prepareStatement(sb.toString());
        return pstmt.executeQuery();
    }

    public int bookDelete(Connection con,String id) throws Exception{
        String sql = "delete from t_book where id=?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1,id);
        return pstmt.executeUpdate();
    }

    public int bookUpdate(Connection con,Book book) throws Exception{
        String sql = "update t_book set bookName=?,author=?,price=?,bookDesc=?,bookTypeId=? where id=?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1,book.getBookName());
        pstmt.setString(2,book.getAuthor());
        pstmt.setString(3,book.getPressName());
        pstmt.setString(4,book.getBookDesc());
        pstmt.setInt(5,book.getBookTypeId());
        pstmt.setInt(6,book.getBookId());
        return pstmt.executeUpdate();
    }

    public boolean getBookByBookTypeId(Connection con,String bookTypeId)throws Exception{
        String sql = "select * from t_book where bookTypeId=?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1,bookTypeId);
        ResultSet rs = pstmt.executeQuery();
        return rs.next();
    }
}

