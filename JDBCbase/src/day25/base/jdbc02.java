package day25.base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbc02 {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/homework?useUnicode=true&characterEncoding=utf-8";
            String username = "root";
            String password = "wangfei.*0928";
            connection = DriverManager.getConnection(url,username,password);
            statement = connection.createStatement();
//            String sql = " insert into teacher(tno,tname,tsex) values('83','小王','男') ";
            String sql = " insert into teacher(tno,tname,tsex) values('86','小李','男'),('85','小张','女') ";

//            boolean flag = statement.execute(sql);   //注意这里，可以增删改
            int i = statement.executeUpdate(sql);      // 返回值 ，涉及到几条数据
            System.out.println(i);
//            System.out.println(flag);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
