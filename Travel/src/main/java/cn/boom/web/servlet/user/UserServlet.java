package cn.boom.web.servlet.user;

import cn.boom.domain.MsgBean;
import cn.boom.domain.User;
import cn.boom.service.UserService;
import cn.boom.service.impl.UserServiceImpl;
import cn.boom.utils.CaptchaUtil;
import cn.boom.web.servlet.BaseServlet;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.beanutils.BeanUtils;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/user/*")
public class UserServlet extends BaseServlet {

    private UserService us = new UserServiceImpl();

    /**
     * 1.用户登录功能
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

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


        User user = new User();
        Map<String, String[]> parameterMap = req.getParameterMap();
        try {
            BeanUtils.populate(user, parameterMap);
            user.setEmail(user.getEmail().toLowerCase());//用户名转换为小写

            if (us.findUser(user) == null) {
                //用户名或密码错误
                msgBean.setFlag(false);
                msgBean.setErrorMsg("用户名或密码输入有误");
            } else if (us.isActive(user) == false) {
                //用户未激活
                msgBean.setFlag(false);
                msgBean.setErrorMsg("该用户还没有被激活，请先激活再登录");
            } else if ((user = us.findUser(user)) != null) {
                //登陆成功
                msgBean.setFlag(true);
                msgBean.setObject(mapper.writeValueAsString(user));
                msgBean.setErrorMsg("");
                req.getSession().setAttribute("user", user);
            }

            String msg_json = mapper.writeValueAsString(msgBean);
            resp.getWriter().write(msg_json);

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }


    /**
     * 2.用户注册功能
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

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

    /**
     * 3.生成并发送验证码功能
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void checkCodeImage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");

        CaptchaUtil instance = CaptchaUtil.Instance();
        BufferedImage image = instance.getImage();
        String checkcode = instance.getString();

        HttpSession session = req.getSession();
        session.removeAttribute("checkcode");
        session.setAttribute("checkcode", checkcode);

        ImageIO.write(image, "jpg", resp.getOutputStream());


    }

    /**
     * 4.激活用户功能
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void active(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        MsgBean msgBean = new MsgBean();

        String code = req.getParameter("code");

        if (code == null || us.checkUserByCode(code) == false) {

            msgBean.setFlag(false);
            msgBean.setErrorMsg("激活失败，请联系管理员");

        } else {

            boolean flag = us.activeUser(code);
            if (!flag) {
                msgBean.setFlag(false);
                msgBean.setErrorMsg("激活失败，请联系管理员");
            } else {

                msgBean.setFlag(true);
                msgBean.setErrorMsg("恭喜，您已成功激活此账号，立即登录吧。");
            }

        }

        resp.getWriter().write(msgBean.getErrorMsg());

    }

    /**
     * 5.验证邮箱重复功能
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void checkEmail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String email = req.getParameter("email").toLowerCase();

        boolean flag = us.checkUserByEmail(email);

        Map<String, Object> msg = new HashMap<String, Object>();
        if (flag) {

            msg.put("email_usable", false);
            msg.put("email_msg", "该邮箱已被注册");

        } else {

            msg.put("email_usable", true);
            msg.put("email_msg", "该邮箱可用");

        }

        ObjectMapper mapper = new ObjectMapper();
        String msg_json = mapper.writeValueAsString(msg);
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().write(msg_json);
    }

    /**
     * 6.判断用户是否登录功能
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void isLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("application/json;charset=utf-8");

        MsgBean msgBean = new MsgBean();
        User user = null;
        if ((user = (User) req.getSession().getAttribute("user")) != null) {
            msgBean.setFlag(true);
            msgBean.setObject(new ObjectMapper().writeValueAsString(user));

        } else {
            msgBean.setFlag(false);
            msgBean.setErrorMsg("此用户还未登陆！");
        }

        String msg_json = new ObjectMapper().writeValueAsString(msgBean);
        resp.getWriter().write(msg_json);
    }

    /**
     * 7.用户登出功能
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void exit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().removeAttribute("user");
        resp.sendRedirect("/index.html");
    }
}
