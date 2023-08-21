package org.example.utils;
import java.sql.Connection;
import java.sql.PreparedStatement;

public interface ConnectionBuilder {
    Connection getConnection();
}
