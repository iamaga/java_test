package com.liu.mapper;

import com.liu.pojo.NV;
import com.liu.pojo.Payment;

import java.util.List;

public interface PaymentMapper {
    int addPayment(Payment payment);
    List<Payment> findPaymentByCondition(String startDate,String endDate,String realname);
    List<NV> findPaymentByDate(String startDate, String endDate);
}
