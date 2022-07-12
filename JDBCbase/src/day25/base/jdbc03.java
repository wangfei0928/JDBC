package day25.base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbc03 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/homework?useUnicode=true&characterEncoding=utf-8";
        String username = "root";
        String password = "wangfei.*0928";
        Connection connection = DriverManager.getConnection(url,username,password);

        Statement statement = connection.createStatement();
        String sql = "update teacher set tname='王中王' where tno = '832'";
        statement.executeUpdate(sql);

        statement.close();
        connection.close();
    }
}
