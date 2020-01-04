package com.liu.service;

import com.liu.pojo.Income;
import com.liu.pojo.NV;

import java.util.List;

public interface IncomeService {
    int addIncome(Income income);
    List<Income> findAllIncome(String startDate,String endDate,String ictype);
    List<NV> findValuesByDate(String startDate, String endDate);
}
