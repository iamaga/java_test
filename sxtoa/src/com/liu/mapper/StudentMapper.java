package com.liu.mapper;

import com.liu.pojo.Student;

import java.util.List;

public interface StudentMapper {
    List<Student> selectByPage(Integer currentPage,Integer size ,String stuname,String stuage);

    int getTotalSize(String stuname,String stuage);
    int addStudent(Student student);
}
