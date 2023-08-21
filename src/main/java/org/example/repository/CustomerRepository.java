package org.example.repository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.entities.Customer;
import org.example.utils.ConnectionBuilder;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository {
    private final Connection connection;
    private static final Logger logger = LogManager.getLogger(CustomerRepository.class);

    public CustomerRepository(ConnectionBuilder connectionBuilder) {
        this.connection = connectionBuilder.getConnection();
    }


    public boolean add(Customer customer) {
        PreparedStatement preparedStatement;
        String sql = "INSERT INTO customer (name, surname, passport_info, phone_number, login, password) " +
                "VALUES(?,?,?,?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, customer.getName());
            preparedStatement.setString(2, customer.getSurname());
            preparedStatement.setString(3, customer.getPassport_info());
            preparedStatement.setString(4, customer.getPhone_number());
            preparedStatement.setString(5, customer.getLogin());
            preparedStatement.setString(6, customer.getPassword());

            return preparedStatement.executeUpdate() != 0;
        } catch (SQLException e) {
            logger.error("Ошибка добавления:\n" + e.getMessage());
            return false;
        }
    }


    public List<Customer> getAll() {
        List<Customer> customerList = new ArrayList<>();
        String sql = "SELECT customer_id, name, surname, passport_info, phone_number," +
                " login, password   FROM customer";

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Customer customer;
                customer = new Customer(
                        resultSet.getLong("customer_id"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getString("passport_info"),
                        resultSet.getString("phone_number"),
                        resultSet.getString("login"),
                        resultSet.getString("password")
                );
                customerList.add(customer);
            }
        } catch (SQLException e) {
            logger.error("Ошибка получения:\n" + e.getMessage());
        }

        return customerList;
    }


    public Customer findByLogin(String login) {
        Customer customer = null;
        String sql = "SELECT customer_id, login, username, surname, passport_info, phone_number, password " +
                " FROM customer WHERE login = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, login);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                customer = new Customer(
                        resultSet.getLong("customer_id"),
                        resultSet.getString("username"),
                        resultSet.getString("surname"),
                        resultSet.getString("passport_info"),
                        resultSet.getString("phone_number"),
                        resultSet.getString("login"),
                        resultSet.getString("password")
                );
            }
        } catch (SQLException e) {
            logger.error("Ошибка нахождения пользователя по логину:\n" + e.getMessage());
        }
        return customer;
    }
}
