/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dao;

import com.util.DBConnection;
import java.sql.*;

/**
 *
 * @author saifu
 */
public class NewsletterDao {
    
    private Connection connection;

    public NewsletterDao() throws ClassNotFoundException {
        connection = DBConnection.getConnection();
    }
    
    public boolean insertEmail(String email) {
        boolean rowInserted = false;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO newsletter(email) VALUES (?)");
            preparedStatement.setString(1, email);
            rowInserted = preparedStatement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return rowInserted;
    }
}
