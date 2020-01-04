package com.liu.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.liu.mapper.ExpenseMapper;
import com.liu.pojo.Auditing;
import com.liu.pojo.Employee;
import com.liu.pojo.Expense;
import com.liu.pojo.Payment;
import com.liu.service.AuditingService;
import com.liu.service.ExpenseService;
import com.liu.service.PaymentService;
import com.liu.service.impl.AuditingServiceImpl;
import com.liu.service.impl.ExpenseServicImpl;
import com.liu.service.impl.PaymentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet("/auditingController")
public class AuditingController extends BaseServlet {
        AuditingService auditingService = new AuditingServiceImpl();
        ExpenseService expenseService = new ExpenseServicImpl();
        PaymentService paymentService = new PaymentServiceImpl();
    protected void addAudit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String expidStr = req.getParameter("expid");
        int expid = Integer.parseInt(expidStr);
        String result = req.getParameter("result");
        String auditdesc = req.getParameter("auditdesc");
        Date date = new Date();
        Employee employee = (Employee)req.getSession().getAttribute("employee");
        String empid = employee.getEmpid();
        Auditing auditing = new Auditing(0,expid,empid,result,auditdesc,date);
        int i = auditingService.addAudit(auditing);
        Expense expense = expenseService.findExpenseByExpid(expid);

        if (i>0){
            int status = Integer.parseInt(result);
            System.out.println("result"+status);
            Double totalamount = expense.getTotalamount();
            expense.setStatus(result);
            if (result.equals("2")){
                if (totalamount>2000&&employee.getMgrid()!=null){
                    System.out.println(employee.getMgrid());
                        expense.setStatus("0");
                        expense.setNextauditor(employee.getMgrid());
                }else {
                        expense.setStatus("5");
                    Payment payment = new Payment(null,employee.getEmpid(),totalamount,new Date(),expense.getExpid(),expense.getEmpid());
                        paymentService.addPayment(payment);

                }
            }
            expense.setLastResult(auditdesc);
            expenseService.updateExpense(expense);

        }
        resp.getWriter().print(i);
    }

    protected void auditHistory(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer expid = Integer.parseInt(req.getParameter("expid"));
//        System.out.println(expid);
        List<Auditing> auditings = auditingService.findAuditByExpid(expid);
        req.setAttribute("auditings",auditings);
        req.getRequestDispatcher("auditHistory.jsp").forward(req,resp);
    }

    protected void findMyAuditByEmpid(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Employee employee = (Employee)req.getSession().getAttribute("employee");
        String empid = employee.getEmpid();
        List<Auditing> auditings = auditingService.findMyAuditByEmpid(empid);
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd hh:mm:ss").create();
        String toJson = gson.toJson(auditings);
        resp.getWriter().print(toJson);
    }



}
