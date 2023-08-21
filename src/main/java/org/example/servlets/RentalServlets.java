package org.example.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
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
import java.time.LocalDate;
import java.util.List;


@WebServlet("/user/Rental")
public class RentalServlets extends HttpServlet {
    CustomerService customerService = new CustomerServiceImpl();
    HelmetService helmetService = new HelmetServiceImpl();

    RentalService rentalService = new RentalServiceImpl();
    SnowboardService snowboardService = new SnowboardServiceImpl();



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Rental> rentals = rentalService.getAll();
        req.setAttribute("rentalsList", rentals);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/user/EquipmentRent.jsp");
        requestDispatcher.forward(req, resp);

    }
}
