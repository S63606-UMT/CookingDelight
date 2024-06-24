 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.servlet.ServletContext;

import com.dao.CommentDao;
import com.dao.RecipeDao;
import com.model.User;
import com.model.Recipe;
import com.model.Comment;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author saifu
 */
@WebServlet("/recipe")
public class RecipeController extends HttpServlet {
    
    private static final String INDEX = "index.jsp";
    private static final String RECIPE_SEARCH = "recipeView/recipeSearch.jsp";
    private static final String RECIPE_LIST = "recipeView/recipeList.jsp";
    private static final String RECIPE_ADD = "recipeView/add.jsp";
    private static final String RECIPE_EDIT = "recipeView/edit.jsp";
    private static final String RECIPE_VIEW = "recipeView/view.jsp";
    private RecipeDao dao;
    private CommentDao commentDao;
    
    public RecipeController() throws ClassNotFoundException {
        super();
        dao = new RecipeDao();
        commentDao = new CommentDao();
    }
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RecipeController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RecipeController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false); //Retrieve session
        String action = request.getParameter("action");
        
        // For non-user
        try {
            switch (action) {
                case "recipeSearch":
                    recipeSearch(request, response);
                    break;
                case "view":
                    viewRecipe(request, response);
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
        
        // For user
        User user = (User) session.getAttribute("authenticatedUser");
        if (user == null) {
            // Foward to index.jsp
            RequestDispatcher dispatcher = request.getRequestDispatcher(INDEX);
            dispatcher.forward(request, response);
        } 
        
        try {
            switch (action) {
                case "list":
                    recipeList(request, response);
                    break;
                case "add":
                    addRecipe(request, response);
                    break;
                case "view":
                    viewRecipe(request, response);
                    break;
                case "edit":
                    editRecipe(request, response);
                    break;
                case "delete":
                    deleteRecipe(request, response);
                default:
                     response.sendRedirect(INDEX);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false); //Retrieve session
        String action = request.getParameter("action");
        
        // For non-user
        try {
            switch (action) {
                case "comment":
                    insertComment(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
        
        User user = (User) session.getAttribute("authenticatedUser");
        if (user == null) {
            // Foward to index.jsp
            RequestDispatcher dispatcher = request.getRequestDispatcher(INDEX);
            dispatcher.forward(request, response);
        }
        // For user
        try {
            switch (action) {
                case "insert":
                    insertRecipe(request, response);
                    break;
                case "update":
                    updateRecipe(request, response);
                    break;
                default:
                    response.sendRedirect(INDEX);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
    
    private void recipeSearch(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException {
        // Get all recipes.
        List<Recipe> recipes = dao.getAllRecipes();
        // Add the recipes.
        request.setAttribute("RecipeList", recipes);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher(RECIPE_SEARCH);
        dispatcher.forward(request, response);
    }
    
    private void recipeList(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException {
        HttpSession session = request.getSession(false); // Retrieve session
        User user = (User) session.getAttribute("authenticatedUser");
        
        // Get all recipes made by user.
        List<Recipe> recipes = dao.getAllRecipesByUserId(user.getUserid());
        // Add the recipes.
        request.setAttribute("RecipeList", recipes);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher(RECIPE_LIST);
        dispatcher.forward(request, response);
    }
    
    private void addRecipe(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException {
        RequestDispatcher dispatcher = request.getRequestDispatcher(RECIPE_ADD);
        dispatcher.forward(request, response);
    }
    
    private void editRecipe(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException {
        Recipe recipe = dao.getRecipeById(Integer.parseInt(request.getParameter("recipeid"))); // Get selected recipe's data
        request.setAttribute("selectedRecipe", recipe); // Send it to the next page
        
        RequestDispatcher dispatcher = request.getRequestDispatcher(RECIPE_EDIT);
        dispatcher.forward(request, response);
    }
    private void viewRecipe(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException {
        // Get selected recipe's info
        int recipeid = Integer.parseInt(request.getParameter("recipeid"));
        Recipe recipe = dao.getRecipeById(recipeid);
        request.setAttribute("selectedRecipe", recipe);
        
        // Split ingredients by `,`
        String[] ingredients = recipe.getIngredients().split(",");
        for (int i = 0; i < ingredients.length; i++) { //Trim unnecessary space
            ingredients[i] = ingredients[i].trim();
        }
        request.setAttribute("ingredients", ingredients);
        // Split instructions by `/n`
        String[] instructions = recipe.getInstructions().split("\\r?\\n");
        request.setAttribute("instructions", instructions);
        
        // Get all comments on this recipe
        List<Comment> comments = commentDao.getAllCommentsByRecipeId(recipeid);
        request.setAttribute("comments", comments);
        RequestDispatcher dispatcher = request.getRequestDispatcher(RECIPE_VIEW);
        dispatcher.forward(request, response);
    }
    
    private void deleteRecipe(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException {
        HttpSession session = request.getSession(false); // Retrieve session
        User user = (User) session.getAttribute("authenticatedUser");
        
        int recipeid = Integer.parseInt(request.getParameter("recipeid"));
        if (dao.deleteRecipeById(recipeid)) {
            // Get all recipes made by user.
            List<Recipe> recipes = dao.getAllRecipesByUserId(user.getUserid());
            // Add the recipes.
            request.setAttribute("RecipeList", recipes);
            // Set success message.
            request.setAttribute("msg", "Successfully deleted recipe.");
            RequestDispatcher dispatcher = request.getRequestDispatcher(RECIPE_LIST);
            dispatcher.forward(request, response);
        }
        
    }
    private void insertRecipe(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException {
        HttpSession session = request.getSession(false); // Retrieve session
        User user = (User) session.getAttribute("authenticatedUser");
        
        
        String title = request.getParameter("title");
        String shortDescription = request.getParameter("short-description");
        int prepTime = Integer.parseInt(request.getParameter("prep-time"));
        int cookTime = Integer.parseInt(request.getParameter("cook-time"));
        int serving = Integer.parseInt(request.getParameter("serving"));
        String ingredients = request.getParameter("ingredients");
        String instructions = request.getParameter("instructions");
        String chefNote = request.getParameter("chef-note");
        int userid = user.getUserid();
        Recipe newRecipe = new Recipe(title, shortDescription, prepTime, cookTime, serving, ingredients, instructions, chefNote, userid);
        
        if (dao.addRecipe(newRecipe)) {
            // Get all recipes made by user.
            List<Recipe> recipes = dao.getAllRecipesByUserId(user.getUserid());
            // Add the recipes.
            request.setAttribute("RecipeList", recipes);
            
            request.setAttribute("msg", "Successfully added recipe.");
            RequestDispatcher dispatcher = request.getRequestDispatcher(RECIPE_LIST);
            dispatcher.forward(request, response);
            return;
        }
        request.setAttribute("msg", "Error: Unable to add new recipe.");
        RequestDispatcher dispatcher = request.getRequestDispatcher(RECIPE_ADD);
        dispatcher.forward(request, response);
    }
    
    private void updateRecipe(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        HttpSession session = request.getSession(false); // Retrieve session
        User user = (User) session.getAttribute("authenticatedUser");
        
        int recipeid = Integer.parseInt(request.getParameter("recipeid"));
        String title = request.getParameter("title");
        String shortDescription = request.getParameter("short-description");
        int prepTime = Integer.parseInt(request.getParameter("prep-time"));
        int cookTime = Integer.parseInt(request.getParameter("cook-time"));
        int serving = Integer.parseInt(request.getParameter("serving"));
        String ingredients = request.getParameter("ingredients");
        String instructions = request.getParameter("instructions");
        String chefNote = request.getParameter("chef-note");
        int userid = user.getUserid();
        Recipe updatedRecipe = new Recipe(recipeid, title, shortDescription, prepTime, cookTime, serving, ingredients, instructions, chefNote, userid);
        
        if (dao.updateRecipe(updatedRecipe)) {
            // Get all recipes made by user.
            List<Recipe> recipes = dao.getAllRecipesByUserId(user.getUserid());
            // Add the recipes.
            request.setAttribute("RecipeList", recipes);

            request.setAttribute("msg", "Successfully updated recipe.");
            RequestDispatcher dispatcher = request.getRequestDispatcher(RECIPE_LIST);
            dispatcher.forward(request, response);
        } else {
            request.setAttribute("selectedRecipe", updatedRecipe); // In case update operation fail, preserve changed value.
            request.setAttribute("msg", "Error: Unable to update recipe.");
            RequestDispatcher dispatcher = request.getRequestDispatcher(RECIPE_EDIT);
            dispatcher.forward(request, response);
        }
    }
    
    private void insertComment(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String username = request.getParameter("username");
        String content = request.getParameter("comment-content");
        int rating = Integer.parseInt(request.getParameter("rating"));
        int recipeid = Integer.parseInt(request.getParameter("recipeid"));
        Comment comment = new Comment(username, content, rating, recipeid);

        if (commentDao.addComment(comment)) {
            List<Comment> comments = commentDao.getAllCommentsByRecipeId(recipeid);
            request.setAttribute("comments", comments);
            
            request.setAttribute("msg", "Successfully commented on this recipe.");
            RequestDispatcher dispatcher = request.getRequestDispatcher(RECIPE_VIEW);
            dispatcher.forward(request, response);
        } else {
            List<Comment> comments = commentDao.getAllCommentsByRecipeId(recipeid);
            request.setAttribute("comments", comments);
            
            request.setAttribute("msg", "Error: Failed to comment.");
            RequestDispatcher dispatcher = request.getRequestDispatcher(RECIPE_VIEW);
            dispatcher.forward(request, response);
        }
        
    }
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
