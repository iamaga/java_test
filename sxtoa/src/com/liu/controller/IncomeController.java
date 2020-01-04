package com.liu.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.liu.pojo.Employee;
import com.liu.pojo.Income;
import com.liu.pojo.NV;
import com.liu.service.IncomeService;
import com.liu.service.impl.IncomeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet("/incomeController")
public class IncomeController extends BaseServlet {
    private IncomeService incomeService = new IncomeServiceImpl();

    protected void addIncome(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer amount = Integer.parseInt(req.getParameter("amount"));
        String ictype = req.getParameter("ictype");
        String date = req.getParameter("icdate");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date icdate = null;
        try {
             icdate = sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String indesc = req.getParameter("indesc");
        Employee employee =(Employee)req.getSession().getAttribute("employee");
        Income income = new Income(null,amount,icdate,ictype,indesc,employee.getEmpid());
        System.out.println(income);
        int i = incomeService.addIncome(income);
        resp.sendRedirect("incomeList.html");

    }

    protected void findIncome(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ictype = req.getParameter("ictype");
        String startDate = req.getParameter("startDate");
        String endDate = req.getParameter("endDate");
        List<Income> incomes = incomeService.findAllIncome(startDate, endDate, ictype);
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        String toJson = gson.toJson(incomes);
        resp.getWriter().print(toJson);

    }
    protected void findDatasBydate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String startDate = req.getParameter("startDate");
        String endDate = req.getParameter("endDate");
        List<NV> nvs = incomeService.findValuesByDate(startDate, endDate);
        List<String> names = new ArrayList<String>();
        List<String> values = new ArrayList<String>();
        for (NV nv : nvs){
            names.add(nv.getName());
            values.add(nv.getValue());
        }

        List info = new ArrayList();
        info.add(names);
        info.add(values);

        resp.getWriter().print(new Gson().toJson(info));
    }
}
