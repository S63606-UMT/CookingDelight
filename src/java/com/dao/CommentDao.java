/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dao;

import com.model.Comment;
import com.util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author saifu
 */
public class CommentDao {
    
    private Connection connection;
    
    public CommentDao() throws ClassNotFoundException {
        connection = DBConnection.getConnection();
    }
    
    public boolean addComment(Comment comment) {
        boolean rowAdded = false;
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into comment(username, content, rating, recipeid) "
                            + "values (?, ?, ?, ?)");
            
            preparedStatement.setString(1, comment.getUsername());
            preparedStatement.setString(2, comment.getContent());
            preparedStatement.setInt(3, comment.getRating());
            preparedStatement.setInt(4, comment.getRecipeid());
            rowAdded = preparedStatement.executeUpdate() > 0; // If one row added, then rowAdded = true.
        }
        catch (SQLException e) {
            e.printStackTrace();
        } 
        
        return rowAdded;
    }
    
    public List<Comment> getAllCommentsByRecipeId(int recipeId) {
        List<Comment> comments = new ArrayList<Comment>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from comment where recipeid=?");
            preparedStatement.setInt(1, recipeId);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int recipeid = rs.getInt("recipeid");
                String username = rs.getString("username");
                String content = rs.getString("content");
                int rating = rs.getInt("rating");
                Comment comment = new Comment(username, content, rating, recipeid);
                comments.add(comment);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        
        return comments;
    }
}
