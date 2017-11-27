package com.shigure.dao;

import com.shigure.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;


public class RegisterDao {

    public int userRegister(Connection con, User user) throws Exception {
        String sql = "insert into t_user values(null,?,?)";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, user.getUserName());
        pstmt.setString(2, user.getPassword());
        return pstmt.executeUpdate();
    }
}
