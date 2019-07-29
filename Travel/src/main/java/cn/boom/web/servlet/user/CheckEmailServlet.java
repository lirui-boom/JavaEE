package cn.boom.web.servlet.user;

import cn.boom.service.UserService;
import cn.boom.service.impl.UserServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/checkEmailServlet")
public class CheckEmailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        String email = req.getParameter("email").toLowerCase();

        UserService us = new UserServiceImpl();
        boolean flag = us.checkUserByEmail(email);

        Map<String, Object> msg = new HashMap<String, Object>();
        if(flag){

            msg.put("email_usable", false);
            msg.put("email_msg","该邮箱已被注册");

        }else {

            msg.put("email_usable", true);
            msg.put("email_msg","该邮箱可用");

        }

        ObjectMapper mapper = new ObjectMapper();
        String msg_json = mapper.writeValueAsString(msg);
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().write(msg_json);

    }
}
