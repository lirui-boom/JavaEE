package cn.hehewocao.Servlet;

import cn.hehewocao.POJO.User;
import cn.hehewocao.Service.UserService;
import cn.hehewocao.Service.UserServiceImp;
import org.apache.commons.beanutils.BeanUtils;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

@WebServlet("/findServlet")
public class FindServlet extends HttpServlet {

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
            UserService userService = new UserServiceImp();
            List<User> users = userService.findByUser(user);
            HttpSession session = req.getSession();
            session.removeAttribute("users");
            session.setAttribute("users",users);
            //转发到list.jsp
            req.getRequestDispatcher("/list.jsp").forward(req, resp);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
