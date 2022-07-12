package day25.test;

import day25.bean.Student;

import java.sql.SQLException;
import java.util.List;

public class Test {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        StudentORM studentORM = new StudentORM();
        Student student = studentORM.getStuById("08");
        System.out.println(student);

        List<Student> all = studentORM.getAll();
        for (Student student1 : all) {
            System.out.println(student1);
        }

        Student student1 = new Student("09","张三","2001-09-28","女");
        studentORM.save(student1);
    }
}
