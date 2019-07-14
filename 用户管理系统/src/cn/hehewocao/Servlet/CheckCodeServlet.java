package cn.hehewocao.Servlet;

import cn.hehewocao.OtherUtils.CaptchaUtil;

import javax.imageio.ImageIO;
import javax.print.attribute.standard.MediaSize;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.IOException;

@WebServlet("/checkCodeServlet")
public class CheckCodeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        CaptchaUtil cpu = CaptchaUtil.Instance();
        BufferedImage image = cpu.getImage();
        String checkcode = cpu.getString();
        ImageIO.write((RenderedImage) image, "jpg", resp.getOutputStream());
        HttpSession session = req.getSession();
        session.removeAttribute("checkcode");
        session.setAttribute("checkcode", checkcode);
    }
}
