package com.wf.util;

import java.sql.*;

public class JDBCUtil {

    private static Connection connection = null;
    private static Statement statement = null;

    static {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/homework?useUnicode=true&characterEncoding=utf-8";
            String username = "root";
            String password = "wangfei.*0928";
            connection = DriverManager.getConnection(url,username,password);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //执行增删改的方法
    public static void doExcute(String sql) throws SQLException {
        statement = connection.createStatement();
        statement.executeUpdate(sql);
    }

    //执行查询的方法
    public static ResultSet doQuery(String sql) throws SQLException {
        statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        return resultSet;
    }
}
