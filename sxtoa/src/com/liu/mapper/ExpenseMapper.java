package com.liu.mapper;

import com.liu.pojo.Dept;
import com.liu.pojo.Expense;
import com.liu.pojo.Expenseitem;

import java.util.List;

public interface ExpenseMapper {
    int addExpense(Expense expense);
    List<Expense> findByNextauditor(String nextauditor);
    Expense findExpenseByExpid(Integer expid);
    int updateExpense(Expense expense);
    List<Expense> findAllExpense(String empid);
}
