package com.mindtree.Project_O2Store.core.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mindtree.Project_O2Store.core.entity.DebitCard;


public class DebitCardDao {

    public int debitDetails(DebitCard debitcard) throws ClassNotFoundException {
        String INSERT_USERS_SQL = "INSERT INTO debitcarddetails" +
            "   VALUES " +
            " (?, ?, ?, ?);";

        int result = 0;

        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/o2store2", "root", "Amalapuram@9");

            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setString(1, debitcard.getCardnumber());
            preparedStatement.setString(2, debitcard.getName());
            preparedStatement.setString(3, debitcard.getExpiry());
            preparedStatement.setString(4, debitcard.getCvv());

            System.out.println(preparedStatement);
            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("error");
        }
        return result;
    }
}