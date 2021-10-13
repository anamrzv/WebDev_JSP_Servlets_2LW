package servlets;

import other.Context;
import other.ResultEntity;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class ControllerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("x") == null || req.getParameter("y") == null || req.getParameter("r") == null) {
            Context context = Context.getInstance();
            List<ResultEntity> results = context.getResultsInContext();
            req.setAttribute("results", results);
            req.getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
        } else {
            req.getServletContext().getRequestDispatcher("/check").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
