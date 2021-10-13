package servlets;

import other.Context;
import other.ResultEntity;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

public class AreaCheckServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String xText = req.getParameter("x");
        String yText = req.getParameter("y");
        String rText = req.getParameter("r");
        float x = 0;
        float y = 0;
        float r = 0;
        try {
            x = Float.parseFloat(xText.trim());
            y = Float.parseFloat(yText.trim());
            r = Float.parseFloat(rText.trim());
        } catch (NumberFormatException e) {
            System.out.println("Parse error:" + xText + " " + yText + " " + rText);
            req.getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
        }

        long start = System.currentTimeMillis();
        ResultEntity newResult = new ResultEntity(x, y, r, LocalDateTime.now());
        boolean isInFigure = checkPoint(newResult);
        newResult.setScriptTime(System.currentTimeMillis() - start);
        if (isInFigure) newResult.setResult("Попадание");
        else newResult.setResult("Промах");

        System.out.println(newResult);

        Context context = Context.getInstance();
        context.addResult(newResult);

        List<ResultEntity> results = context.getResultsInContext();
        req.setAttribute("results", results);
        req.getServletContext().getRequestDispatcher("/result_page.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    private boolean checkPoint(ResultEntity result) {
        return isInTriangle(result) || isInRectangle(result) || isInCircle(result);
    }

    private boolean isInTriangle(ResultEntity result) {
        return result.getX() * (-2) + result.getR() >= result.getY() && result.getY() >= 0 && result.getX() >= 0;
    }

    private boolean isInRectangle(ResultEntity result) {
        return result.getX() <= result.getR() && result.getX() >= 0 && result.getY() <= 0 && result.getY() >= result.getR() * (-0.5);
    }

    private boolean isInCircle(ResultEntity result) {
        return result.getX() <= 0 && result.getY() <= 0 && result.getX() * result.getX() + result.getY() * result.getY() <= result.getR() * result.getR();
    }
}
