package com.liu.service.impl;

import com.liu.mapper.ExpenseMapper;
import com.liu.mapper.ExpenseitemMapper;
import com.liu.pojo.Expense;
import com.liu.pojo.Expenseitem;
import com.liu.service.ExpenseService;
import com.liu.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class ExpenseServicImpl implements ExpenseService{
    @Override
    public int addExpense(Expense expense, List<Expenseitem> expenseitemList) {
        SqlSession session = MybatisUtil.getSession();
        ExpenseMapper expenseMapper = session.getMapper(ExpenseMapper.class);
        ExpenseitemMapper expenseitemMapper = session.getMapper(ExpenseitemMapper.class);
        int i = expenseMapper.addExpense(expense);
        for (Expenseitem item:expenseitemList){
            item.setExpid(expense.getExpid());
            expenseitemMapper.addItem(item);
        }
        session.commit();
        MybatisUtil.closed();
        return i;
    }

    @Override
    public List<Expense> findByNextauditor(String nextauditor) {
        SqlSession session = MybatisUtil.getSession();
        ExpenseMapper mapper = session.getMapper(ExpenseMapper.class);
        List<Expense> byNextauditor = mapper.findByNextauditor(nextauditor);
        session.commit();
        MybatisUtil.closed();
        return byNextauditor;
    }

    @Override
    public List<Expenseitem> findByExpid(Integer expid) {
        SqlSession session = MybatisUtil.getSession();
        ExpenseitemMapper mapper = session.getMapper(ExpenseitemMapper.class);
        List<Expenseitem> expenseitems = mapper.findByExpid(expid);
        session.commit();
        MybatisUtil.closed();
        return expenseitems;
    }

    @Override
    public Expense findExpenseByExpid(Integer expid) {
        SqlSession session = MybatisUtil.getSession();
        ExpenseMapper mapper = session.getMapper(ExpenseMapper.class);
        Expense expense = mapper.findExpenseByExpid(expid);
        session.commit();
        MybatisUtil.closed();
        return expense;
    }

    @Override
    public int updateExpense(Expense expense) {
        SqlSession session = MybatisUtil.getSession();
        ExpenseMapper mapper = session.getMapper(ExpenseMapper.class);
        int i = mapper.updateExpense(expense);
        session.commit();
        MybatisUtil.closed();
        return i;
    }

    @Override
    public List<Expense> findAllExpense(String empid) {
        SqlSession session = MybatisUtil.getSession();
        ExpenseMapper mapper = session.getMapper(ExpenseMapper.class);
        List<Expense> allExpense = mapper.findAllExpense( empid);
        session.commit();
        MybatisUtil.closed();
        return allExpense;
    }
}
