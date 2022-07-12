package day25.prejdbc;

import java.sql.*;

public class jdbc02 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/javaweb?useUnicode=true&characterEncoding=utf-8";
        String username = "root";
        String password = "wangfei.*0928";
        Connection connection = DriverManager.getConnection(url, username, password);

        String mname= "柳岩";   //登录成功了
        String mpassword = "123";
        String sql = "select * from t_manager where mname=? and mpassword =?"; //?称之为占位符

        PreparedStatement preparedStatement = connection.prepareStatement(sql);  //要提前传入sql
        preparedStatement.setString(1,mname);  //给第一个占位符 赋值
        preparedStatement.setString(2,mpassword);

        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()){
            System.out.println("登陆成功");
        }else {
            System.out.println("登录失败");
        }
    }
}
