package day25.prejdbc;

import java.sql.*;

public class jdbc01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        //2. 获取数据库的连接
        String url = "jdbc:mysql://localhost:3306/javaweb?useUnicode=true&characterEncoding=utf-8";
        String username = "root";
        String password = "wangfei.*0928";
        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();

        String mname= "柳岩'or'a'='a ";   //登录成功了
        String mname2= "柳岩";
        String mpassword = "123";
        String sql = "select * from t_manager where mname='"+mname +"'and mpassword ='"+mpassword+"'";
        ResultSet resultSet = statement.executeQuery(sql);
        System.out.println(sql);
        if (resultSet.next()){
            System.out.println("登录成功");
        }else {
            System.out.println("登陆失败");
        }
    }
}
