package com.liu.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.liu.pojo.NV;
import com.liu.pojo.Payment;
import com.liu.service.PaymentService;
import com.liu.service.impl.PaymentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/paymentController")
public class PaymentController extends BaseServlet {
    private PaymentService paymentService = new PaymentServiceImpl();
    protected void findPaymentByCondition(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String startDate = req.getParameter("startDate");
        String endDate = req.getParameter("endDate");
        String realname = req.getParameter("realname");

        List<Payment> payments = paymentService.findPaymentByCondition(startDate, endDate, realname);
        System.out.println(payments);
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        resp.getWriter().print(gson.toJson(payments));

    }

    protected void findPaymentByDate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String startDate = req.getParameter("startDate");
        String endDate = req.getParameter("endDate");
        List<NV> nvs = paymentService.findPaymentByDate(startDate, endDate);
        List<String> names= new ArrayList<String>();
        for (NV nv:nvs){
            names.add(nv.getName());
        }
        List info= new ArrayList();
        info.add(names);
        info.add(nvs);
        resp.getWriter().print(new Gson().toJson(info));
    }
}
