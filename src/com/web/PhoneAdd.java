package com.web;

import com.dao.PhoneInfoDAO;
import com.dao.PhoneInterface;
import com.entity.PhoneInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

@WebServlet(value = "/phone/add")
public class PhoneAdd extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/jsp/phone_add.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id= Integer.parseInt(req.getParameter("id"));
        String name=req.getParameter("name");
        Double price= Double.parseDouble(req.getParameter("price"));
        String brand=req.getParameter("brand");

        PhoneInfo phoneInfo=new PhoneInfo(id,name,price,brand);

        PhoneInterface phoneInterface=new PhoneInfoDAO();
        phoneInterface.add(phoneInfo);

        resp.sendRedirect("/phone/index");
    }
}
