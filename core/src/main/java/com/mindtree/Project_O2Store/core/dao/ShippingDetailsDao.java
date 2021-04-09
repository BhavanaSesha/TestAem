package com.mindtree.Project_O2Store.core.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mindtree.Project_O2Store.core.entity.ShippingDetails;


public class ShippingDetailsDao {

    public int shipping(ShippingDetails shippingDetails) throws ClassNotFoundException {
        String INSERT_USERS_SQL = "INSERT INTO shippingdetail" +
            "   VALUES " +
            " (?, ?, ?, ?, ?, ?);";

        int result = 0;

        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/o2store2", "root", "Amalapuram@9");

            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setString(1, shippingDetails.getFullname() );
            preparedStatement.setString(2, shippingDetails.getEmail() );
            preparedStatement.setString(3, shippingDetails.getAddress() );
            preparedStatement.setString(4, shippingDetails.getCity() );
            preparedStatement.setString(5, shippingDetails.getState() );
            preparedStatement.setString(6, shippingDetails.getPostalcode() );

            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("error");
        }
        return result;
    }
}
