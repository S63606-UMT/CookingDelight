/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dao;

/**
 *
 * @author Saiful
 */

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import com.model.User;
import com.util.DBConnection;
import java.time.LocalDate;

public class UserDao {
    
    private Connection connection;
    
    public UserDao() throws ClassNotFoundException {
        connection = DBConnection.getConnection();
    }
    
    public void addUser(User user) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into users(username, password, email, dateOfBirth, gender) "
                            + "values (?, ?, ?, ?, ?)");
            
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setDate(4, java.sql.Date.valueOf(user.getDateOfBirth()));
            preparedStatement.setString(5, user.getGender());
            preparedStatement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void deleteUser(String username) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from users where username=?");
            
            preparedStatement.setString(1, username);
            preparedStatement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public boolean isUser(String username, String password) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("select from users where username=?");
            
            preparedStatement.setString(1, username);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                if (password.equals(rs.getString("password"))) {
                    return true;
                    
                }
            }     
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public void updateUsername(User user, String newUsername) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update users set username=? "
                            + "where userid=?");

            preparedStatement.setString(1, newUsername);
            preparedStatement.setInt(2, user.getUserid());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void updateEmail(User user, String newEmail) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update users set email=? "
                            + "where userid=?");

            preparedStatement.setString(1, newEmail);
            preparedStatement.setInt(2, user.getUserid());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void updateDob(User user, String newDob) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update users set dateOfBirth=? "
                            + "where userid=?");

            preparedStatement.setDate(1, java.sql.Date.valueOf(LocalDate.parse(newDob)));
            preparedStatement.setInt(2, user.getUserid());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void updateGender(User user, String newGender) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update users set gender=? "
                            + "where userid=?");

            preparedStatement.setString(1, newGender);
            preparedStatement.setInt(2, user.getUserid());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /*
    public void updateUser(User user) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update users set firstname=?, lastname=? " +
                            "where userid=?");
            
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getUserid());
            preparedStatement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<User>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from users");
            while (rs.next()) {
                User user = new User();
                user.setUserid(rs.getString("userid"));
                user.setFirstName(rs.getString("firstname"));
                user.setLastName(rs.getString("lastname"));
                users.add(user);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        
        return users;
    }
    */
    public User getUserByUsername(String username) {
        User user = new User();
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("select * from users where username=?");
            preparedStatement.setString(1, username);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                user.setUserid(Integer.parseInt(rs.getString("userid")));
                user.setUsername(rs.getString("username"));
                user.setEmail(rs.getString("email"));
                user.setDateOfBirth(rs.getDate("dateOfBirth") != null ? LocalDate.parse(rs.getDate("dateOfBirth").toString()) : null);
                user.setGender(rs.getString("gender"));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        
        return user;
    }
    
}
