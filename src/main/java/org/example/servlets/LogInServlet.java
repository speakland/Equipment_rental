package org.example.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.entities.Customer;
import org.example.service.impl.CustomerServiceImpl;

import java.io.IOException;

@WebServlet("/login")
public class LogInServlet extends HttpServlet {
    private final CustomerServiceImpl customerService = new CustomerServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/auth/login.jsp");
        requestDispatcher.forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        RequestDispatcher requestDispatcher;
        Customer customer = customerService.loginUser(login, password);
        if (customer != null) {

            req.getSession().setAttribute("loggedUser", customer.getLogin());
            res.sendRedirect(req.getContextPath() + "WEB-INF/user/home.jsp");
        } else {
            req.setAttribute("loggingAttempt", "Неверные данные");
            requestDispatcher = req.getRequestDispatcher("WEB-INF/auth/login.jsp");
            requestDispatcher.forward(req, res);
        }
    }
}
