package cn.boom.web.servlet;

import cn.boom.service.ProvinceService;
import cn.boom.service.ProvinceServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/provinceServlet")
public class ProvinceServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("application/json;charset=utf-8");
        ProvinceService ps = new ProvinceServiceImpl();
        String province_json = ps.findProvince_json();
        resp.getWriter().write(province_json);
    }
}
