package com.liu.service.impl;

import com.liu.mapper.PaymentMapper;
import com.liu.pojo.NV;
import com.liu.pojo.Payment;
import com.liu.service.PaymentService;
import com.liu.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class PaymentServiceImpl implements PaymentService {
    @Override
    public int addPayment(Payment payment) {
        SqlSession session = MybatisUtil.getSession();
        PaymentMapper mapper = session.getMapper(PaymentMapper.class);
        int i = mapper.addPayment(payment);
        session.commit();
        MybatisUtil.closed();
        return i;
    }

    @Override
    public List<Payment> findPaymentByCondition(String startDate, String endDate, String realname) {
        SqlSession session = MybatisUtil.getSession();
        PaymentMapper mapper = session.getMapper(PaymentMapper.class);
        List<Payment> payments = mapper.findPaymentByCondition(startDate, endDate, realname);
        session.commit();
        MybatisUtil.closed();
        return payments;
    }

    @Override
    public List<NV> findPaymentByDate(String startDate, String endDate) {
        SqlSession session = MybatisUtil.getSession();
        PaymentMapper mapper = session.getMapper(PaymentMapper.class);
        List<NV> payments = mapper.findPaymentByDate(startDate, endDate);
        session.commit();
        MybatisUtil.closed();
        return payments;
    }
}
