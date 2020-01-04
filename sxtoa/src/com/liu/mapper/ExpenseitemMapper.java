package com.liu.mapper;

import com.liu.pojo.Expenseitem;
import com.liu.pojo.NV;

import java.util.List;

public interface ExpenseitemMapper {

    int addItem(Expenseitem expenseitem);
    List<Expenseitem> findByExpid(Integer expid);
    List<NV> findPaymentByDate(String startDate,String endDate);
}
