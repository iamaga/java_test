package com.liu.service.impl;

import com.liu.mapper.StudentMapper;
import com.liu.pojo.Student;
import com.liu.service.StudentService;
import com.liu.util.MybatisUtil;
import com.liu.util.PageBean;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    @Override
        public PageBean<Student> selectByPage(Integer currentPage, Integer size,String stuname,String stuage) {
        PageBean<Student> bean = new PageBean<Student>();
        SqlSession session = MybatisUtil.getSession();
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        List<Student> list = mapper.selectByPage((currentPage - 1) * size, size,stuname,stuage);
        int totalSize = mapper.getTotalSize(stuname,stuage);
        bean.setCurrentpage(currentPage);
        bean.setList(list);
        bean.setSize(size);
        bean.setTotalsize(totalSize);
        if (totalSize%size==0){
            bean.setTotalpage(totalSize/size);
        }else {
            bean.setTotalpage(totalSize/size+1);
        }
        session.commit();
        MybatisUtil.closed();
        return bean;
    }



    @Override
    public int addStudent(Student student) {
        SqlSession session = MybatisUtil.getSession();
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        int i = mapper.addStudent(student);
        session.commit();
        MybatisUtil.closed();
        return i;
    }
}
