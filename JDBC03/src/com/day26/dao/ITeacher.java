package com.day26.dao;

import com.day26.bean.Teacher;

import java.util.List;

public interface ITeacher {

    public List<Teacher> getAll() throws Exception;

    public void insertOne(Teacher teacher) throws Exception;

    public long getCount () throws Exception;
}
