package com.liu.pojo;

public class Dept {
    private Integer deptno;
    private String deptname;
    private String location;

    public Dept() {
    }

    public Dept(Integer deptno, String deptname, String location) {
        this.deptno = deptno;
        this.deptname = deptname;
        this.location = location;
    }

    public Integer getDeptno() {
        return deptno;
    }

    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "deptno=" + deptno +
                ", deptname='" + deptname + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
