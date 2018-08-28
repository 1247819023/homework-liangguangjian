package com.web;

import com.dao.PhoneInfoDAO;
import com.dao.PhoneInterface;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/phone/del")
public class PhoneDel extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id= Integer.parseInt(req.getParameter("id"));
        PhoneInterface phoneInterface=new PhoneInfoDAO();
        String msg=null;

        if(phoneInterface.delete(id)){
            msg="删除失败";
        }else {
            msg="删除成功";
        }

        req.getSession().setAttribute("msg",msg);
        resp.sendRedirect("/phone/index");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String [] ids=req.getParameterValues("id");
        PhoneInterface phoneInterface=new PhoneInfoDAO();

        for (String id : ids) {
            phoneInterface.delete(Integer.parseInt(id));
        }

        resp.sendRedirect("/phone/index");
    }
}
