package cn.boom.web.servlet.route;

import cn.boom.domain.PageBean;
import cn.boom.domain.Route;
import cn.boom.service.RouteService;
import cn.boom.service.impl.RouteServiceImpl;
import cn.boom.web.servlet.BaseServlet;
import com.fasterxml.jackson.databind.ObjectMapper;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/route/*")
public class RouteServlet extends BaseServlet {

    private RouteService service = new RouteServiceImpl();

    public void findByPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        //获取请求Page参数
        String cidStr = req.getParameter("cid");
        String currentPageStr = req.getParameter("currentPage");
        String pageSizeStr = req.getParameter("pageSize");
        String conditionStr = req.getParameter("condition");

        if (cidStr == null || cidStr.length() == 0 || "null".equals(cidStr)) {
            cidStr = "0";
        }
        if (currentPageStr == null || currentPageStr.length() == 0) {
            currentPageStr = "1";
        }
        if (pageSizeStr == null || pageSizeStr.length() == 0) {
            pageSizeStr = "5";
        }

        String condition = null;
        if (conditionStr.equals("") || conditionStr.length() == 0) {
            condition = null;
        } else {
            condition = conditionStr.trim();//去除首尾空格
        }

        int cid = Integer.parseInt(cidStr);
        int currentPage = Integer.parseInt(currentPageStr);
        int pageSize = Integer.parseInt(pageSizeStr);



        if (cid < 0){
            cid = 0;
        }
        if (currentPage <= 0) {
            currentPage = 1;
        }
        if (pageSize <= 0) {
            pageSize = 5;
        }

        //查询信息
        PageBean<Route> routePage = service.findByPage(cid,currentPage,pageSize,condition);

        //封装json数据
        ObjectMapper mapper = new ObjectMapper();
        String routePage_json = mapper.writeValueAsString(routePage);


        //发送响应
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().write(routePage_json);
    }

    public void findRouteDetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");

        String rid = req.getParameter("rid");

        Route route = service.findRouteDetail(rid);

        ObjectMapper mapper = new ObjectMapper();
        String route_json = mapper.writeValueAsString(route);
        
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().write(route_json);

    }
}
