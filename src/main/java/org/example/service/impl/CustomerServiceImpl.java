package org.example.service.impl;
import org.example.entities.Customer;
import org.example.repository.CustomerRepository;
import org.example.service.CustomerService;
import org.example.utils.PullConnection;
import java.util.List;

public class CustomerServiceImpl implements CustomerService {

    public boolean createUser(Customer customer) {
        customer.setPassword(getPasswordHash(customer.getPassword()));
        return customerRepository.add(customer);
    }

    public Customer loginUser(String login, String password) {
        Customer customer = customerRepository.findByLogin(login);
        if (customer != null &&
                customer.getPassword().equals(getPasswordHash(password))) {
            return customer;
        }
        return null;
    }

    private final CustomerRepository customerRepository = new CustomerRepository (new PullConnection());


    @Override
    public void add(Customer customer) {
customerRepository.add(customer);
    }

    @Override
    public List<Customer> getAll() {
        return customerRepository.getAll();
    }

    @Override
    public List<Customer> getById(Integer customer_id) {
        return null;
    }

    private static String getPasswordHash(String password) {
        return String.valueOf(password.hashCode());
    }

    private static String getIdHash(String id) {
        return String.valueOf(id.hashCode());
    }

    @Override
    public Customer findByLogin(String login) {
        return customerRepository.findByLogin(login);
    }
}
