package servlets;

import other.ResultEntity;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

public class AreaCheckServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String xText = req.getParameter("x");
        String yText = req.getParameter("y");
        String rText = req.getParameter("r");
        int x = Integer.parseInt(xText);
        float y = Float.parseFloat(yText);
        int r = Integer.parseInt(rText);
        ResultEntity resultEntity = new ResultEntity(x, y, r, LocalDateTime.now());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
