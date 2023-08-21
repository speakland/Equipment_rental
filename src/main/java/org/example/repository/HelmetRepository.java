package org.example.repository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.entities.Helmet;
import org.example.utils.ConnectionBuilder;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HelmetRepository {
    private final Connection connection;
    private static final Logger logger = LogManager.getLogger(HelmetRepository.class);

    public HelmetRepository(ConnectionBuilder connectionBuilder) {
        this.connection = connectionBuilder.getConnection();
    }


    public void add(Helmet helmet) {
        PreparedStatement preparedStatement;
        String sql = "INSERT INTO helmet (id, rental_id, size) " +
                "VALUES(?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, helmet.getHelmet_id());
            preparedStatement.setLong(2, helmet.getRental_id());
            preparedStatement.setInt(3, helmet.getSize());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error("Ошибка добавления:\n" + e.getMessage());
        }
    }


    public List<Helmet> getAll() {
        List<Helmet> helmetList = new ArrayList<>();
        String sql = "SELECT id, rental_id, size  FROM helmet";

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Helmet helmet;
                helmet = new Helmet(
                        resultSet.getLong("helmet_id"),
                        resultSet.getLong("rental_id"),
                        resultSet.getInt("size")

                );
                helmetList.add(helmet);
            }
        } catch (SQLException e) {
            logger.error("Ошибка получения:\n" + e.getMessage());
        }

        return helmetList;
    }
}
