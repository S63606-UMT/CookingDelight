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
public class RecipeDao {
    
    private Connection connection;
    
    public RecipeDao() throws ClassNotFoundException {
        connection = DBConnection.getConnection();
    }
}
