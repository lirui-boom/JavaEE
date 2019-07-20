package boom.web.servlet;

import boom.utils.CaptchaUtil;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

@WebServlet("/checkCodeImagServlet")
public class CheckCodeImagServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        CaptchaUtil instance = CaptchaUtil.Instance();
        BufferedImage image = instance.getImage();
        String checkcode = instance.getString();
        HttpSession session = req.getSession();
        session.removeAttribute("checkcode");
        session.setAttribute("checkcode", checkcode);
        ImageIO.write(image, "jpg", resp.getOutputStream());

    }
}
