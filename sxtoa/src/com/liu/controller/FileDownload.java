package com.liu.controller;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
@WebServlet("/fileDownload")
public class FileDownload extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String filename = req.getParameter("filename");
        String filetype = req.getParameter("filetype");
        //构建指向文件的File类
        String realPath = req.getServletContext().getRealPath("/upload");
        System.out.println(realPath);
        File file = new File(realPath,filename);
        FileInputStream inputStream = new FileInputStream(file);
        ServletOutputStream outputStream = resp.getOutputStream();
        resp.setContentLength((int)file.length());
        resp.setContentType(filetype);
        /*设置响应头*/
        resp.setHeader("Content-Disposition","attachment;filename="+filename);
        IOUtils.copy(inputStream,outputStream);
    }
}
