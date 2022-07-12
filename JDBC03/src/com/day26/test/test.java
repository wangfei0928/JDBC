package com.day26.test;

import com.day26.bean.Student;
import com.day26.dao.IStudent;
import com.day26.dao.ITeacher;
import com.day26.dao.impl.IStudentImpl;
import com.day26.dao.impl.ITeacherImpl;



import java.util.List;

public class test {
    public static void main(String[] args) throws Exception {
        IStudent dao = new IStudentImpl();
//        Student student = new Student();
//        student.setSname("王蕾");
//        student.setSage(18);
//        student.setSsex("女");
//        student.setSno("110");
//        dao.updateStudent(student);
//        List<Student> all = dao.getAll();
//        System.out.println(all);

        Student student =dao.getById("7");
        System.out.println(student);


        ITeacher teacher = new ITeacherImpl();
        teacher.getAll();
        long count = teacher.getCount();
        System.out.println(count);

//        Teacher teacher1 = new Teacher("88","张飞","女");
//        teacher.insertOne(teacher1);
    }
}
