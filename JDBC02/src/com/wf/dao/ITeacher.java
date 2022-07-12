package com.wf.dao;

import com.wf.bean.Teacher;

import java.sql.SQLException;
import java.util.List;

public interface ITeacher {

    public Teacher findById(String id) throws Exception;

    public List<Teacher> findAll() throws SQLException;

    public void save(Teacher teacher) throws SQLException;

    public void updateById(String id,String tname,String tsex) throws Exception;

    public void deleteById(String id) throws Exception;

}
