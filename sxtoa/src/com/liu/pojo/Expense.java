package com.liu.pojo;

import java.io.Serializable;
import java.util.Date;

public class Expense implements Serializable{
    private Integer expid;
    private String empid;
    private Double totalamount;
    private Date exptime;
    private String expdesc;
    private String nextauditor;
    private String lastResult;
    private String status;
    private String realname;

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public Expense() {
    }

    public Expense(Integer expid, String empid, Double totalamount, Date exptime, String expdesc, String nextauditor, String lastResult, String status) {
        this.expid = expid;
        this.empid = empid;
        this.totalamount = totalamount;
        this.exptime = exptime;
        this.expdesc = expdesc;
        this.nextauditor = nextauditor;
        this.lastResult = lastResult;
        this.status = status;
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

    public Double getTotalamount() {
        return totalamount;
    }

    public void setTotalamount(Double totalamount) {
        this.totalamount = totalamount;
    }

    public Date getExptime() {
        return exptime;
    }

    public void setExptime(Date exptime) {
        this.exptime = exptime;
    }

    public String getExpdesc() {
        return expdesc;
    }

    public void setExpdesc(String expdesc) {
        this.expdesc = expdesc;
    }

    public String getNextauditor() {
        return nextauditor;
    }

    public void setNextauditor(String nextauditor) {
        this.nextauditor = nextauditor;
    }

    public String getLastResult() {
        return lastResult;
    }

    public void setLastResult(String lastResult) {
        this.lastResult = lastResult;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "expid=" + expid +
                ", empid='" + empid + '\'' +
                ", totalamount='" + totalamount + '\'' +
                ", exptime=" + exptime +
                ", expdesc='" + expdesc + '\'' +
                ", nextauditor='" + nextauditor + '\'' +
                ", lastResult='" + lastResult + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
