package com.liu.controller;

import com.google.gson.Gson;
import com.liu.pojo.Dept;
import com.liu.service.DeptService;
import com.liu.service.impl.DeptServiceImpl;
import org.springframework.context.ApplicationContext;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

@WebServlet("/deptController")
public class DeptController extends BaseServlet {
    private  DeptService deptService;

    public DeptService getDeptService() {
        return deptService;
    }

    public void setDeptService(DeptService deptService) {
        this.deptService = deptService;
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext servletContext = config.getServletContext();
        ApplicationContext webApplicationContext = (ApplicationContext)servletContext.getAttribute("webApplicationContext");
        deptService = webApplicationContext.getBean("deptService", DeptService.class);
    }



    private void updateDept(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        int deptno = Integer.parseInt(req.getParameter("deptno"));
        String deptname = req.getParameter("deptname");
        String location = req.getParameter("location");
        Dept dept = new Dept(deptno,deptname,location);

        int i = deptService.updateDept(dept);
        resp.sendRedirect("deptController?method=findAllDept");
    }


    private void findBydeptno(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        int deptno = Integer.parseInt(req.getParameter("deptno")) ;
        System.out.println(deptno);

        Dept dept = deptService.findBydeptno(deptno);
        req.setAttribute("dept",dept);
        req.getRequestDispatcher("deptUpdate.jsp").forward(req,resp);

    }



    private void deleteDept(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        int deptno = Integer.parseInt(req.getParameter("deptno")) ;
        System.out.println(deptno);

        int i = deptService.deleteByDeptno(deptno);
        resp.sendRedirect("deptController?method=findAllDept");
    }


    private void findAllDept(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {

        List<Dept> depts = deptService.findAll();
        req.setAttribute("depts",depts);
        req.getRequestDispatcher("deptList.jsp").forward(req,resp);
    }
    private void findAllDeptJson(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {

        List<Dept> depts = deptService.findAll();
        Gson gson = new Gson();
        String toJson = gson.toJson(depts);
        resp.getWriter().print(toJson);
    }

    private void deptAdd(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {

        int deptno = Integer.parseInt(req.getParameter("deptno"));
        String deptname = req.getParameter("deptname");
        String location = req.getParameter("location");
        Dept dept = new Dept(deptno,deptname,location);

        int insert = deptService.insert(dept);
        if (insert>0){
            resp.sendRedirect("deptController?method=findAllDept");
        }else {
            resp.sendRedirect("deptAdd.html");
        }
    }


}
