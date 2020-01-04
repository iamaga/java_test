package com.liu.mapper;

import com.liu.pojo.Income;
import com.liu.pojo.NV;

import java.util.List;

public interface IncomeMapper {
    int addIncome(Income income);
    List<Income> findAllIncome(String startDate,String endDate,String ictype);
    List<NV> findValuesByDate(String startDate,String endDate);
}
