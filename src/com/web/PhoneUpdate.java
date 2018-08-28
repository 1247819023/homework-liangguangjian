package com.web;

import com.dao.PhoneInfoDAO;
import com.dao.PhoneInterface;
import com.entity.PhoneInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/phone/update")
public class PhoneUpdate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id= Integer.parseInt(req.getParameter("id"));
        PhoneInterface phoneInterface=new PhoneInfoDAO();
        PhoneInfo phoneInfo=phoneInterface.getPhoneById(id);

        req.setAttribute("phoneInfo",phoneInfo);
        req.getRequestDispatcher("/jsp/phone_update.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        Double price = Double.parseDouble(req.getParameter("price"));
        String brand = req.getParameter("brand");

        PhoneInfo book = new PhoneInfo(id, name, price, brand);

        PhoneInterface phoneInterface = new PhoneInfoDAO();
        phoneInterface.update(book);

        HttpSession session = req.getSession();
        session.setAttribute("msg", "更新成功！");

        resp.sendRedirect("/phone/detail?id=" + id);
    }
}
