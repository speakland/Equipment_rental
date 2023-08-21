package org.example.repository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.entities.Rental;
import org.example.utils.ConnectionBuilder;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RentalRepository {
    private final Connection connection;
    private static final Logger logger = LogManager.getLogger(RentalRepository.class);

    public RentalRepository(ConnectionBuilder connectionBuilder) {
        this.connection = connectionBuilder.getConnection();
    }


    public void add(Rental rental) {
        PreparedStatement preparedStatement;
        String sql = "INSERT INTO rental (time_out, time_back, price, rDate) " +
                "VALUES(?,?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, rental.getTime_out());
            preparedStatement.setString(2, rental.getTime_back());
            preparedStatement.setInt(3, rental.getPrice());
            preparedStatement.setDate(4, Date.valueOf(rental.getDate()));

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error("Ошибка добавления:\n" + e.getMessage());
        }
    }


    public List<Rental> getAll() {
        List<Rental> rentalList = new ArrayList<>();
        String sql = "SELECT rental_id, customer_id, time_out," +
                " time_back, price, rDate   FROM rental";

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Rental rental;
                rental = new Rental(
                        resultSet.getLong("rental_id"),
                        resultSet.getLong("customer_id"),
                        resultSet.getDate("date").toLocalDate(),
                        resultSet.getString("time_out"),
                        resultSet.getString("time_back"),
                        resultSet.getInt("price")
                );
                rentalList.add(rental);
            }
        } catch (SQLException e) {
            logger.error("Ошибка получения:\n" + e.getMessage());
        }

        return rentalList;
    }


    public List<Rental> getById(Long rental_id) {
        String sql = "rental_id, customer_id, time_out, time_back, price, rDate   FROM rental WHERE rental_id = ?";

        List<Rental> listRental = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, rental_id);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Rental rental;
                rental = new Rental(
                        resultSet.getLong("rental_id"),
                        resultSet.getLong("customer_id"),
                        resultSet.getDate("date").toLocalDate(),
                        resultSet.getString("time_out"),
                        resultSet.getString("time_back"),
                        resultSet.getInt("price")
                                );
                listRental.add(rental);
            }
        } catch (SQLException e) {
            logger.error("Ошибка получения по id:\n" + e.getMessage());
        }
        return listRental;
    }


    public void update(Rental rental) {
        PreparedStatement preparedStatement;
        String sql = "UPDATE CAR SET " +
                "time_out = ?, " +
                "time_back = ?, " +
                "price = ?" +
                "date = ?" +
                "WHERE id = ? AND model_id = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, rental.getRental_id());
            preparedStatement.setLong(2, rental.getCustomer_id());
            preparedStatement.setString(3, rental.getTime_out());
            preparedStatement.setString(4, rental.getTime_back());
            preparedStatement.setInt(5, rental.getPrice());
            preparedStatement.setDate(6, Date.valueOf(rental.getDate()));

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error("Ошибка изменения:\n" + e.getMessage());
        }
    }


    public void remove(Rental rental) {
        PreparedStatement preparedStatement;
        String sql = "DELETE FROM rental WHERE id = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, rental.getRental_id());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error("Ошибка удаления:\n" + e.getMessage());
        }
    }
    public Rental findByPrice(Integer price) {
        Rental rental = null;
        String carQuery = "SELECT rental_id, customer_id, time_out," +
        " time_back, price, rDate   FROM rental WHERE price = ? ";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(carQuery);

            preparedStatement.setInt(1, price);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                rental = new Rental(
                        resultSet.getLong("rental_id"),
                        resultSet.getLong("customer_id"),
                        resultSet.getDate("date").toLocalDate(),
                        resultSet.getString("time_out"),
                        resultSet.getString("time_back"),
                        resultSet.getInt("price")
                );
            }
        } catch (SQLException e) {
            logger.error("Ошибка получения поиска автомобиля по названию:\n" + e.getMessage());
        }
        return rental;
    }
}
