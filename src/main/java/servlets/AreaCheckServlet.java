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
        int x = 0;
        float y = 0;
        int r = 0;
        try {
            x = Integer.parseInt(xText.trim());
            y = Float.parseFloat(yText.trim());
            r = Integer.parseInt(rText.trim());
        } catch (NumberFormatException e) {
            System.out.println("Parse error:" + xText + " " + yText + " " + rText);
            resp.sendRedirect("/main");
        }

        long start = System.currentTimeMillis();
        ResultEntity newResult = new ResultEntity(x, y, r, LocalDateTime.now());
        boolean isInFigure = checkPoint(newResult);
        newResult.setScriptTime(System.currentTimeMillis()-start);
        if (isInFigure) newResult.setResult("Попадание");
        else newResult.setResult("Промах");

        System.out.println(newResult);

        Context context = Context.getInstance();
        context.addResult(newResult);

        List<ResultEntity> results = context.getResultsInContext();
        req.setAttribute("results", results);
        resp.sendRedirect("/main");
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
        return result.getX() <= result.getR() && result.getX() >= 0 && result.getY() <= 0 && result.getY() >= result.getR() * (-1 / 2);
    }

    private boolean isInCircle(ResultEntity result) {
        return result.getX() <= 0 && result.getY() <= 0 && result.getX() * result.getX() + result.getY() * result.getY() <= result.getR() * result.getR();
    }
}
