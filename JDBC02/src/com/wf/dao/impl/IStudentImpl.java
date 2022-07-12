package com.wf.dao.impl;

import com.wf.bean.Student;
import com.wf.dao.IStudent;
import com.wf.util.JDBCUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IStudentImpl implements IStudent {
    @Override
    public Student findById(String id) throws Exception {

        String sql = "select * from student where sno = '"+id+"'";
        ResultSet resultSet = JDBCUtil.doQuery(sql);
        if (resultSet.next()){
            String sname = resultSet.getString("sname");
            String ssex = resultSet.getString("ssex");
            Integer sage = resultSet.getInt("sage");
            Student student = new Student(id,sname,ssex,sage);
            return student;
        }else {
            return null;
        }

    }

    @Override
    public List<Student> findAll() throws SQLException {
        String sql = "select * from student";
        List<Student> list = new ArrayList<>();
        ResultSet resultSet = JDBCUtil.doQuery(sql);
        while (resultSet.next()){
            String sno = resultSet.getString("sno");
            String sname = resultSet.getString("sname");
            String ssex = resultSet.getString("ssex");
            Integer sage = resultSet.getInt("sage");
            Student student = new Student(sno,sname,ssex,sage);
            list.add(student);
        }
        return list;
    }

    @Override
    public void save(Student student) throws SQLException {
        String sql = "insert into student(sname,ssex,sage) values('"+student.getSname()+"','"+student.getSsex()+"','"+student.getSage()+"')";
        JDBCUtil.doExcute(sql);
    }

    @Override
    public void updateById(String sno, String sname, String ssex,Integer sage) throws SQLException {
        String sql = "update student set sname ='"+ sname+"',ssex ='"+ssex+"+sage='"+sage+"' where tno = '"+sno+"'";
        JDBCUtil.doExcute(sql);
    }

    public void deleteById(String id) throws Exception {
        String sql = "delete from student where sno = '"+id+"'";
        JDBCUtil.doExcute(sql);
    }
}
