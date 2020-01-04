package com.liu.controller;

import com.google.gson.Gson;
import com.liu.pojo.Dept;
import com.liu.pojo.Employee;
import com.liu.pojo.Position;
import com.liu.service.DeptService;
import com.liu.service.EmployeeService;
import com.liu.service.PositionService;
import com.liu.service.impl.DeptServiceImpl;
import com.liu.service.impl.EmployeeServicelmpl;
import com.liu.service.impl.PositionServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet("/employeeController")
public class EmployeeController extends BaseServlet {
    EmployeeService employeeService = new EmployeeServicelmpl();
    DeptService deptService = new DeptServiceImpl();
    PositionService positionService = new PositionServiceImpl();



    public void findeByEmpId(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String empid = req.getParameter("empid");
//        System.out.println(empid);
        Employee employee = employeeService.findeByEmpId(empid);

        System.out.println(employee);
        List<Dept> depts = deptService.findAll();
        List<Position> positions = positionService.findAllPos();
        List<Employee> empmgr = employeeService.selectMgrid();
        req.setAttribute("empmgr",empmgr);
        req.setAttribute("depts",depts);
        req.setAttribute("positions",positions);
        System.out.println("positions--------"+positions);
        req.setAttribute("employee",employee);
        req.setAttribute("emercontactperson",employee.getEmercontactperson());
        req.getRequestDispatcher("empUpdate.jsp").forward(req,resp);


    }
    public void deleteEmpById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String empid = req.getParameter("empid");
        int i = employeeService.deleteEmpById(empid);

            resp.sendRedirect("employeeController?method=findAllEmp");


    }
    public void findAllEmp(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Employee> employees = employeeService.findAllEmp();
        List<Dept> depts = deptService.findAll();
        req.setAttribute("depts",depts);
        req.setAttribute("employees",employees);
        req.getRequestDispatcher("empList.jsp").forward(req,resp);
    }


    public void addEmployee(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String empid = req.getParameter("empid");
        String password = req.getParameter("password");
        int deptno = Integer.parseInt(req.getParameter("deptno"));
        int posid = Integer.parseInt(req.getParameter("posid"));
        String mgrid = req.getParameter("mgrid");
        String realname = req.getParameter("realname");
        String sex = req.getParameter("sex");
        java.sql.Date birthdate  = java.sql.Date.valueOf(req.getParameter("birthdate"));
        java.sql.Date hiredate =java.sql.Date.valueOf(req.getParameter("hiredate"));
        java.sql.Date leavedate = java.sql.Date.valueOf(req.getParameter("leavedate"));
        int onduty = Integer.parseInt(req.getParameter("onduty"));
        int emptype = Integer.parseInt(req.getParameter("emptype"));
        String phone = req.getParameter("phone");
        String qq = req.getParameter("qq");
        String emercontactperson = req.getParameter("emercontactperson");
        String idcard = req.getParameter("idcard");
        System.out.println();
        Employee employee = new Employee(empid,password,deptno,posid,mgrid,realname,sex,birthdate,hiredate,leavedate,onduty,emptype,phone,qq,emercontactperson,idcard);
        int i = employeeService.addEmployee(employee);
        if (i>0){
            resp.sendRedirect("employeeController?method=findAllEmp");
        }else {
            resp.sendRedirect("empAdd.html");
        }
    }


    public void updateEmployee(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String empid = req.getParameter("empid");
        String password = req.getParameter("password");
        int deptno = Integer.parseInt(req.getParameter("deptno"));
        int posid = Integer.parseInt(req.getParameter("posid"));
        String mgrid = req.getParameter("mgrid");
        String realname = req.getParameter("realname");
        String sex = req.getParameter("sex");
        java.sql.Date birthdate  = java.sql.Date.valueOf(req.getParameter("birthdate"));
        java.sql.Date hiredate =java.sql.Date.valueOf(req.getParameter("hiredate"));
        java.sql.Date leavedate = java.sql.Date.valueOf(req.getParameter("leavedate"));
        int onduty = Integer.parseInt(req.getParameter("onduty"));
        int emptype = Integer.parseInt(req.getParameter("emptype"));
        String phone = req.getParameter("phone");
        String qq = req.getParameter("qq");
        String emercontactperson = req.getParameter("emercontactperson");
        String idcard = req.getParameter("idcard");
        System.out.println();
        Employee employee = new Employee(empid,password,deptno,posid,mgrid,realname,sex,birthdate,hiredate,leavedate,onduty,emptype,phone,qq,emercontactperson,idcard);
        int i = employeeService.updateEmp(employee);
        if (i>0){
            resp.sendRedirect("employeeController?method=findAllEmp");
        }
    }

    public void findEmpBymore(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String empid = req.getParameter("empid");
        String deptno = req.getParameter("deptno");
        String  onduty = req.getParameter("onduty");
        Date date = null;
        try {
            date = Date.valueOf(req.getParameter("hiredate"));
        }catch (Exception e){

        }

        req.setAttribute("empid",empid);
        req.setAttribute("deptno",deptno);
        req.setAttribute("onduty",onduty);
        req.setAttribute("hiredate",req.getParameter("hiredate"));
        System.out.println("查询！！！empid="+empid+"deptname="+deptno+"onduty="+onduty+"date="+date);
        List<Employee> employees = employeeService.findBymore(empid, deptno, onduty, date);
        List<Dept> depts = deptService.findAll();
        req.setAttribute("depts",depts);
        req.setAttribute("employees",employees);
        req.getRequestDispatcher("empList.jsp").forward(req,resp);
    }

    public void loginCheck(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String empid = req.getParameter("empid");
        String password = req.getParameter("password");
        String yzm = req.getParameter("yzm");
        String true_yzm = (String)req.getSession().getAttribute("randStr");
//        if (yzm!=null){
//            if (!yzm.equals(req.getSession().getAttribute("randStr"))){
//                req.getSession().setAttribute("msg","验证码有误");
//                resp.sendRedirect("login.jsp");
//                return;
//            }
            Employee employee = employeeService.findEmpByEmpidAndPwd(empid, password);
            if (null!=employee){
                req.getSession().setAttribute("employee",employee);

                req.getRequestDispatcher("main.html").forward(req,resp);
            }else {
                resp.sendRedirect("login.jsp");
            }
//        }else {
//            req.getSession().setAttribute("msg","验证码不能为空");
//            resp.sendRedirect("login.jsp");
//            return;
//        }

    }

    public void loginout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();//清除session
        resp.sendRedirect("login.jsp");
    }

    public void findAllmgr(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Employee> mgrs = employeeService.findAllMgr();
        Gson gson = new Gson();
        String toJson = gson.toJson(mgrs);
        resp.getWriter().print(toJson);
    }
    public void updateEmpByInform(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Employee employee = (Employee) req.getSession().getAttribute("employee");
        String qq = req.getParameter("qq");
        String phone = req.getParameter("phone");
        String emercontactperson = req.getParameter("emercontactperson");
        int i = employeeService.updateEmpByInform(qq, phone, emercontactperson, employee.getEmpid());
        resp.getWriter().print(i);
    }
    public void changePWD(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String newpassword = req.getParameter("newpassword");
        String oldpassword = req.getParameter("oldpassword");
        Employee employee =(Employee)req.getSession().getAttribute("employee");
        int i = employeeService.updatepassword(newpassword, oldpassword, employee.getEmpid());
        resp.getWriter().print(i);
    }

    }
