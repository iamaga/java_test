package com.liu.controller;

import com.liu.pojo.Student;
import com.liu.service.StudentService;
import com.liu.service.impl.StudentServiceImpl;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@WebServlet("/fileuploadController")
public class FileuploadController extends HttpServlet {
    private StudentService studentService = new StudentServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        FileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload fileUpload = new ServletFileUpload(factory);
        Student student = new Student();
        try {
            List<FileItem> list = fileUpload.parseRequest(req);
            for (FileItem item:list){
                System.out.println("name"+item.getFieldName()
                +"文件名"+item.getName()
                +"数据大小"+item.getSize()
                +"文件类型"+item.getContentType()
                +"是不是文本表单项"+item.isFormField()
                );
                if (!item.isFormField()){

                    if (item.getSize()>30*1024){
                        req.setAttribute("msg","文件不能大于30KB");
                        req.getRequestDispatcher("studentAdd.jsp").forward(req,resp);
                        return;
                    }
                    File dir = new File(req.getServletContext().getRealPath("/ <td>${student.filename}</td>"));
                    if (!dir.exists()){
                        dir.mkdirs();
                    }
                    //使用UUID处理同名问题
                    String uuid = UUID.randomUUID().toString();
                    String filename = item.getName();
                    String fileType = filename.substring(filename.lastIndexOf("."));
                    String ufilename = uuid+filename+fileType;
                    if (!(".png").equals(fileType)&&!(".gif").equals(fileType)&&!(".jpg").equals(fileType)){
                        req.setAttribute("msg","文件类型只可以是图片");
                        req.getRequestDispatcher("/save.jsp").forward(req,resp);
                        return;
                    }
                    student.setFilename(ufilename);
                    student.setFiletype(item.getContentType());
                    //写入到指定目录
                    item.write(new File(dir,ufilename));
                }else{ //不是文件类型
                    if ("stuname".equals(item.getFieldName())){
                        String stuname = item.getString("utf-8");
                        student.setStuname(stuname);
                    }
                    if ("stugender".equals(item.getFieldName())){
                        String stugender = item.getString("utf-8");
                        student.setStugender(stugender);
                    }
                    if ("stuage".equals(item.getFieldName())){
                        String stuage = item.getString("utf-8");
                        student.setStuage(Integer.parseInt(stuage));
                    }
                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        int i = studentService.addStudent(student);
        resp.sendRedirect("pageBeanController");
    }


}
