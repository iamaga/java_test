package com.liu.pojo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Duty {
    private Integer dtid;
    private String emprid;
    private Date dtdate;
    private String signintime;
    private String signouttime;
    private String realname;
    private String deptname;

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    public Duty() {
    }

    public Duty(Integer dtid, String emprid, Date dtdate, String signintime, String signouttime) {
        this.dtid = dtid;
        this.emprid = emprid;
        this.dtdate = dtdate;
        this.signintime = signintime;
        this.signouttime = signouttime;
    }

    public Integer getDtid() {
        return dtid;
    }

    public void setDtid(Integer dtid) {
        this.dtid = dtid;
    }

    public String getEmprid() {
        return emprid;
    }

    public void setEmprid(String emprid) {
        this.emprid = emprid;
    }

    public Date getDtdate() {
        return dtdate;
    }


    public void setDtdate(Date dtdate) {
        this.dtdate = dtdate;
    }

    public String getSignintime() {
        return signintime;
    }

    public void setSignintime(String signintime) {
        this.signintime = signintime;
    }

    public String getSignouttime() {
        return signouttime;
    }

    public void setSignouttime(String signouttime) {
        this.signouttime = signouttime;
    }

    @Override
    public String toString() {
        return "Duty{" +
                "dtid=" + dtid +
                ", emprid='" + emprid + '\'' +
                ", dtdate=" + dtdate +
                ", signintime='" + signintime + '\'' +
                ", signouttime='" + signouttime + '\'' +
                ", realname='" + realname + '\'' +
                ", deptname='" + deptname + '\'' +
                '}';
    }
}
