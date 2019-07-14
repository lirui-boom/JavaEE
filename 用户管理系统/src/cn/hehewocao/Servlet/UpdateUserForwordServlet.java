package cn.hehewocao.Servlet;

import cn.hehewocao.POJO.User;
import cn.hehewocao.Service.UserService;
import cn.hehewocao.Service.UserServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateUserForwordServlet")
public class UpdateUserForwordServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        String id  = req.getParameter("beforeUserId");
        UserService us = new UserServiceImp();
        User user = us.findByUserId(id);
        req.setAttribute("beforeUser", user);
        req.getRequestDispatcher("update.jsp").forward(req, resp);
    }
}
