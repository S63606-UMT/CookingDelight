/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.annotation.WebServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDao;
import com.model.User;
import java.sql.SQLException;

/**
 *
 * @author Saiful
 */
@WebServlet("/profile")
public class UserController extends HttpServlet {
    
    private static final String SELF = "profile?action=view";
    private static final String INDEX = "index.jsp";
    private static final String LOGIN = "login.jsp";
    private static final String PROFILE = "profileView/profile.jsp";
    private UserDao dao;
    
    public UserController() throws ClassNotFoundException {
        super();
        dao = new UserDao();
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
            out.println("<title>Servlet UserController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UserController at " + request.getContextPath() + "</h1>");
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
        String redirectURL = "";
        HttpSession session = request.getSession(); // Retrive existing session. 
        String action = request.getParameter("action");
        
        try {
            switch (action) {
                case "delete":
                    deleteUser(request, response);
                    break;
                case "logout":
                    logout(request, response);
                    break;
                default:
                    if ((User) session.getAttribute("authenticatedUser") != null) {
                        // Show Profile
                        RequestDispatcher dispatcher = request.getRequestDispatcher(PROFILE);
                        dispatcher.forward(request, response);
                    } else {
                        // Deny Access and redirect to index page
                        response.sendRedirect(response.encodeRedirectURL(INDEX));
                    }
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
        /*
        else if (action.equalsIgnoreCase("edit")) {
            forward = EDIT;
            String userId = request.getParameter("userId");
            User user = dao.getUserById(userId);
            request.setAttribute("users", user);
        }
        else if (action.equalsIgnoreCase("listUser")) {
            forward = LIST_USER;
            request.setAttribute("users", dao.getAllUsers());
        }
        else if (action.equalsIgnoreCase("insert")) {
            forward = INSERT;
        }
        */
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
        String action = request.getParameter("action");
        HttpSession session = request.getSession(); // Retrive existing session.
        
        try {
            switch(action) {
                case "register":
                    register(request, response);
                    break;
                case "login":
                    login(request, response);
                    break;
                case "editUsername":
                    editUsername(request, response);
                    break;
                case "editEmail":
                    editEmail(request, response);
                    break;
                case "editDateOfBirth":
                    editDob(request, response);
                    break;
                case "editGender":
                    editGender(request, response);
                    break;
                default:
                    if ((User) session.getAttribute("authenticatedUser") != null) {
                        // Show Profile
                        RequestDispatcher dispatcher = request.getRequestDispatcher(PROFILE);
                        dispatcher.forward(request, response);
                    } else {
                        // Deny Access and redirect to index page
                        response.sendRedirect(response.encodeRedirectURL(INDEX));
                    }
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }  
    }
    
    private void register(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException {
        User user = new User();
        LocalDate dob = LocalDate.parse(request.getParameter("dob"));

        user.setUsername(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));
        user.setEmail(request.getParameter("email"));
        user.setDateOfBirth(dob);
        user.setGender(request.getParameter("gender"));
        dao.addUser(user);

        RequestDispatcher dispatcher = request.getRequestDispatcher(LOGIN);
        dispatcher.forward(request, response);
    }
    
    private void login(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException {
        dao.isUser(request.getParameter("username"), request.getParameter("password")); // Authenticate user.
        User user = dao.getUserByUsername(request.getParameter("username")); // Retrieve relevant info of user.
        
        HttpSession session = request.getSession(); //Create a session if there isn't one.
        session.setAttribute("authenticatedUser", user); // Bring the whole user to the next page.
        System.out.println("Session created with user: " + user.getUsername());
        doGet(request, response);
    }
    
    private void editUsername(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException {
        HttpSession session = request.getSession(); // Retrieve current session.
        String newUsername = request.getParameter("username");
        
        // Update the username in the database
        dao.updateUsername((User) session.getAttribute("authenticatedUser"), newUsername);

        // Update session
        User user = dao.getUserByUsername(request.getParameter("username"));
        session.setAttribute("authenticatedUser", user);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher(SELF);
        dispatcher.forward(request, response);
    }
    
    private void editEmail(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException {
        HttpSession session = request.getSession(); // Retrieve current session.
        User user = (User) session.getAttribute("authenticatedUser");
        String email = request.getParameter("email");
        
        // Update the email in the database
        dao.updateEmail(user, email);

        // Update session
        User updatedUser = dao.getUserByUsername(user.getUsername());
        session.setAttribute("authenticatedUser", updatedUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher(SELF);
        dispatcher.forward(request, response);
    }
    
    private void editDob(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException {
        HttpSession session = request.getSession(); // Retrieve current session.
        User user = (User) session.getAttribute("authenticatedUser");
        String dob = request.getParameter("dob");
        
        // Update the dateOfBirth in the database
        dao.updateDob(user, dob);

        // Update session
        User updatedUser = dao.getUserByUsername(user.getUsername());
        session.setAttribute("authenticatedUser", updatedUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher(SELF);
        dispatcher.forward(request, response);
    }
    
    private void editGender(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException {
        HttpSession session = request.getSession(); // Retrieve current session.
        User user = (User) session.getAttribute("authenticatedUser");
        String gender = request.getParameter("gender");
        
        // Update the gender in the database
        dao.updateGender(user, gender);

        // Update session
        User updatedUser = dao.getUserByUsername(user.getUsername());
        session.setAttribute("authenticatedUser", updatedUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher(SELF);
        dispatcher.forward(request, response);
    }
    
    private void deleteUser(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException {
        HttpSession session = request.getSession(); //Retrieve current session.
        User user = (User) session.getAttribute("authenticatedUser");
        dao.deleteUser(user.getUsername());

        session.invalidate(); //Delete session.
        response.sendRedirect(response.encodeRedirectURL(INDEX));
    }
    private void logout(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException {
        HttpSession session = request.getSession(); //Retrieve current session.
        session.invalidate(); //Delete session.
        response.sendRedirect(response.encodeRedirectURL(INDEX));
    }
    /*
    private void template(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("example.jsp");
        dispatcher.forward(request, response);
    }
    */
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
