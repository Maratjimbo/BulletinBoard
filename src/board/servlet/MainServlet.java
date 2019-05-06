package board.servlet;

import board.model.Ad;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class MainServlet extends HttpServlet {
    private ConcurrentHashMap<Integer, Ad> ads = new ConcurrentHashMap<>();
    private static int ids = 0;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null) {
            req.setAttribute("authorized", "false");
        } else {
            req.setAttribute("authorized", "true");
        }

        req.setAttribute("ads", ads);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("view/main.jsp");
        requestDispatcher.forward(req, resp);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);

        String title = (String)req.getParameter("title");
        String text = (String)req.getParameter("text");

        if(session != null) {
            String author = (String)session.getAttribute("name");
            this.ads.put(ids, new Ad(title, text, author));
            resp.sendRedirect("main");
        }
        else {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("view/error.jsp");
            req.setAttribute("text", "Login please.");
            requestDispatcher.forward(req, resp);
        }
    }
}
