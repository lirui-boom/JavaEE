package cn.boom.web.servlet.user;


import cn.boom.domain.MsgBean;
import cn.boom.domain.User;
import cn.boom.service.UserService;
import cn.boom.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/activeServlet")
public class ActiveServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        String code = req.getParameter("code");

        UserService us = new UserServiceImpl();
        if(code == null || us.checkUserByCode(code)==false){
            req.setAttribute("activeMsg","激活失败，请联系管理员");
        }else {

            boolean flag = us.activeUser(code);
            if(!flag){
                req.setAttribute("activeMsg","激活失败，请联系管理员");
            }else {
                req.setAttribute("activeMsg","激活成功，立即登录吧");
            }
        }
        req.getRequestDispatcher("active_ok.jsp").forward(req, resp);

    }
}
