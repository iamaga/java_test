package com.liu.controller;

import com.liu.pojo.Expense;
import com.liu.pojo.Student;
import com.liu.service.impl.StudentServiceImpl;
import com.liu.util.PageBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/pageBeanController")
public class PageBeanController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String stuname = req.getParameter("stuname");
        String stuage = req.getParameter("stuage");
        StudentServiceImpl studentService = new StudentServiceImpl();
        Integer currentpage=1;
        Integer size = 5;
        try {
            currentpage = Integer.parseInt(req.getParameter("currentpage"));
            size = Integer.parseInt(req.getParameter("size"));
            System.out.println(currentpage);
            System.out.println(size);
        }catch (Exception e){

        }

        PageBean<Student> bean = studentService.selectByPage(currentpage, size,stuname,stuage);
        if (bean.getTotalsize()==0){
            bean.setTotalpage(1);

        }
        req.setAttribute("stuname",stuname);
        req.setAttribute("stuage",stuage);
        req.setAttribute("bean",bean);
        req.getRequestDispatcher("showStudent.jsp").forward(req,resp);


    }
}
