package com.shigure.dao;

import com.shigure.model.BookBorrow;
import com.shigure.model.BookRecommend;
import com.shigure.model.User;
import com.shigure.view.ReaderDashBoard;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BookRecommendDao {

    public int recommendAdd(Connection con, BookRecommend bookRecommend) throws Exception{
        String sql = "insert into t_bookRecommend values(null,?,?,?,?,?,?,?)";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setInt(1, bookRecommend.getUserId());
        pstmt.setString(2,bookRecommend.getBookName());
        pstmt.setString(3,bookRecommend.getAuthor());
        pstmt.setString(4,bookRecommend.getRecommendStatus());
        pstmt.setString(5,bookRecommend.getPressName());
        pstmt.setString(6,bookRecommend.getBookDesc());
        pstmt.setInt(7,bookRecommend.getBookTypeId());
        return pstmt.executeUpdate();
    }

    public ResultSet recommendList(Connection con, BookRecommend bookRecommend,User user) throws Exception{
        String  sql = "select * from t_bookRecommend br, t_bookType bt where br.bookTypeId=bt.id and userId like ?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setInt(1, user.getUserId());
        return pstmt.executeQuery();
    }

    public int recommendDelete(Connection con,int recommendId) throws Exception{
        String sql = "delete from t_bookRecommend where recommendId=?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, String.valueOf(recommendId));
        return pstmt.executeUpdate();
    }

    public ResultSet recommendList(Connection con, BookRecommend bookRecommend) throws Exception{
        String  sql = "select * from t_bookRecommend br, t_bookType bt, t_user u where br.bookTypeId=bt.id and br.userId=u.id";
        PreparedStatement pstmt = con.prepareStatement(sql);
        return pstmt.executeQuery();
    }

    public int recommendUpdate(Connection con, BookRecommend bookRecommend) throws Exception{
        String sql = "update t_bookRecommend set recommendStatus=? where recommendId=?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1,bookRecommend.getRecommendStatus());
        pstmt.setInt(2,bookRecommend.getRecommendId());
        return pstmt.executeUpdate();
    }
}
