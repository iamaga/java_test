package com.liu.mapper;

import com.liu.pojo.Dept;

import java.util.List;

public interface DeptMapper {
    int insert(Dept dept);
    List<Dept> findAll();
    int deleteByDeptno(int deptno);
    Dept findBydeptno(int deptno);
    int updateDept(Dept dept);
}
