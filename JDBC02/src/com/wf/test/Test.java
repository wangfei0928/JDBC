package com.wf.test;

import com.wf.bean.Student;
import com.wf.bean.Teacher;
import com.wf.dao.IStudent;
import com.wf.dao.ITeacher;
import com.wf.dao.impl.IStudentImpl;
import com.wf.dao.impl.ITeacherImpl;

import java.util.List;
import java.util.Scanner;

public class Test {
    static ITeacher teacher = new ITeacherImpl();
    static IStudent student = new IStudentImpl();
    public static void main(String[] args) throws Exception {
        menu();
    }

    public static void menu() throws Exception {
        System.out.println("欢迎使用蓝鸥教务系统");
        System.out.println("1. 教师管理");
        System.out.println("2. 学生管理");
        System.out.println("3. 科目管理");
        System.out.println("4. 成绩管理");
        System.out.print("请键盘输入对应菜单的序号:");

        //获取用户输入的编号
        Scanner scanner = new Scanner(System.in);
        int menuId = scanner.nextInt();
        //通过while循环限制用户输入的内容。
        while(menuId > 4 || menuId < 1){
            System.out.print("功能编号有误，请重新输入（1-4）：");
            menuId = scanner.nextInt();
        }
        //根据功能编号，进入不同的功能模块
        switch (menuId) {
            case 1:
                teacherMenu();
            case 2:
                studentMenu();
        }

    }
    public static void teacherMenu() throws Exception {
        boolean isExit = false;
        while (isExit == false) {
            System.out.println("1.查询教师信息");
            System.out.println("2.添加教师");
            System.out.println("3.修改教师信息");
            System.out.println("4.删除教师信息");
            System.out.println("0. 返回上一级");
            //获取用户输入的编号
            Scanner scanner = new Scanner(System.in);
            int teacherMenuId = scanner.nextInt();
            //通过while循环限制用户输入的内容。
            while (teacherMenuId > 4 || teacherMenuId < 0) {
                System.out.print("功能编号有误，请重新输入（1-4）：");
                teacherMenuId = scanner.nextInt();
            }
            //根据功能编号，进入不同的功能模块
            switch (teacherMenuId) {
                case 1:
                    System.out.println("请输入工号（查询所有输入*号，0：返回上一级菜单）");
                    String tno = scanner.next();
                    if (tno.equals("*")) {
                        //查询所有
                        List<Teacher> all = teacher.findAll();
                        for (Teacher teacher1 : all) {
                            System.out.println(teacher1);
                        }
                    } else {
                        //通过id进行查询
                        Teacher teacher1 = teacher.findById(tno);
                        System.out.println(teacher1);
                    }
                    break;
                case 2:
                    System.out.println("请依次输入教师的工号，姓名，性别");
                    String tno2 = scanner.next();
                    String tname = scanner.next();
                    String tsex = scanner.next();
                    //添加
                    Teacher teacher1 = new Teacher(tno2, tname, tsex);
                    teacher.save(teacher1);
                    break;
                case 3:
                    System.out.println("请输入需要修改信息的教师工号:");
                    String tno3 = scanner.next();
                    System.out.print("请输入此教师新姓名:");
                    String tname3 = scanner.next();
                    System.out.print("请输入此教师新性别:");
                    String tsex3 = scanner.next();
                    //修改
                    teacher.updateById(tno3, tname3, tsex3);
                    break;
                case 4:
                    System.out.println("请输入离职老师工号:");
                    String tno4 = scanner.next();
                    teacher.deleteById(tno4); //删除
                    break;
                case 0:
                    isExit = true;
                    menu();
            }
        }
    }

    public static void studentMenu() throws Exception {
        boolean isExit = false;
        while (isExit == false) {
            System.out.println("1.查询学生信息");
            System.out.println("2.添加学生");
            System.out.println("3.修改学生信息");
            System.out.println("4.删除学生信息");
            System.out.println("0.返回上一级");

            //获取用户输入的编号
            Scanner scanner = new Scanner(System.in);
            int studentMenuId = scanner.nextInt();
            //通过while循环限制用户输入的内容。
            while (studentMenuId > 4 || studentMenuId < 0) {
                System.out.print("功能编号有误，请重新输入（1-4）：");
                studentMenuId = scanner.nextInt();
            }
            //根据功能编号，进入不同的功能模块
            switch (studentMenuId) {
                case 1:
                    System.out.println("请输入学号（查询所有输入*号，0：返回上一级菜单）");
                    String sno = scanner.next();
                    if (sno.equals("*")) {
                        //查询所有
                        List<Student> all = student.findAll();
                        for (Student student1 : all) {
                            System.out.println(student1);
                        }
                    } else {
                        //通过id进行查询
                        Student student1 = student.findById(sno);
                        System.out.println(student1);
                    }
                    break;
                case 2:
                    System.out.println("请依次输入学生的的工号，姓名，性别");
                    String sno2 = scanner.next();
                    String sname = scanner.next();
                    String ssex = scanner.next();
                    int sage = scanner.nextInt();
                    //添加
                    Student student1 = new Student(sno2, sname, ssex,sage);
                    student.save(student1);
                    break;
                case 3:
                    System.out.println("请输入需要修改信息的学生学号:");
                    String sno3 = scanner.next();
                    System.out.print("请输入此学生新姓名:");
                    String sname3 = scanner.next();
                    System.out.print("请输入此学生新性别:");
                    String ssex3 = scanner.next();
                    System.out.println("请输入此学生新年龄:");
                    Integer sage3 = scanner.nextInt();
                    //修改
                    student.updateById(sno3, sname3, ssex3,sage3);
                    break;
                case 4:
                    System.out.println("请输入被删除的学生学号:");
                    String sno4 = scanner.next();
                    student.deleteById(sno4); //删除
                    break;
                case 0:
                    isExit = true;
                    menu();
            }
        }
    }
}
