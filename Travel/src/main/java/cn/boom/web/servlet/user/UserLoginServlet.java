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

@WebServlet("/userLoginServlet")
public class UserLoginServlet extends HttpServlet {
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
        if (usercheckcode == null || realcheckcode == null || !realcheckcode.equalsIgnoreCase(usercheckcode)) {
                msgBean.setFlag(false);
                msgBean.setErrorMsg("验证码输入有误");
                String msg_json = mapper.writeValueAsString(msgBean);
                resp.getWriter().write(msg_json);
                return;
        }

        UserService us = new UserServiceImpl();
        User user = new User();
        Map<String, String[]> parameterMap = req.getParameterMap();
        try {
            BeanUtils.populate(user, parameterMap);
            user.setEmail(user.getEmail().toLowerCase());//用户名转换为小写

            if(us.findUser(user) == null){
                //用户名或密码错误
                msgBean.setFlag(false);
                msgBean.setErrorMsg("用户名或密码输入有误");
            }else if (us.isActive(user) == false){
                //用户未激活
                msgBean.setFlag(false);
                msgBean.setErrorMsg("该用户还没有被激活，请先激活再登录");
            }else if ((user = us.findUser(user)) != null){
                //登陆成功
                msgBean.setFlag(true);
                msgBean.setObject(mapper.writeValueAsString(user));
                msgBean.setErrorMsg("");
                req.getSession().setAttribute("user",user);
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
