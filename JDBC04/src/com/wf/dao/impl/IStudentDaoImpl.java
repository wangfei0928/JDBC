package com.wf.dao.impl;

import com.wf.bean.Student;
import com.wf.dao.IStudentDao;
import com.wf.util.JDBCUtil;

import java.util.List;

public class IStudentDaoImpl implements IStudentDao {
    @Override
    public List<Student> getAll() throws Exception {
        String sql = "select * from student";
        return  JDBCUtil.getAll(sql,null,Student.class);
    }
}
