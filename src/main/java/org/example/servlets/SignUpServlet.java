package org.example.servlets;
import java.util.concurrent.ThreadLocalRandom;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.entities.Customer;
import org.example.service.impl.CustomerServiceImpl;

import java.io.IOException;


@WebServlet("/signup")
public class SignUpServlet extends HttpServlet {
    private final CustomerServiceImpl customerService = new CustomerServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/auth/signup.jsp");
        requestDispatcher.forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        Long customer_id = (long) ThreadLocalRandom.current().nextInt();
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String passport_info = req.getParameter("passport_info");
        String phone_number = req.getParameter("phone_number");
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        boolean created = customerService.createUser(new Customer(name, surname, passport_info,
                phone_number, login, password));
        req.setAttribute("userCreated", created);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/auth/login.jsp");
        requestDispatcher.forward(req, res);
    }
}
