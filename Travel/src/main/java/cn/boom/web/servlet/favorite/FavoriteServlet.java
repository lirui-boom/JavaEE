package cn.boom.web.servlet.favorite;

import cn.boom.domain.PageBean;
import cn.boom.domain.Route;
import cn.boom.service.FavoriteService;
import cn.boom.service.impl.FavoriteServiceImpl;
import cn.boom.web.servlet.BaseServlet;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/favorite/*")
public class FavoriteServlet extends BaseServlet {

    private FavoriteService service = new FavoriteServiceImpl();

    /**
     * 查询路线是否被此用户收藏
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void isCollect(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");

        String rid = req.getParameter("rid");
        String uid = req.getParameter("uid");

        boolean flag = service.isCollect(rid, uid);

        ObjectMapper mapper = new ObjectMapper();
        String flag_json = mapper.writeValueAsString(flag);
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().write(flag_json);

    }

    /**
     * 添加用户收藏的功能
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void addFavorite(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        String rid = req.getParameter("rid");
        String uid = req.getParameter("uid");
        boolean flag = service.addFavorite(rid, uid);
        ObjectMapper mapper = new ObjectMapper();
        String flag_json = mapper.writeValueAsString(flag);
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().write(flag_json);
    }

    public void findAllCollect(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        String uid = req.getParameter("uid");
        String currentPage = req.getParameter("currentPage");
        String pageSize = req.getParameter("pageSize");

        PageBean<Route> favoritePageBean = service.findAllCollect(uid,currentPage,pageSize);
        ObjectMapper mapper = new ObjectMapper();
        String favoritePageBean_json = mapper.writeValueAsString(favoritePageBean);
        resp.setContentType("application/json;charset=utf-8");

        System.out.println(favoritePageBean_json);

        resp.getWriter().write(favoritePageBean_json);

    }


}
