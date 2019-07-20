package boom.web.servlet;

import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/checkUsernameServlet")
public class CheckUsernameServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=utf-8");

        String email = req.getParameter("email");

        Map<String, Object> map = new HashMap<String, Object>();

        if (email.equalsIgnoreCase("hehewocao@qq.com")) {
            map.put("email_usable", false);
            map.put("email_msg", "此用户名太受欢迎，请更换一个");
        }else{
            map.put("email_usable", true);
            map.put("email_msg", "用户名可用");
    }
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(resp.getOutputStream(), map);
    }
}
