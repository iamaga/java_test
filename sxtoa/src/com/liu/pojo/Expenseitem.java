package com.liu.pojo;

import java.io.Serializable;

public class Expenseitem implements Serializable{
    private Integer itemid;
    private Integer expid;
    private String type;
    private Double amount;
    private String itemdesc;

    public Expenseitem() {
    }

    public Expenseitem(Integer itemid, Integer expid, String type, Double amount, String itemdesc) {
        this.itemid = itemid;
        this.expid = expid;
        this.type = type;
        this.amount = amount;
        this.itemdesc = itemdesc;
    }

    public Integer getItemid() {
        return itemid;
    }

    public void setItemid(Integer itemid) {
        this.itemid = itemid;
    }

    public Integer getExpid() {
        return expid;
    }

    public void setExpid(Integer expid) {
        this.expid = expid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getItemdesc() {
        return itemdesc;
    }

    public void setItemdesc(String itemdesc) {
        this.itemdesc = itemdesc;
    }
}
