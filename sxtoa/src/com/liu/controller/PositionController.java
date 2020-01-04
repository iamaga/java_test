package com.liu.controller;

import com.google.gson.Gson;
import com.liu.pojo.Position;
import com.liu.service.PositionService;
import com.liu.service.impl.PositionServiceImpl;
import org.springframework.context.ApplicationContext;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/positionController")
public class PositionController extends BaseServlet {
    private  PositionService positionService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext servletContext = config.getServletContext();
        ApplicationContext applicationContext =(ApplicationContext) servletContext.getAttribute("webApplicationContext");
         positionService = (PositionService) applicationContext.getBean("positionService");
    }

    public void addPosition(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        int posid = Integer.parseInt(req.getParameter("posid"));
        String pname = req.getParameter("pname");
        String pdesc = req.getParameter("pdesc");
        Position position = new Position(posid,pname,pdesc);
        int i = positionService.addPosition(position);
        if (i>0){
            resp.sendRedirect("positionController?method=findAllPos");
        }else {
            resp.sendRedirect("positionAdd.jsp");
        }
    }

    public void findAllPos(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
        List<Position> positions = positionService.findAllPos();
        System.out.println(positions);
        req.setAttribute("positions",positions);
        req.getRequestDispatcher("positionList.jsp").forward(req,resp);
    }
    public void findAllPostojson(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
        List<Position> positions = positionService.findAllPos();
        System.out.println(positions);
        Gson gson= new Gson();
        String toJson = gson.toJson(positions);
        resp.getWriter().print(toJson);
    }

    public void findByPosid(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
        int      posid = Integer.parseInt(req.getParameter("posid"));
        Position position = positionService.findByPosid(posid);
        System.out.println(position+"findByPosid");
        req.setAttribute("position",position);
        req.getRequestDispatcher("positionUpdate.jsp").forward(req,resp);
    }

    public void deleteByPosid(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
        int posid = Integer.parseInt(req.getParameter("posid"));
        int i = positionService.deleteByPosid(posid);
        resp.sendRedirect("positionController?method=findAllPos");

    }

    public void updatePosition(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
        int posid = Integer.parseInt(req.getParameter("posid"));
        String pname = req.getParameter("pname");
        String pdesc = req.getParameter("pdesc");
        Position position = new Position(posid,pname,pdesc);
        int i = positionService.updatePosition(position);
        resp.sendRedirect("positionController?method=findAllPos");
    }



}
