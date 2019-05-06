package board.servlet;

import board.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    private User users = User.getInstance();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("view/login.jsp");
        requestDispatcher.forward(req, resp);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("userName");
        String password = req.getParameter("password");

        if (name == null || name.length() < 1 || password == null || password.length() < 1) {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("view/error.jsp");
            req.setAttribute("text", "Empty fields.");
            requestDispatcher.forward(req, resp);
        }

        if (password.equals(this.users.get(name))) {
            createSession(req, resp, name);
            resp.sendRedirect("main");
        } else {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("view/error.jsp");
            req.setAttribute("text", "Wrong password or login.");
            requestDispatcher.forward(req, resp);
        }
    }

    private void createSession(HttpServletRequest req, HttpServletResponse resp, String name) throws IOException, ServletException {
        HttpSession session = req.getSession();
        session.setAttribute("name", name);
    }
}
