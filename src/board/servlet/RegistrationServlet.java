package board.servlet;

import board.model.User;
import board.util.UserIO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class RegistrationServlet extends HttpServlet {
    private User users = User.getInstance();
    private static final String filepath = "C:\\java\\lab15\\users.txt";

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("view/registration.jsp");
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

        if (!this.users.containsKey(name)) {
            users.addUser(name, password);
            UserIO.saveUsers(filepath, users.getUsers());
            createSession(req, resp, name);

            resp.sendRedirect("main");
        } else {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("view/error.jsp");
            req.setAttribute("text", "You should take another name.");
            requestDispatcher.forward(req, resp);
        }
    }

    private void createSession(HttpServletRequest req, HttpServletResponse resp, String name) throws IOException, ServletException {
        HttpSession session = req.getSession();
        session.setAttribute("name", name);
    }
}
