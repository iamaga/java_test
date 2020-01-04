package com.liu.pojo;

import java.io.Serializable;
import java.util.Date;

public class Auditing implements Serializable {
    private Integer auditid;
    private Integer expid;
    private String empid;
    private String result;
    private String auditdesc;
    private Date time;
    private String realname;
    private String totalamount;
    private String expdesc;
    private String exptime;




    public Auditing() {
    }

    public Auditing(Integer auditid, Integer expid, String empid, String result, String auditdesc, Date time) {
        this.auditid = auditid;
        this.expid = expid;
        this.empid = empid;
        this.result = result;
        this.auditdesc = auditdesc;
        this.time = time;
    }

    public Integer getAuditid() {
        return auditid;
    }

    public void setAuditid(Integer auditid) {
        this.auditid = auditid;
    }

    public Integer getExpid() {
        return expid;
    }

    public void setExpid(Integer expid) {
        this.expid = expid;
    }

    public String getEmpid() {
        return empid;
    }

    public void setEmpid(String empid) {
        this.empid = empid;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getAuditdesc() {
        return auditdesc;
    }

    public void setAuditdesc(String auditdesc) {
        this.auditdesc = auditdesc;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getTotalamount() {
        return totalamount;
    }

    public void setTotalamount(String totalamount) {
        this.totalamount = totalamount;
    }

    public String getExpdesc() {
        return expdesc;
    }

    public void setExpdesc(String expdesc) {
        this.expdesc = expdesc;
    }

    public String getExptime() {
        return exptime;
    }

    public void setExptime(String exptime) {
        this.exptime = exptime;
    }
}
