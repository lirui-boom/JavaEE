package cn.hehewocao.Servlet;

import cn.hehewocao.POJO.User;
import cn.hehewocao.Service.UserService;
import cn.hehewocao.Service.UserServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.nio.file.attribute.UserPrincipalLookupService;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/listServlet")
public class ListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        UserService us = new UserServiceImp();
        List<User> users = us.findAll();
        HttpSession session = req.getSession();
        session.setAttribute("users", users);
        //转发到list.jsp
        req.getRequestDispatcher("/list.jsp").forward(req,resp);
    }
}
