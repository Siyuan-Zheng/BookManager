package com.shigure.dao;

import com.shigure.model.BookType;
import com.shigure.util.StringUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookTypeDao {

    public int bookTypeAdd(Connection con, BookType bookType) throws SQLException {
        String sql = "insert into t_bookType values(null,?,?)";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1,bookType.getBookTypeName());
        pstmt.setString(2,bookType.getBookTypeDesc());
        return pstmt.executeUpdate();
    }

    public static ResultSet bookTypeList(Connection con, BookType bookType) throws SQLException{
        StringBuilder sb = new StringBuilder("select * from t_bookType");
        if(StringUtil.isNotEmpty(bookType.getBookTypeName())){
            sb.append(" and bookTypeName like '%").append(bookType.getBookTypeName()).append("%'");
        }
        PreparedStatement psmt = con.prepareStatement(sb.toString().replaceFirst("and","where"));
        return psmt.executeQuery();
    }

    public int bookTypeDelete(Connection con,String id) throws SQLException {
        String sql = "delete from t_bookType where id = ?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1,id);
        return pstmt.executeUpdate();
    }

    public int bookTypeUpdate(Connection con,BookType bookType) throws SQLException{
        String sql = "update t_bookType set bookTypeName=? , bookTypeDesc=? where id=?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1,bookType.getBookTypeName());
        pstmt.setString(2,bookType.getBookTypeDesc());
        pstmt.setInt(3,bookType.getBookTypeId());
        return pstmt.executeUpdate();
    }
}
