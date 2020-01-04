package com.liu.service.impl;

import com.liu.mapper.IncomeMapper;
import com.liu.pojo.Income;
import com.liu.pojo.NV;
import com.liu.service.IncomeService;
import com.liu.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class IncomeServiceImpl implements IncomeService {
    /**
     * 添加收入
     * @param income
     * @return
     */
    @Override
    public int addIncome(Income income) {
        SqlSession session = MybatisUtil.getSession();
        IncomeMapper mapper = session.getMapper(IncomeMapper.class);
        int i = mapper.addIncome(income);
        session.commit();
        MybatisUtil.closed();
        return i;
    }

    /**
     * 查找所有收入包含真实姓名
     * @return
     */
    @Override
    public List<Income> findAllIncome(String startDate,String endDate,String ictype) {
        SqlSession session = MybatisUtil.getSession();
        IncomeMapper mapper = session.getMapper(IncomeMapper.class);
        List<Income> incomes = mapper.findAllIncome(startDate,endDate,ictype);
        session.commit();
        MybatisUtil.closed();
        return incomes;
    }

    @Override
    public List<NV> findValuesByDate(String startDate, String endDate) {
        SqlSession session = MybatisUtil.getSession();
        IncomeMapper mapper = session.getMapper(IncomeMapper.class);
        List<NV> nvs = mapper.findValuesByDate(startDate,endDate);
        session.commit();
        MybatisUtil.closed();
        return nvs;
    }
}
