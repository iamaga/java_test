package com.liu.service;

import com.liu.pojo.Dept;
import com.liu.pojo.Expense;
import com.liu.pojo.Expenseitem;

import java.util.List;

public interface ExpenseService {
    int addExpense(Expense expense, List<Expenseitem> expenseitemList);
    List<Expense> findByNextauditor(String nextauditor);
    List<Expenseitem> findByExpid(Integer expid);
    Expense findExpenseByExpid(Integer expid);
    int updateExpense(Expense expense);
    List<Expense> findAllExpense(String empid);
}
