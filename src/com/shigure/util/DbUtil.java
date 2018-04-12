package com.shigure.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DbUtil {

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    //连接数据库
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://115.159.202.192:3306/db_book" + "?useUnicode=true&characterEncoding=utf-8";
        String user = "shigure";
        String password = "zhengsiyuan4399";
        return DriverManager.getConnection(url, user, password);
    }

    //断开数据库连接
    public static void free(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
