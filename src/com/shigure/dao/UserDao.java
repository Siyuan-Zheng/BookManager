package com.shigure.dao;

import com.shigure.model.Manager;
import com.shigure.model.User;
import com.shigure.util.StringUtil;
import com.shigure.view.ReaderDashBoard;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class UserDao {

    public User login(Connection con, User user) throws Exception {

        User resultUser = null;
        String sql = "SELECT * FROM t_user WHERE userName=? AND password=?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, user.getUserName());
        pstmt.setString(2, user.getPassword());
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            resultUser = new User();
            resultUser.setUserName(rs.getString("userName"));
            resultUser.setPassword(rs.getString("password"));
        }
        return resultUser;
    }

    public static int userRegister(Connection con, User user) throws Exception {
        String sql = "INSERT INTO t_user VALUES(NULL,?,?,?,?)";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, user.getUserName());
        pstmt.setString(2, user.getPassword());
        pstmt.setString(3, user.getRealName());
        pstmt.setString(4, user.getTelPhone());
        return pstmt.executeUpdate();
    }

    public static User getUserId(Connection con, User user) throws Exception{
        ResultSet rs = null;
        String sql = "select * from t_user where userName=?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, user.getUserName());
        rs = pstmt.executeQuery();
        while (rs.next()){
            user = new User();
            user.setUserId(rs.getInt("id"));
        }
        return user;
    }

    public ResultSet userList(Connection con, User user) throws Exception{
        String  sql = "select * from t_user where id like ?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setInt(1, user.getUserId());
        return pstmt.executeQuery();
    }

    public static int userUpdate(Connection con, User user) throws Exception{
        String sql = "update t_user set realName=? , telPhone=?  where id=?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1,user.getRealName());
        pstmt.setString(2,user.getTelPhone());
        pstmt.setInt(3,user.getUserId());
        return pstmt.executeUpdate();
    }

    public static int passwordUpdate(Connection con, User user) throws Exception{
        String sql = "update t_user set password=?  where id=?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1,user.getPassword());
        pstmt.setInt(2,user.getUserId());
        return pstmt.executeUpdate();
    }

    public ResultSet userList(Connection con) throws Exception{
        String  sql = "select * from t_user ";
        PreparedStatement pstmt = con.prepareStatement(sql);
        return pstmt.executeQuery();
    }
}
