package cn.boom.web.servlet.user;

import cn.boom.domain.MsgBean;
import cn.boom.domain.User;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/isLoginServlet")
public class IsLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("application/json;charset=utf-8");

        MsgBean msgBean = new MsgBean();
        User user = null;
        if ((user = (User) req.getSession().getAttribute("user")) != null) {
            msgBean.setFlag(true);
            msgBean.setObject(user.getUid());

        }else {
            msgBean.setFlag(false);
            msgBean.setErrorMsg("此用户还未登陆！");
        }

        String msg_json = new ObjectMapper().writeValueAsString(msgBean);
        resp.getWriter().write(msg_json);

    }
}
