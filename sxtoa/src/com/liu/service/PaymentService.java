package com.liu.service;

import com.liu.pojo.NV;
import com.liu.pojo.Payment;

import java.util.List;

public interface PaymentService {
    int addPayment(Payment payment);
    List<Payment> findPaymentByCondition(String startDate, String endDate, String realname);//支持列表
    List<NV> findPaymentByDate(String startDate, String endDate);//支出类型饼状图
}
