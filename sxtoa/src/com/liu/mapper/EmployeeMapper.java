package com.liu.mapper;

import com.liu.pojo.Employee;
import com.liu.pojo.Position;

import java.util.Date;
import java.util.List;

public interface EmployeeMapper {
    int addEmployee(Employee employee);
    List<Employee> findAllEmp();

    int deleteEmpById(String empid);
    Employee findeByEmpId(String empid);
    List<Employee> selectMgrid();
    int updateEmp(Employee employee);
    List<Employee> findBymore(String empid, String deptname, String onduty, Date hiredate);//多条件查询

    Employee findEmpByEmpidAndPwd(String empid,String password);
    List<Employee> findAllMgr();
    int updateEmpByInform (String qq,String phone,String emercontactperson,String empid);
    int updatepassword(String newpassword,String oldpassword,String empid );
}
