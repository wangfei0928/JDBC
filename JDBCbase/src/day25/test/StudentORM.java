package day25.test;

import day25.bean.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentORM {
    public Student getStuById(String sid) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/shixun?useUnicode=true&characterEncoding=utf-8";
        String username = "root";
        String password = "wangfei.*0928";
        Connection connection = DriverManager.getConnection(url,username,password);
        Statement statement = connection.createStatement();
        String sql = "select * from student where s_id='"+sid+"'";

        ResultSet resultSet = statement.executeQuery(sql);
        if (resultSet.next()){
            String s_id = resultSet.getString("s_id");
            String s_name = resultSet.getString("s_name");
            String s_birth = resultSet.getString("s_birth");
            String s_sex = resultSet.getString("s_sex");

            Student student = new Student(s_id,s_name,s_birth,s_sex);
            return student;
        }else {
            return null;
        }
    }
    public List<Student> getAll() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/shixun?useUnicode=true&characterEncoding=utf-8";
        String username = "root";
        String password = "wangfei.*0928";
        Connection connection = DriverManager.getConnection(url,username,password);
        Statement statement = connection.createStatement();
        String sql = "select * from student";
        ResultSet resultSet = statement.executeQuery(sql);
        List<Student> list = new ArrayList<>();
        while (resultSet.next()){
            String s_id = resultSet.getString("s_id");
            String s_name = resultSet.getString("s_name");
            String s_birth = resultSet.getString("s_birth");
            String s_sex = resultSet.getString("s_sex");

            Student student = new Student(s_id,s_name,s_birth,s_sex);
            list.add(student);
        }
        return list;
    }

    public void save(Student student) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/shixun?useUnicode=true&characterEncoding=utf-8";
        String username = "root";
        String password = "wangfei.*0928";
        Connection connection = DriverManager.getConnection(url,username,password);
        Statement statement = connection.createStatement();

        String sql = "insert into student(s_id,s_name,s_birth,s_sex) values('"+student.getS_id()+"','"+student.getS_name()+"','"
                +student.getS_birth()+"','"+student.getS_sex()+"' )";
        statement.executeUpdate(sql);
    }
}
