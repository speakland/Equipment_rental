package org.example.service;

import org.example.entities.Customer;
import org.example.entities.Rental;

import java.util.List;

public interface CustomerService {

    boolean createUser(Customer customer);

    void add(Customer customer);

    List<Customer> getAll();

    List<Customer> getById(Integer customer_id);



    Customer findByLogin(String login);
}
