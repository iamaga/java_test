package com.liu.service.impl;

import com.liu.mapper.DeptMapper;
import com.liu.pojo.Dept;
import com.liu.service.DeptService;
import com.liu.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class DeptServiceImpl implements DeptService {
    @Override
    public int insert(Dept dept) {
        SqlSession session = MybatisUtil.getSession();
        DeptMapper mapper = session.getMapper(DeptMapper.class);
        int i = mapper.insert(dept);
        session.commit();
        MybatisUtil.closed();
        return i;
    }

    @Override
    public List<Dept> findAll() {
        SqlSession session = MybatisUtil.getSession();
        DeptMapper mapper = session.getMapper(DeptMapper.class);
        List<Dept> deptList = mapper.findAll();
        session.commit();
        MybatisUtil.closed();
        return deptList;
    }

    @Override
    public int deleteByDeptno(int deptno) {
        SqlSession session = MybatisUtil.getSession();
        DeptMapper mapper = session.getMapper(DeptMapper.class);
        int i = mapper.deleteByDeptno(deptno);
        session.commit();
        MybatisUtil.closed();
        return i;
    }

    @Override
    public Dept findBydeptno(int deptno) {
        SqlSession session = MybatisUtil.getSession();
        DeptMapper mapper = session.getMapper(DeptMapper.class);
        Dept dept = mapper.findBydeptno(deptno);
        session.commit();
        MybatisUtil.closed();
        return dept;
    }

    @Override
    public int updateDept(Dept dept) {
        SqlSession session = MybatisUtil.getSession();
        DeptMapper mapper = session.getMapper(DeptMapper.class);
        int i  = mapper.updateDept(dept);
        session.commit();
        MybatisUtil.closed();
        return i;
    }
}
