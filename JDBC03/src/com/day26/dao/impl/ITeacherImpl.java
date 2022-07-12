package com.day26.dao.impl;
import com.day26.bean.Teacher;
import com.day26.dao.ITeacher;
import com.day26.util.JDBCUtil;


import java.util.List;

public class ITeacherImpl implements ITeacher {
    @Override
    public List<Teacher> getAll() throws Exception {
        String sql = "select * from teacher";
        List<Teacher> all = JDBCUtil.getAll(sql, null, Teacher.class);
        System.out.println(all);
        return null;
    }

    @Override
    public void insertOne(Teacher teacher) throws Exception {
        String sql = "insert into teacher(tno,tname,tsex) values(?,?,?)";
        Object[] os = {teacher.getTno(),teacher.getTname(),teacher.getTsex()};
        JDBCUtil.doExecute(sql,os);
    }

    @Override
    public long getCount() throws Exception {
        String sql = "select count(*) from teacher";
        Object num = JDBCUtil.getGroupMethod(sql,null);
        return (long)num;
    }
}
