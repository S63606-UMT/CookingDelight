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
                    .prepareStatement("insert into recipe(title, shortDescription, prepTime, cookTime, serving, ingredients, instructions, chefNote, userid) "
                            + "values (?, ?, ?, ?, ?, ?, ?, ?, ?)");
            
            preparedStatement.setString(1, recipe.getTitle());
            preparedStatement.setString(2, recipe.getShortDescription());
            preparedStatement.setInt(3, recipe.getPrepTime());
            preparedStatement.setInt(4, recipe.getCookTime());
            preparedStatement.setInt(5, recipe.getServing());
            preparedStatement.setString(6, recipe.getIngredients());
            preparedStatement.setString(7, recipe.getInstructions());
            preparedStatement.setString(8, recipe.getChefNote());
            preparedStatement.setInt(9, recipe.getUserid());
            rowAdded = preparedStatement.executeUpdate() > 0; // If one row added, then rowAdded = true.
        }
        catch (SQLException e) {
            e.printStackTrace();
        } 
        
        return rowAdded;
    }
    
    public boolean updateRecipe(Recipe recipe) {
        boolean rowUpdated = false;
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update recipe set title=?, shortDescription=?, prepTime=?, cookTime=?, serving=?, ingredients=?, instructions=?, chefNote=? "
                            + "where recipeid=?");
            
            preparedStatement.setString(1, recipe.getTitle());
            preparedStatement.setString(2, recipe.getShortDescription());
            preparedStatement.setInt(3, recipe.getPrepTime());
            preparedStatement.setInt(4, recipe.getCookTime());
            preparedStatement.setInt(5, recipe.getServing());
            preparedStatement.setString(6, recipe.getIngredients());
            preparedStatement.setString(7, recipe.getInstructions());
            preparedStatement.setString(8, recipe.getChefNote());
            preparedStatement.setInt(9, recipe.getRecipeid());
            rowUpdated = preparedStatement.executeUpdate() > 0; // If one row updated, then rowUpdated = true.
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        
        return rowUpdated;
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
                int prepTime = rs.getInt("prepTime");
                int cookTime = rs.getInt("cookTime");
                int serving = rs.getInt("serving");
                String ingredients = rs.getString("ingredients");
                String instructions = rs.getString("instructions");
                String chefNote = rs.getString("chefNote");
                int userid = rs.getInt("userid");
                Recipe recipe = new Recipe(recipeid, title, shortDescription, prepTime, cookTime, serving, ingredients, instructions, chefNote, userid);
                recipes.add(recipe);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        
        return recipes;
    }
    
    public List<Recipe> getAllRecipesByUserId(int userId) {
        List<Recipe> recipes = new ArrayList<Recipe>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from recipe where userid=?");
            preparedStatement.setInt(1, userId);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int recipeid = rs.getInt("recipeid");
                String title = rs.getString("title");
                String shortDescription = rs.getString("shortDescription");
                int prepTime = rs.getInt("prepTime");
                int cookTime = rs.getInt("cookTime");
                int serving = rs.getInt("serving");
                String ingredients = rs.getString("ingredients");
                String instructions = rs.getString("instructions");
                String chefNote = rs.getString("chefNote");
                int userid = rs.getInt("userid");
                Recipe recipe = new Recipe(recipeid, title, shortDescription, prepTime, cookTime, serving, ingredients, instructions, chefNote, userid);
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
                int prepTime = rs.getInt("prepTime");
                int cookTime = rs.getInt("cookTime");
                int serving = rs.getInt("serving");
                String ingredients = rs.getString("ingredients");
                String instructions = rs.getString("instructions");
                String chefNote = rs.getString("chefNote");
                int userid = rs.getInt("userid");
                recipe = new Recipe(recipeid, title, shortDescription, prepTime, cookTime, serving, ingredients, instructions, chefNote, userid);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        
        return recipe;
    }
    
    public boolean deleteRecipeById(int recipeId) {
        boolean rowDeleted = false;
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from recipe where recipeid=?");
            
            preparedStatement.setInt(1, recipeId);
            rowDeleted = preparedStatement.executeUpdate() > 0;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        
        return rowDeleted;
    }
}
