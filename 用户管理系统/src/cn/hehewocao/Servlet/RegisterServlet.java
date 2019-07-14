package cn.hehewocao.Servlet;

import cn.hehewocao.POJO.User;
import cn.hehewocao.Service.UserService;
import cn.hehewocao.Service.UserServiceImp;
import cn.hehewocao.utils.OverwritePopulate;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        HttpSession session = req.getSession();
        String checkcode = req.getParameter("checkcode");
        System.out.println(checkcode + ":" + (String) session.getAttribute("checkcode"));
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String nickname = req.getParameter("nickname");
        String sex = req.getParameter("sex");
        String birthday = req.getParameter("birthday");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        String address = req.getParameter("address");
        String occupation = req.getParameter("occupation");
        String describe = req.getParameter("describe");
        if ("".equals(username)) {
            username = null;
        }
        if ("".equals(password)) {
            password = null;
        }
        if ("".equals(nickname)) {
            nickname = null;
        }
        if ("".equals(sex)) {
            sex = null;
        }
        if ("".equals(birthday)) {
            birthday = null;
        }
        if ("".equals(phone)) {
            phone = null;
        }
        if ("".equals(email)) {
            email = null;
        }
        if ("".equals(address)) {
            address = null;
        }
        if ("".equals(occupation)) {
            occupation = null;
        }
        if ("".equals(describe)) {
            describe = null;
        }
        User user = new User(0, username, password, nickname, sex, birthday, phone, email, address, occupation, describe);
        Map<String, String[]> parameterMap = req.getParameterMap();
        System.out.println(user);
        if (checkcode==null || !checkcode.equalsIgnoreCase((String) session.getAttribute("checkcode") )) {
            session.removeAttribute("checkcode");//删除验证码，每个验证码只允许使用一次
            req.setAttribute("register_msg", "验证码输入有误！");
            req.setAttribute("register_submit", user);
            req.getRequestDispatcher("/register.jsp").forward(req, resp);
            return;
        } else {
            UserService us = new UserServiceImp();
            us.addUser(user);
            session.removeAttribute("checkcode");
            req.setAttribute("success_msg","恭喜您，账号注册成功，立即登录吧！");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }

    }
}
