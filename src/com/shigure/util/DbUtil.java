package com.shigure.util;

import java.sql.Connection;
import java.sql.DriverManager;


public class DbUtil {

    public DbUtil() {

    }

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static Connection getConnection() throws Exception {
        String url = "jdbc:mysql://localhost:3306/db_book" + "?useUnicode=true&characterEncoding=utf-8&useSSL=false";
        String user = "root";
        String password = "zhengsiyuan4399";
        return DriverManager.getConnection(url, user, password);
    }

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
