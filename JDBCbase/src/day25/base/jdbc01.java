package day25.base;

import java.sql.*;

public class jdbc01 {
    public static void main(String[] args) {

        ResultSet resultSet = null;
        Statement statement = null;
        Connection connection = null;
        try {
            //1. 反射技术，得到代码使用的是哪个数据库
            Class.forName("com.mysql.jdbc.Driver");
            //2. 获取数据库的连接
            String url = "jdbc:mysql://localhost:3306/homework?useUnicode=true&characterEncoding=utf-8";
            String username = "root";
            String password = "wangfei.*0928";
            connection = DriverManager.getConnection(url, username, password);

            //3. 得到执行sql的接口Statement
            String sql = "select * from teacher";
            statement = connection.createStatement();
            //4. 接收从数据库返回的结果，可能是一条，也可能是好多条
            resultSet = statement.executeQuery(sql);

            //5. 处理结果集
            while (resultSet.next()) {
                String tno = resultSet.getString("tno");
                String tname = resultSet.getString("tname");
                String tsex = resultSet.getString("tsex");
                System.out.println(tno + "----" + tname + "----" + tsex);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                resultSet.close();
                statement.close();
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
