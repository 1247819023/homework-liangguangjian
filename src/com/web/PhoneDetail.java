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

@WebServlet(value = "/phone/detail")
public class PhoneDetail extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id= Integer.parseInt(req.getParameter("id"));
        PhoneInterface phoneInterface=new PhoneInfoDAO();
        PhoneInfo phoneInfo=phoneInterface.getPhoneById(id);

        req.setAttribute("phoneInfo",phoneInfo);
        req.getRequestDispatcher("/jsp/phone_detail.jsp").forward(req,resp);
    }
}
