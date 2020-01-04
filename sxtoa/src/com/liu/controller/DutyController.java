package com.liu.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.liu.pojo.Dept;
import com.liu.pojo.Duty;
import com.liu.pojo.Employee;
import com.liu.service.DeptService;
import com.liu.service.DutyService;
import com.liu.service.impl.DeptServiceImpl;
import com.liu.service.impl.DutyServiceImlp;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet("/dutyController")
public class DutyController extends BaseServlet {
    DutyService dutyService = new DutyServiceImlp();
    DeptService deptService = new DeptServiceImpl();

    public void signInDuty(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       Employee employee =(Employee) req.getSession().getAttribute("employee");
        String empid = employee.getEmpid();
        Date currentDate = new Date();
        java.sql.Date date = new java.sql.Date(currentDate.getTime());
        System.out.println(date);
        String signintime = new SimpleDateFormat("hh:mm:ss").format(currentDate);
        Duty duty = new Duty(0,empid,date,signintime,"00:00:00");
        int i = dutyService.addDuty(duty);
        System.out.println("loginDuty————"+i);
        resp.getWriter().print(i);
    }
    public void signOutDuty(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Employee employee =(Employee) req.getSession().getAttribute("employee");
        String empid = employee.getEmpid();
        Date currentDate = new Date();
        java.sql.Date date = new java.sql.Date(currentDate.getTime());
        System.out.println(date);
        String signouttime = new SimpleDateFormat("hh:mm:ss").format(currentDate);
        Duty duty = new Duty(0,empid,date,null,signouttime);
        int i = dutyService.updateDuty(duty);
        System.out.println("loginDuty————"+i);
        resp.getWriter().print(i);
    }

    public void findDutys(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Duty> dutys = dutyService.findAllDuty();
        System.out.println(dutys);
//        req.setAttribute("depts",depts);
//        req.setAttribute("dutys",dutys);
//
//        req.getRequestDispatcher("dutyList.jsp").forward(req,resp);
        GsonBuilder gsonBuilder = new GsonBuilder().setDateFormat("yyyy-MM-dd");
        System.out.println(dutys);
        Gson gson = gsonBuilder.create();

        String dutyStr = gson.toJson(dutys);
        System.out.println("dutyStr:"+dutyStr);
        resp.getWriter().print(dutyStr);
    }
    public void findDepts(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Dept> depts = deptService.findAll();
        Gson gson =new Gson();
        String deptStr = gson.toJson(depts);

        System.out.println("deptStr:"+deptStr);
        resp.getWriter().print(deptStr);
    }

    public void dutySearch(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String emprid = req.getParameter("emprid");
        String deptno = req.getParameter("deptno");
        String date = req.getParameter("date");
        List<Duty> duties = dutyService.findByMore(emprid, deptno, date);
        GsonBuilder gsonBuilder = new GsonBuilder();
        GsonBuilder builder = gsonBuilder.setDateFormat("yyyy-MM-dd");
        Gson gson = builder.create();
        String s = gson.toJson(duties);
        System.out.println(s);
        resp.getWriter().print(s);
    }

    public void findMyDuty(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Employee employee = (Employee) req.getSession().getAttribute("employee");
        String empid = employee.getEmpid();
        System.out.println(empid);
        List<Duty> duties = dutyService.findByMore(empid, null, null);
        GsonBuilder gsonBuilder = new GsonBuilder().setDateFormat("yyyy-MM-dd");
        Gson gson = gsonBuilder.create();
        String dutyStr = gson.toJson(duties);
        System.out.println("myduty:"+dutyStr);
        resp.getWriter().print(dutyStr);

    }
    public void exportExcel(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String emprid = req.getParameter("emprid");
        String deptno = req.getParameter("deptno");
        String date = req.getParameter("date");
        List<Duty> dutys = dutyService.findByMore(emprid, deptno, date);
        System.out.println("excle"+emprid+deptno+date);
        creatExcel(dutys,resp);

    }

    private static void creatExcel(List<Duty> list, HttpServletResponse resp) {

        SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
        //创建一个excel文件
        HSSFWorkbook workbook = new HSSFWorkbook();
        //创建一个工作表
        HSSFSheet sheet = workbook.createSheet("考勤表");
        CellRangeAddress region = new CellRangeAddress(0, 0, 0, 5);
        sheet.addMergedRegion(region);

        HSSFRow hssfRow = sheet.createRow(0);
        HSSFCell headCell = hssfRow.createCell(0);
        headCell.setCellValue("考勤列表");
        //设置单元格格式居中
        HSSFCellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        headCell.setCellStyle(cellStyle);

        //添加表头行
      hssfRow=  sheet.createRow(1);
        //添加表头内容
        headCell = hssfRow.createCell(0);
        headCell.setCellValue("用户名");
        headCell.setCellStyle(cellStyle);

        headCell = hssfRow.createCell(1);
        headCell.setCellValue("员工姓名");
        headCell.setCellStyle(cellStyle);

        headCell = hssfRow.createCell(2);
        headCell.setCellValue("所属部门");
        headCell.setCellStyle(cellStyle);

        headCell = hssfRow.createCell(3);
        headCell.setCellValue("考勤日期");
        headCell.setCellStyle(cellStyle);

        headCell = hssfRow.createCell(4);
        headCell.setCellValue("签到时间");
        headCell.setCellStyle(cellStyle);

        headCell = hssfRow.createCell(5);
        headCell.setCellValue("签退时间");
        headCell.setCellStyle(cellStyle);
        // 添加数据内容
        for (int i = 0; i < list.size(); i++) {
            hssfRow = sheet.createRow((int) i + 2);
            Duty duty = list.get(i);

            // 创建单元格，并设置值
            HSSFCell cell = hssfRow.createCell(0);
            cell.setCellValue(duty.getEmprid());
            cell.setCellStyle(cellStyle);

            cell = hssfRow.createCell(1);
            cell.setCellValue(duty.getRealname());
            cell.setCellStyle(cellStyle);

            cell = hssfRow.createCell(2);
            cell.setCellValue(duty.getDeptname());
            cell.setCellStyle(cellStyle);

            cell = hssfRow.createCell(3);
            cell.setCellValue(formater.format(duty.getDtdate()));
            cell.setCellStyle(cellStyle);

            cell = hssfRow.createCell(4);
            cell.setCellValue(duty.getSignintime());
            cell.setCellStyle(cellStyle);

            cell = hssfRow.createCell(5);
            cell.setCellValue(duty.getSignouttime());
            cell.setCellStyle(cellStyle);
        }

        // 保存Excel文件
        try {
            /*设置响应内容为excel文件*/
            resp.setContentType("application/vnd.ms-excel");
            /*告知浏览器响应的数据以文件形式接收*/
            resp.setHeader("Content-Disposition","attachment;filename=duty"+formater.format(new Date())+".xls");
            OutputStream outputStream = resp.getOutputStream();
            workbook.write(outputStream);
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
