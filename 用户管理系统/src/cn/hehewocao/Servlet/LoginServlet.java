package cn.hehewocao.Servlet;

import cn.hehewocao.Dao.AdminDao;
import cn.hehewocao.POJO.Admin;
import cn.hehewocao.Service.AdminService;
import cn.hehewocao.Service.AdminServiceImp;
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

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        Admin admin = new Admin();
        Map<String, String[]> parameterMap = req.getParameterMap();
        try {
            BeanUtils.populate(admin,parameterMap);
            AdminService as = new AdminServiceImp();
            admin = as.login(admin);
            if(admin!=null) {
                HttpSession session = req.getSession();
                session.setAttribute("admin", admin);
                resp.sendRedirect(req.getContextPath()+"/findServletByPage");
            }else {
                req.setAttribute("login_msg","用户名或密码错误!");
                req.getRequestDispatcher("/index.jsp").forward(req,resp);
            }

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
