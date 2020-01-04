package com.liu.pojo;

import java.io.Serializable;
import java.util.Date;

public class Payment implements Serializable{
    private Integer pid;
    private String Payempid;
    private Double amount;
    private Date paytime;
    private Integer expid;
    private String empid;
    private String realnamea;//报销人
    private String realnameb;//审批人
    private String expdesc;//报销单描述

    public Payment() {
    }

    public Payment(Integer pid, String payempid, Double amount, Date paytime, Integer expid, String empid) {
        this.pid = pid;
        Payempid = payempid;
        this.amount = amount;
        this.paytime = paytime;
        this.expid = expid;
        this.empid = empid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPayempid() {
        return Payempid;
    }

    public void setPayempid(String payempid) {
        Payempid = payempid;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getPaytime() {
        return paytime;
    }

    public void setPaytime(Date paytime) {
        this.paytime = paytime;
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

    public String getRealnamea() {
        return realnamea;
    }

    public void setRealnamea(String realnamea) {
        this.realnamea = realnamea;
    }

    public String getRealnameb() {
        return realnameb;
    }

    public void setRealnameb(String realnameb) {
        this.realnameb = realnameb;
    }

    public String getExpdesc() {
        return expdesc;
    }

    public void setExpdesc(String expdesc) {
        this.expdesc = expdesc;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "pid=" + pid +
                ", Payempid='" + Payempid + '\'' +
                ", amount=" + amount +
                ", paytime=" + paytime +
                ", expid=" + expid +
                ", empid='" + empid + '\'' +
                ", realnamea='" + realnamea + '\'' +
                ", realnameb='" + realnameb + '\'' +
                ", expdesc='" + expdesc + '\'' +
                '}';
    }
}
