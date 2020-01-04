package com.liu.service;

import com.liu.pojo.Student;
import com.liu.util.PageBean;

import java.util.List;

public interface StudentService {
    PageBean<Student> selectByPage(Integer currentPage, Integer size,String stuname,String stuage );


    int addStudent(Student student);
}
