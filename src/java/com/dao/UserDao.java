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
import com.model.User;
import com.util.DBConnection;
import java.time.LocalDate;

import org.mindrot.jbcrypt.BCrypt;

public class UserDao {
    
    private Connection connection;
    
    public UserDao() throws ClassNotFoundException {
        connection = DBConnection.getConnection();
    }
    
    public boolean addUser(User user) {
        boolean rowAdded = false;
        try {
            String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into users(username, password, email, dateOfBirth, gender) "
                            + "values (?, ?, ?, ?, ?)");
            
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, hashedPassword);
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setDate(4, java.sql.Date.valueOf(user.getDateOfBirth()));
            preparedStatement.setString(5, user.getGender());
            rowAdded = preparedStatement.executeUpdate() > 0; // If one row added, then rowAdded = true.
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        
        return rowAdded;
    }
    
    public void deleteUserById(int userId) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from users where userid=?");
            
            preparedStatement.setInt(1, userId);
            preparedStatement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public User isUser(String username, String password) {
        User authenticatedUser = null;
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("select * from users where username=?");
            
            preparedStatement.setString(1, username);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                if (BCrypt.checkpw(password, rs.getString("password"))) {
                    LocalDate dateOfBirth = rs.getDate("dateOfBirth") != null ? LocalDate.parse(rs.getDate("dateOfBirth").toString()) : null;
                    
                    authenticatedUser = new User(rs.getInt("userid"), rs.getString("username"), rs.getString("password"), 
                            rs.getString("email"), dateOfBirth, rs.getString("gender"));
                
                    String description = rs.getString("description");
                    String picturePath = rs.getString("picturePath");
                    if (description != null && description.length() != 0) {
                        authenticatedUser.setDescription(description);
                    }
                    if (picturePath != null && picturePath.length() != 0) {
                        authenticatedUser.setPicturePath(picturePath);
                    }
                }
            }     
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return authenticatedUser;
    }
    public boolean isPassword(User user, String password) {
        boolean isPassword = false;
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("select * from users where userid=?");
            
            preparedStatement.setInt(1, user.getUserid());
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                if (BCrypt.checkpw(password, rs.getString("password"))) {
                    isPassword = true;
                }
            }     
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return isPassword;
    }
    
    public boolean updateUsername(User user, String newUsername) {
        boolean rowUpdated = false;
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update users set username=? "
                            + "where userid=?");

            preparedStatement.setString(1, newUsername);
            preparedStatement.setInt(2, user.getUserid());
            rowUpdated = preparedStatement.executeUpdate() > 0; // If one row updated, then rowUpdated = true.
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdated;
    }
    
    public boolean updatePassword(User user, String newPassword) {
        boolean rowUpdated = false;
        String hashedPassword = BCrypt.hashpw(newPassword, BCrypt.gensalt());
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update users set password=? "
                            + "where userid=?");

            preparedStatement.setString(1, hashedPassword);
            preparedStatement.setInt(2, user.getUserid());
            rowUpdated = preparedStatement.executeUpdate() > 0; // If one row updated, then rowUpdated = true.
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdated;
    }
    
    public boolean updateEmail(User user, String newEmail) {
        boolean rowUpdated = false;
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update users set email=? "
                            + "where userid=?");

            preparedStatement.setString(1, newEmail);
            preparedStatement.setInt(2, user.getUserid());
            rowUpdated = preparedStatement.executeUpdate() > 0; // If one row updated, then rowUpdated = true.
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdated;
    }
    
    public boolean updateDob(User user, String newDob) {
        boolean rowUpdated = false;
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update users set dateOfBirth=? "
                            + "where userid=?");

            preparedStatement.setDate(1, java.sql.Date.valueOf(LocalDate.parse(newDob)));
            preparedStatement.setInt(2, user.getUserid());
            rowUpdated = preparedStatement.executeUpdate() > 0; // If one row updated, then rowUpdated = true.
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdated;
    }
    
    public boolean updateGender(User user, String newGender) {
        boolean rowUpdated = false;
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update users set gender=? "
                            + "where userid=?");

            preparedStatement.setString(1, newGender);
            preparedStatement.setInt(2, user.getUserid());
            rowUpdated = preparedStatement.executeUpdate() > 0; // If one row updated, then rowUpdated = true.
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdated;
    }
    
    public boolean updateDesc(User user, String newDesc) {
        boolean rowUpdated = false;
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update users set description=? "
                            + "where userid=?");

            preparedStatement.setString(1, newDesc);
            preparedStatement.setInt(2, user.getUserid());
            rowUpdated = preparedStatement.executeUpdate() > 0; // If one row updated, then rowUpdated = true.
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdated;
    }
    
    public boolean updatePicturePath(User user, String newPath) {
        boolean rowUpdated = false;
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update users set picturePath=? "
                            + "where userid=?");

            preparedStatement.setString(1, newPath);
            preparedStatement.setInt(2, user.getUserid());
            rowUpdated = preparedStatement.executeUpdate() > 0; // If one row updated, then rowUpdated = true.
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdated;
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
                user.setUserid(rs.getInt("userid"));
                user.setUsername(rs.getString("username"));
                user.setEmail(rs.getString("email"));
                user.setDateOfBirth(rs.getDate("dateOfBirth") != null ? LocalDate.parse(rs.getDate("dateOfBirth").toString()) : null);
                user.setGender(rs.getString("gender"));
                
                String description = rs.getString("description");
                String picturePath = rs.getString("picturePath");
                if (description != null && description.length() != 0) {
                    user.setDescription(description);
                }
                if (picturePath != null && picturePath.length() != 0) {
                    user.setPicturePath(picturePath);
                }
            }
            
            
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        
        return user;
    }
    
    public User getUserById(int userId) {
        User user = null;
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("select * from users where userid=?");
            preparedStatement.setInt(1, userId);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                LocalDate dateOfBirth = rs.getDate("dateOfBirth") != null ? LocalDate.parse(rs.getDate("dateOfBirth").toString()) : null;

                user = new User(rs.getInt("userid"), 
                        rs.getString("username"), 
                        rs.getString("password"), 
                        rs.getString("email"), 
                        dateOfBirth, 
                        rs.getString("gender"));
                
                String description = rs.getString("description");
                String picturePath = rs.getString("picturePath");
                if (description != null && description.length() != 0) {
                    user.setDescription(description);
                }
                if (picturePath != null && picturePath.length() != 0) {
                    user.setPicturePath(picturePath);
                }
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        
        return user;
    }
    
}
