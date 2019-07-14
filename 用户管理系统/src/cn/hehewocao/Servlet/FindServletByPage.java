package cn.hehewocao.Servlet;

import cn.hehewocao.POJO.User;
import cn.hehewocao.Service.UserService;
import cn.hehewocao.Service.UserServiceImp;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

import cn.hehewocao.POJO.PageBean;

@WebServlet("/findServletByPage")
public class FindServletByPage extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        String page = req.getParameter("page");
        String rows = req.getParameter("rows");
        Map<String, String[]> parameterMap = req.getParameterMap();
        UserService us = new UserServiceImp();
        PageBean<User> pb = us.findByPage(page, rows, parameterMap);
        req.setAttribute("pageBean", pb);
        req.setAttribute("condition",parameterMap);
        req.getRequestDispatcher("list.jsp").forward(req, resp);

    }
}
