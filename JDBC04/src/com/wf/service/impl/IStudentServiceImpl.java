package com.wf.service.impl;

import com.wf.bean.Student;
import com.wf.dao.IStudentDao;

import java.util.List;

public class IStudentServiceImpl implements IStudentDao {
    @Override
    public List<Student> getAll() throws Exception {
        IStudentDao iStudentDao = new IStudentServiceImpl();
        List<Student> all = iStudentDao.getAll();
        return all;
    }
}
