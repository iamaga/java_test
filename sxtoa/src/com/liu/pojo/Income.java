package com.liu.pojo;

import java.io.Serializable;
import java.util.Date;

public class Income implements Serializable {
    private Integer icid;
    private Integer amount;
    private Date icdate;
    private String ictype;
    private String indesc;
    private String userid;
    private String realname;//真实姓名

    public Income() {
    }

    public Income(Integer icid, Integer amount, Date icdate, String ictype, String indesc, String userid) {
        this.icid = icid;
        this.amount = amount;
        this.icdate = icdate;
        this.ictype = ictype;
        this.indesc = indesc;
        this.userid = userid;
    }

    public Integer getIcid() {
        return icid;
    }

    public void setIcid(Integer icid) {
        this.icid = icid;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Date getIcdate() {
        return icdate;
    }

    public void setIcdate(Date icdate) {
        this.icdate = icdate;
    }

    public String getIctype() {
        return ictype;
    }

    public void setIctype(String ictype) {
        this.ictype = ictype;
    }

    public String getIndesc() {
        return indesc;
    }

    public void setIndesc(String indesc) {
        this.indesc = indesc;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    @Override
    public String toString() {
        return "Income{" +
                "icid=" + icid +
                ", amount=" + amount +
                ", icdate=" + icdate +
                ", ictype='" + ictype + '\'' +
                ", indesc='" + indesc + '\'' +
                ", userid='" + userid + '\'' +
                ", realname='" + realname + '\'' +
                '}';
    }
}
