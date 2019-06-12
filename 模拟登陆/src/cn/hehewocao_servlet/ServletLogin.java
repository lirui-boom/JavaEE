package cn.hehewocao_servlet;

import cn.hehewocao_user.User;
import cn.hehewocao_user.UserDao;
import org.apache.commons.beanutils.BeanUtils;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/demo1")
public class ServletLogin extends HttpServlet {

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            req.setCharacterEncoding("utf-8");
            resp.setContentType("text/html;charset=UTF-8");
            Map<String, String[]> info = req.getParameterMap();
            User Loginuser = new User();
            try {
                BeanUtils.populate(Loginuser,info);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }

            User user = new User();
            if((user = UserDao.islogin(Loginuser.getUsername(),Loginuser.getPassword())) != null){
                resp.getWriter().write(user.toString());
            }else {
                resp.getWriter().write("登录失败！");
            }



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}


