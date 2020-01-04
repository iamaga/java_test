package com.liu.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.liu.pojo.Employee;
import com.liu.pojo.Expense;
import com.liu.pojo.Expenseitem;
import com.liu.service.EmployeeService;
import com.liu.service.ExpenseService;
import com.liu.service.impl.EmployeeServicelmpl;
import com.liu.service.impl.ExpenseServicImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet("/expenseController")
public class ExpenseController extends BaseServlet {

    ExpenseService expenseService = new ExpenseServicImpl();

    EmployeeService employeeService = new EmployeeServicelmpl();

    public void findMgr(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Employee employee =(Employee)req.getSession().getAttribute("employee");

        List<Employee> employees = employeeService.findAllMgr();
        Gson gson = new Gson();
        String toJson = gson.toJson(employees);
        resp.getWriter().print(toJson);
    }

    public void addExpense(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        //expid 自增
        String empid = ((Employee) req.getSession().getAttribute("employee")).getEmpid();
        //

//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        String exptime = sdf.format(new Date());
        Date exptime = new Date();
        String expdesc = req.getParameter("desc");
        String deptno = req.getParameter("deptno");
        String lastResult ="未审核";
        String status = "0";

        //处理报销的条目信息
        Double totalamount = 0.0;
        String[] types = req.getParameterValues("type");
        String[] amounts = req.getParameterValues("amount");
        String[] itemdescs = req.getParameterValues("itemdesc");

        List<Expenseitem> list = new ArrayList<Expenseitem>();
        for (int i=0 ;i<types.length;i++) {
            Expenseitem item = new Expenseitem();
            item.setType(types[i]);
            double am = Double.parseDouble(amounts[i]);
            item.setAmount(am);
            item.setItemdesc(itemdescs[i]);
            totalamount+=am;

            list.add(item);
        }
        Expense expense = new Expense(0,empid,totalamount,exptime,expdesc,deptno,lastResult,status);
        System.out.println(expense);

        int i = expenseService.addExpense(expense, list);
        resp.getWriter().print(i);
//        System.out.println(types);
//        System.out.println(amounts);
//        System.out.println(itemdescs);
    }
    public void findByNextAuditor(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String empid = ((Employee) req.getSession().getAttribute("employee")).getEmpid();
        List<Expense> expenses = expenseService.findByNextauditor(empid);
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        String toJson = gson.toJson(expenses);
        System.out.println(toJson);
        resp.getWriter().print(toJson);
    }


    public void findExpenseitems(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer expid = Integer.parseInt(req.getParameter("expid"));
        System.out.println(expid);
        List<Expenseitem> expenseitems = expenseService.findByExpid(expid);
        Gson gson = new Gson();
        String toJson = gson.toJson(expenseitems);
        resp.getWriter().print(toJson);
    }
    public void findAllExpense(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String empid = ((Employee) req.getSession().getAttribute("employee")).getEmpid();
        System.out.println(empid);
        List<Expense> expenses = expenseService.findAllExpense(empid);
        System.out.println(expenses);
        req.setAttribute("expenses",expenses);
        req.getRequestDispatcher("myExpense.jsp").forward(req,resp);
    }

}
