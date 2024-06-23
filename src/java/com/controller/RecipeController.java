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

import com.dao.RecipeDao;
import com.model.User;
import com.model.Recipe;
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
    private static final String RECIPE_VIEW = "recipeView/view.jsp";
    private RecipeDao dao;
    
    public RecipeController() throws ClassNotFoundException {
        super();
        dao = new RecipeDao();
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
                default:
                    RequestDispatcher dispatcher = request.getRequestDispatcher(INDEX);
                    dispatcher.forward(request, response);
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

        User user = (User) session.getAttribute("authenticatedUser");
        if (user == null) {
            // Foward to index.jsp
            RequestDispatcher dispatcher = request.getRequestDispatcher(INDEX);
            dispatcher.forward(request, response);
        }

        try {
            switch (action) {
                case "insert":
                    insertRecipe(request, response);
                    break;
                default:
                    RequestDispatcher dispatcher = request.getRequestDispatcher(INDEX);
                    dispatcher.forward(request, response);
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
        // Get all recipes made by user.
        List<Recipe> recipes = dao.getAllRecipes();
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
    private void viewRecipe(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException {
        // Get selected recipe's info
        int recipeid = Integer.parseInt(request.getParameter("recipeid"));
        Recipe recipe = dao.getRecipeById(recipeid);
        request.setAttribute("selectedRecipe", recipe);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher(RECIPE_VIEW);
        dispatcher.forward(request, response);
    }
    
    private void insertRecipe(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException {
        String title = request.getParameter("title");
        String shortDescription = request.getParameter("short-description");
        String prepTime = request.getParameter("prep-time");
        String cookTime = request.getParameter("cook-time");
        String serving = request.getParameter("serving");
        String ingredients = request.getParameter("ingredients");
        String instructions = request.getParameter("instructions");
        String chefNote = request.getParameter("chef-note");
        Recipe newRecipe = new Recipe(title, shortDescription);
        
        if (dao.addRecipe(newRecipe)) {
            // Get all recipes made by user.
            List<Recipe> recipes = dao.getAllRecipes(); 
            // Add the recipes.
            request.setAttribute("RecipeList", recipes);
            
            request.setAttribute("msg", "Successfully added recipe.");
            RequestDispatcher dispatcher = request.getRequestDispatcher(RECIPE_LIST);
            dispatcher.forward(request, response);
        }
        request.setAttribute("msg", "Error: Unable to add new recipe.");
        RequestDispatcher dispatcher = request.getRequestDispatcher(RECIPE_ADD);
        dispatcher.forward(request, response);
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
