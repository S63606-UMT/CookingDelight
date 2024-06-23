/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dao;

import java.util.ArrayList;
import java.util.List;
import com.util.DBConnection;
import java.sql.*;

import com.model.Recipe;
/**
 *
 * @author saifu
 */
public class RecipeDao {
    
    private Connection connection;
    
    public RecipeDao() throws ClassNotFoundException {
        connection = DBConnection.getConnection();
    }
    
    public boolean addRecipe(Recipe recipe) {
        boolean rowAdded = false;
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into recipe(title, shortDescription) "
                            + "values (?, ?)");
            
            preparedStatement.setString(1, recipe.getTitle());
            preparedStatement.setString(2, recipe.getShortDescription());
            rowAdded = preparedStatement.executeUpdate() > 0; // If one row added, then rowAdded = true.
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        
        return rowAdded;
    }
    
    public List<Recipe> getAllRecipes() {
        List<Recipe> recipes = new ArrayList<Recipe>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from recipe");
            while (rs.next()) {
                int recipeid = rs.getInt("recipeid");
                String title = rs.getString("title");
                String shortDescription = rs.getString("shortDescription");
                Recipe recipe = new Recipe(recipeid, title, shortDescription);
                recipes.add(recipe);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        
        return recipes;
    }
    
    public Recipe getRecipeById(int recipeId) {
        Recipe recipe = null;
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("select * from recipe where recipeid=?");
            preparedStatement.setInt(1, recipeId);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                int recipeid = rs.getInt("recipeid");
                String title = rs.getString("title");
                String shortDescription = rs.getString("shortDescription");
                recipe = new Recipe(recipeid, title, shortDescription);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        
        return recipe;
    }
}
