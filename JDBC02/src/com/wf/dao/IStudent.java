package com.wf.dao;

import com.wf.bean.Student;

import java.sql.SQLException;
import java.util.List;

public interface IStudent {

    public Student findById(String id) throws Exception;

    public List<Student> findAll() throws SQLException;

    public void save(Student student) throws SQLException;

    public void updateById(String sno, String sname, String ssex,Integer sage) throws SQLException;

    public void deleteById(String id) throws Exception;
}
