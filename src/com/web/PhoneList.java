package com.web;

import com.dao.PhoneInfoDAO;
import com.dao.PhoneInterface;
import com.entity.PhoneInfo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class PhoneList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PhoneInterface phoneInterface=new PhoneInfoDAO();
        List<PhoneInfo> phoneInfos=phoneInterface.listAll();
        req.setAttribute("phoneInfos",phoneInfos);
        req.getRequestDispatcher("/jsp/phone_list.jsp").forward(req,resp);
    }
}
