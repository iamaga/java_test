package com.liu.pojo;

import java.util.Date;

public class Employee {
    private String empid;
    private String password;
    private int deptno;
    private int posid;
    private String mgrid;
    private String realname;
    private String sex;
    private Date birthdate;
    private Date hiredate;
    private Date leavedate;
    private int onduty;//是否在职
    private int emptype;//员工类型
    private String phone;
    private String qq;
    private String emercontactperson;//紧急联系人信息
    private String idcard;
    private String deptname;//部门名
    private String pname;//岗位名

    public Employee() {
    }

    public Employee(String empid, String password, int deptno, int posid, String mgrid, String realname, String sex, Date birthdate, Date hiredate, Date leavedate, int onduty, int emptype, String phone, String qq, String emercontactperson, String idcard) {
        this.empid = empid;
        this.password = password;
        this.deptno = deptno;
        this.posid = posid;
        this.mgrid = mgrid;
        this.realname = realname;
        this.sex = sex;
        this.birthdate = birthdate;
        this.hiredate = hiredate;
        this.leavedate = leavedate;
        this.onduty = onduty;
        this.emptype = emptype;
        this.phone = phone;
        this.qq = qq;
        this.emercontactperson = emercontactperson;
        this.idcard = idcard;
    }

    public String getEmpid() {
        String a= new String("a");
        String b="a";
        String c = a;
        return empid;
    }

    public void setEmpid(String empid) {
        this.empid = empid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getDeptno() {
        return deptno;
    }

    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }

    public int getPosid() {
        return posid;
    }

    public void setPosid(int posid) {
        this.posid = posid;
    }

    public String getMgrid() {
        return mgrid;
    }

    public void setMgrid(String mgrid) {
        this.mgrid = mgrid;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public Date getLeavedate() {
        return leavedate;
    }

    public void setLeavedate(Date leavedate) {
        this.leavedate = leavedate;
    }

    public int getOnduty() {
        return onduty;
    }

    public void setOnduty(int onduty) {
        this.onduty = onduty;
    }

    public int getEmptype() {
        return emptype;
    }

    public void setEmptype(int emptype) {
        this.emptype = emptype;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getEmercontactperson() {
        return emercontactperson;
    }

    public void setEmercontactperson(String emercontactperson) {
        this.emercontactperson = emercontactperson;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empid='" + empid + '\'' +
                ", password='" + password + '\'' +
                ", deptno=" + deptno +
                ", posid=" + posid +
                ", mgrid='" + mgrid + '\'' +
                ", realname='" + realname + '\'' +
                ", sex='" + sex + '\'' +
                ", birthdate=" + birthdate +
                ", hiredate=" + hiredate +
                ", leavedate=" + leavedate +
                ", onduty=" + onduty +
                ", emptype=" + emptype +
                ", phone='" + phone + '\'' +
                ", qq='" + qq + '\'' +
                ", emercontactperson='" + emercontactperson + '\'' +
                ", idcard='" + idcard + '\'' +
                ", deptname='" + deptname + '\'' +
                ", pname='" + pname + '\'' +
                '}';
    }
}
