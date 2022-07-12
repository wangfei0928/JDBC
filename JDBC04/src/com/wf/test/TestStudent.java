package com.wf.test;

import com.wf.bean.Student;
import com.wf.service.IStudentService;
import com.wf.service.impl.IStudentServiceImpl;

import java.util.List;

public class TestStudent {

    public static void main(String[] args) throws Exception {

        IStudentServiceImpl iStudentService = new IStudentServiceImpl();
        List<Student> all = iStudentService.getAll();
        System.out.println(all);
    }
}
