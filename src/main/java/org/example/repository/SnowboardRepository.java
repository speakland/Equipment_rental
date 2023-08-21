package org.example.repository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.entities.Helmet;
import org.example.entities.Snowboard;
import org.example.utils.ConnectionBuilder;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SnowboardRepository {
    private final Connection connection;
    private static final Logger logger = LogManager.getLogger(SnowboardRepository.class);

    public SnowboardRepository(ConnectionBuilder connectionBuilder) {
        this.connection = connectionBuilder.getConnection();
    }


    public void add(Snowboard snowboard) {
        PreparedStatement preparedStatement;
        String sql = "INSERT INTO snowboard (id, rental_id, length, width) " +
                "VALUES(?,?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, snowboard.getSnowboard_id());
            preparedStatement.setLong(2, snowboard.getRental_id());
            preparedStatement.setInt(3, snowboard.getLength());
            preparedStatement.setInt(4, snowboard.getWidth());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error("Ошибка добавления:\n" + e.getMessage());
        }
    }


    public List<Snowboard> getAll() {
        List<Snowboard> snowboardList = new ArrayList<>();
        String sql = "SELECT id, rental_id, length, width  FROM snowboard";

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Snowboard snowboard;
                snowboard = new Snowboard(
                        resultSet.getLong("snowboard_id"),
                        resultSet.getLong("rental_id"),
                        resultSet.getInt("length"),
                        resultSet.getInt("width")

                );
                snowboardList.add(snowboard);
            }
        } catch (SQLException e) {
            logger.error("Ошибка получения:\n" + e.getMessage());
        }

        return snowboardList;
    }
}
