package cn.hehewocao.Servlet;

import cn.hehewocao.POJO.Admin;
import cn.hehewocao.POJO.User;
import cn.hehewocao.Service.AdminService;
import cn.hehewocao.Service.AdminServiceImp;
import cn.hehewocao.Service.UserService;
import cn.hehewocao.Service.UserServiceImp;
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

@WebServlet("/userLoginServlet")
public class UserLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        User user = new User();
        Map<String, String[]> parameterMap = req.getParameterMap();
        try {
            BeanUtils.populate(user,parameterMap);
            UserService as = new UserServiceImp();
            user = as.login(user);
            if(user!=null) {
                HttpSession session = req.getSession();
                session.setAttribute("User", user);
                resp.sendRedirect(req.getContextPath()+"/helloword.jsp");
            }else {
                req.setAttribute("login_msg","用户名或密码错误!");
                req.getRequestDispatcher("/login.jsp").forward(req,resp);
            }

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
