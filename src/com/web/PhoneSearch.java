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
import java.util.List;

@WebServlet("/phone/search")
public class PhoneSearch extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");

        String condition=req.getParameter("condition");

        PhoneInterface phoneInterface=new PhoneInfoDAO();
        List<PhoneInfo> phoneInfoList=phoneInterface.getPhoneByName(condition);

        req.setAttribute("phoneInfoList",phoneInfoList);

        req.getSession().setAttribute("msg","当前查询条件为：["+condition+"]");

        req.getRequestDispatcher("/jsp/phone_search.jsp").forward(req,resp);
    }
}
