package com.day26.dao;
import com.day26.bean.Student;

import java.util.List;

public interface IStudent {

    public void updateStudent (Student student) throws Exception;

    public List<Student> getAll() throws Exception;

    public Student getById(String id) throws Exception;
}