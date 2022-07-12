package day25.base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbc04 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/homework?useUnicode=true&characterEncoding=utf-8";
        String username = "root";
        String password = "wangfei.*0928";
        Connection connection = DriverManager.getConnection(url, username, password);

        Statement statement = connection.createStatement();
        String sql = "delete from teacher where tno in ('84','86')";

        int i = statement.executeUpdate(sql);
        System.out.println(i);

        statement.close();
        connection.close();

    }
}
