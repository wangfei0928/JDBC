package com.day26.dao.impl;

import com.day26.bean.Student;
import com.day26.dao.IStudent;
import com.day26.util.JDBCUtil;


import java.util.List;

public class IStudentImpl implements IStudent {
    @Override
    public void updateStudent(Student student) throws Exception {
        String sql = "update student set sname=?,ssex=?,sage=? where sno=?";
        Object[] objects = {student.getSname(),student.getSsex(),student.getSage(),student.getSno()};
        JDBCUtil.doExecute(sql,objects);
    }

    @Override
    public List<Student> getAll() throws Exception {
        String sql = " select * from student";
        List<Student> all = JDBCUtil.getAll(sql, null, Student.class);
        return all;
    }

    @Override
    public Student getById(String id) throws Exception {
        String sql = "select * from student where sno = ?";
        Object[] os = {id};
        Student one = JDBCUtil.getOne(sql, os, Student.class);
        return  one;
    }

}
