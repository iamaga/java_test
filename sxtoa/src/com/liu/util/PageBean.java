package com.liu.util;

import org.apache.poi.ss.formula.functions.T;

import java.util.List;

public class PageBean<T> {
    private List<T> list;
    private Integer currentpage;
    private Integer size;
    private Integer totalpage;
    private Integer totalsize;

    public PageBean() {
    }

    public PageBean(List<T> list, Integer currentpage, Integer size, Integer totalpage, Integer totalsize) {
        this.list = list;//数据集合
        this.currentpage = currentpage;//当前页面
        this.size = size;//每页显示条数
        this.totalpage = totalpage;//
        this.totalsize = totalsize;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public Integer getCurrentpage() {
        return currentpage;
    }

    public void setCurrentpage(Integer currentpage) {
        this.currentpage = currentpage;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getTotalpage() {
        return totalpage;
    }

    public void setTotalpage(Integer totalpage) {
        this.totalpage = totalpage;
    }

    public Integer getTotalsize() {
        return totalsize;
    }

    public void setTotalsize(Integer totalsize) {
        this.totalsize = totalsize;
    }
}
