package cn.boom.web.servlet.user;

import cn.boom.domain.MsgBean;
import cn.boom.domain.User;
import cn.boom.service.UserService;
import cn.boom.service.impl.UserServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/registerUserServlet")
public class RegisterUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=utf-8");
        //验证验证码输入
        String realcheckcode = (String) req.getSession().getAttribute("checkcode");
        String usercheckcode = req.getParameter("checkcode");
        req.getSession().removeAttribute("checkcode");

        ObjectMapper mapper = new ObjectMapper();
        MsgBean msgBean = new MsgBean();
        if (usercheckcode == null || !realcheckcode.equalsIgnoreCase(usercheckcode)) {

            msgBean.setFlag(false);
            msgBean.setErrorMsg("验证码输入有误");
            String msg_json = mapper.writeValueAsString(msgBean);
            resp.getWriter().write(msg_json);
            return;
        }

        //注册用户
        Map<String, String[]> parameterMap = req.getParameterMap();
        User user = new User();

        try {
            BeanUtils.populate(user, parameterMap);
            UserService us = new UserServiceImpl();
            boolean flag = us.addUser(user);

            if (flag) {//注册成功
                msgBean.setFlag(true);
                msgBean.setErrorMsg("");

            } else {
                msgBean.setFlag(false);
                msgBean.setErrorMsg("账号注册失败！请联系管理员....");

            }
            String msg_json = mapper.writeValueAsString(msgBean);
            resp.getWriter().write(msg_json);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
