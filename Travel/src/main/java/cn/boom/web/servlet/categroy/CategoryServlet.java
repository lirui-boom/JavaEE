package cn.boom.web.servlet.categroy;

import cn.boom.domain.Category;
import cn.boom.service.CategoryService;
import cn.boom.service.impl.CategoryServiceImpl;
import cn.boom.web.servlet.BaseServlet;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/category/*")
public class CategoryServlet extends BaseServlet {

    private CategoryService service = new CategoryServiceImpl();
    /**
     * 查询所有类别
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void findAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=utf-8");
        List<Category> categorys = service.findAll();
        ObjectMapper mapper = new ObjectMapper();
        String categorys_json = mapper.writeValueAsString(categorys);
        resp.getWriter().write(categorys_json);

    }

    public void findOne(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=utf-8");
        String cid = req.getParameter("cid");
        Category category = service.findById(cid);
        ObjectMapper mapper = new ObjectMapper();
        String categorys_json = mapper.writeValueAsString(category);
        resp.getWriter().write(categorys_json);
    }
}
