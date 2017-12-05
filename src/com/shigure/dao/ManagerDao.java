package com.shigure.dao;

import com.shigure.model.Manager;
import com.shigure.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ManagerDao {

    public Manager login(Connection con, Manager manager) throws Exception {

        Manager resultManager = null;
        String sql = "SELECT * FROM t_manager WHERE userName=? AND password=?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1, manager.getUserName());
        pstmt.setString(2, manager.getPassword());
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            resultManager = new Manager();
            resultManager.setUserName(rs.getString("userName"));
            resultManager.setPassword(rs.getString("password"));
        }
        return resultManager;
    }
}



