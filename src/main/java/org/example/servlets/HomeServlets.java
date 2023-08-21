package org.example.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.entities.Customer;
import org.example.entities.Rental;
import org.example.service.CustomerService;
import org.example.service.HelmetService;
import org.example.service.RentalService;
import org.example.service.SnowboardService;
import org.example.service.impl.CustomerServiceImpl;
import org.example.service.impl.HelmetServiceImpl;
import org.example.service.impl.RentalServiceImpl;
import org.example.service.impl.SnowboardServiceImpl;

import java.io.IOException;
import java.sql.Time;
import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@WebServlet("/user/home")
public class HomeServlets extends HttpServlet {
    CustomerService customerService = new CustomerServiceImpl();
    HelmetService helmetService = new HelmetServiceImpl();
    RentalService rentalService = new RentalServiceImpl();

    SnowboardService snowboardService = new SnowboardServiceImpl();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = String.valueOf(req.getSession().getAttribute("loggedUser"));
        Customer user;
        user = customerService.findByLogin(login);
        req.setAttribute("user", user);

        List<Rental> rentalUserList = rentalService.findAllRentForUserId(user.getCustomer_id());
        req.setAttribute("rentalUserList", rentalUserList);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/user/home.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String time_out = (req.getParameter("time_out"));
        String time_back = (req.getParameter("time_back"));
        LocalDate rDate = LocalDate.parse((req.getParameter("date")));
        int price = Integer.parseInt(req.getParameter("price"));
        String login = String.valueOf(req.getSession().getAttribute("loggedUser"));
        Customer user;
        user = customerService.findByLogin(login);
        rentalService.add(new Rental(
                user.getCustomer_id(),
                rDate,
                time_out,
                time_back,
                price
        ));

        resp.sendRedirect(req.getContextPath() + "/WEB-INF/user/rental.jsp");
    }
}
