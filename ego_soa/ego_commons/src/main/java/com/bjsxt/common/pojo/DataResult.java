package com.bjsxt.common.pojo;

import java.io.Serializable;

public class DataResult implements Serializable {
    //    设置状态码
    private Integer status;
    //设置提示消息
    private String msg;
    //    设置携带数据
    private Object data;

    //    空参构造器
    private DataResult(){};

    //    全参构造器
    private DataResult(Integer status,String msg,Object data){
        this.status = status;
        this.msg = msg;
        this.data = data;
    }
//    成功返回

    //无参数
    public static DataResult ok(){
        return DataResult.ok(null,null);
    }
    // msg参数
    public static DataResult ok(String msg){
        return DataResult.ok(msg,null);
    }
    // data参数
    public static DataResult ok(Object data){
        return DataResult.ok(null,data);
    }
    // msg,data双参数
    public static DataResult ok (String msg,Object data){
        return new DataResult(200,msg,data);
    }

//    失败返回

    //无参数
    public static DataResult error(){
        return DataResult.error(null,null);
    }
    // msg参数
    public static DataResult error(String msg){
        return DataResult.error(msg,null);
    }
    // data参数
    public static DataResult error(Object data){
        return DataResult.error(null,data);
    }
    // msg,data双参数
    public static DataResult error (String msg,Object data){
        return new DataResult(500,msg,data);
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}