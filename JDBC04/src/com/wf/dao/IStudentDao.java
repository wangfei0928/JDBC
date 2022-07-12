package com.wf.dao;

import com.wf.bean.Student;

import java.util.List;

public interface IStudentDao {


    public List<Student> getAll() throws Exception;
}
