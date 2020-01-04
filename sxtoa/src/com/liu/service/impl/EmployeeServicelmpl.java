package com.liu.service.impl;

import com.liu.mapper.EmployeeMapper;
import com.liu.pojo.Employee;
import com.liu.pojo.Position;
import com.liu.service.EmployeeService;
import com.liu.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.Date;
import java.util.List;

public class EmployeeServicelmpl implements EmployeeService {

    @Override
    public int addEmployee(Employee employee) {
        SqlSession session = MybatisUtil.getSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        int i = mapper.addEmployee(employee);
        session.commit();
        MybatisUtil.closed();
        return i;
    }

    @Override
    public List<Employee> findAllEmp() {
        SqlSession session = MybatisUtil.getSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        List<Employee> allEmp = mapper.findAllEmp();
        session.commit();
        MybatisUtil.closed();
        return allEmp;
    }

    @Override
    public int deleteEmpById(String empid) {
        SqlSession session = MybatisUtil.getSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        int i = mapper.deleteEmpById(empid);
        session.commit();
        MybatisUtil.closed();
        return i;
    }

    @Override
    public Employee findeByEmpId(String empid) {
        SqlSession session = MybatisUtil.getSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        Employee employee = mapper.findeByEmpId(empid);
        session.commit();
        MybatisUtil.closed();
        return employee;
    }

    @Override
    public List<Employee> selectMgrid() {
        SqlSession session = MybatisUtil.getSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        List<Employee> allMgr = mapper.selectMgrid();
        session.commit();
        MybatisUtil.closed();
        return allMgr;
    }

    @Override
    public int updateEmp(Employee employee) {
        SqlSession session = MybatisUtil.getSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        int i = mapper.updateEmp(employee);
        session.commit();
        MybatisUtil.closed();
        return i;
    }

    @Override
    public  List<Employee> findBymore(String empid, String deptname, String onduty, Date hiredate) {
        SqlSession session = MybatisUtil.getSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        List<Employee> employees = mapper.findBymore(empid,deptname,onduty,hiredate);
        session.commit();
        MybatisUtil.closed();
        return employees;
    }

    @Override
    public Employee findEmpByEmpidAndPwd(String empid, String password) {
        SqlSession session = MybatisUtil.getSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        Employee employee = mapper.findEmpByEmpidAndPwd(empid,password);
        session.commit();
        MybatisUtil.closed();
        return employee;
    }
    @Override
    public List<Employee> findAllMgr() {
        SqlSession session = MybatisUtil.getSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        List<Employee> employees = mapper.findAllMgr();
        session.commit();
        MybatisUtil.closed();
        return employees;
    }

    @Override
    public int updateEmpByInform(String qq, String phone, String emercontactperson,String empid) {
        SqlSession session = MybatisUtil.getSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        int i = mapper.updateEmpByInform(qq, phone, emercontactperson,empid);
        session.commit();
        MybatisUtil.closed();
        return i;
    }

    @Override
    public int updatepassword(String newpassword, String oldpassword, String empid) {
        SqlSession session = MybatisUtil.getSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        int i = mapper.updatepassword(newpassword,oldpassword,empid);
        session.commit();
        MybatisUtil.closed();
        return i;
    }
}
