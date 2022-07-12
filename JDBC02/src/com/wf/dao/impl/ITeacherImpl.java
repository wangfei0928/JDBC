package com.wf.dao.impl;

import com.wf.bean.Teacher;
import com.wf.dao.ITeacher;
import com.wf.util.JDBCUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ITeacherImpl implements ITeacher {
    @Override
    public Teacher findById(String id) throws Exception {

        String sql = "select * from teacher where tno = '"+id+"'";
        ResultSet resultSet = JDBCUtil.doQuery(sql);
        if (resultSet.next()){
            String tname = resultSet.getString("tname");
            String tsex = resultSet.getString("tsex");
            Teacher teacher = new Teacher(id,tname,tsex);
            return teacher;
        }else {
            return null;
        }

    }

    @Override
    public List<Teacher> findAll() throws SQLException {
        String sql = "select * from teacher";
        List<Teacher> list = new ArrayList<>();
        ResultSet resultSet = JDBCUtil.doQuery(sql);
        while (resultSet.next()){
            String tno = resultSet.getString("tno");
            String tname = resultSet.getString("tno");
            String tsex = resultSet.getString("tsex");
            Teacher teacher = new Teacher(tno,tname,tsex);
            list.add(teacher);
        }
        return list;
    }

    @Override
    public void save(Teacher teacher) throws SQLException {
        String sql = "insert into teacher(tno,tname,tsex) values('"+teacher.getTno()+"','"+teacher.getTname()+"','"+teacher.getTsex()+"')";
        JDBCUtil.doExcute(sql);
    }

    @Override
    public void updateById(String id,String tname,String tsex) throws Exception {
        String sql = "update teacher set tname ='"+ tname+"',tsex ='"+tsex+"' where tno = '"+id+"'";
        JDBCUtil.doExcute(sql);
    }

    @Override
    public void deleteById(String id) throws Exception {
        String sql = "delete from teacher where tno = '"+id+"'";
        JDBCUtil.doExcute(sql);
    }
}
