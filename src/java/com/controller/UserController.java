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
    
    private static final String INDEX = "index.jsp";
    private static final String LOGIN = "login.jsp";
    private static final String PROFILE = "profileView/profile.jsp";
    private static final String SUCCESS = "profileView/success.jsp";
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
        HttpSession session = request.getSession(false); //Retrieve session
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
                    User user = (User) session.getAttribute("authenticatedUser");
                    if (user != null) {
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
        HttpSession session = request.getSession(false); // Retrive existing session.
        
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
                case "editDob":
                    editDob(request, response);
                    break;
                case "editGender":
                    editGender(request, response);
                    break;
                default:
                    User user = (User) session.getAttribute("authenticatedUser");
                    if (user != null) {
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
        User authenticatedUser = dao.isUser(request.getParameter("username"), request.getParameter("password")); // Authenticate and retrieve relevant info of user.
        if (authenticatedUser != null) {
            HttpSession session = request.getSession(); //Create a session if there isn't one.
            session.setAttribute("authenticatedUser", authenticatedUser); // Bring the whole user to the next page.
            System.out.println("Session created with user: " + authenticatedUser.getUsername());
            RequestDispatcher dispatcher = request.getRequestDispatcher(PROFILE);
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect(response.encodeRedirectURL(LOGIN));
        } 
        
    }
    
    private void editUsername(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException {
        HttpSession session = request.getSession(); // Retrieve current session.
        String newUsername = request.getParameter("username");
        User loggedUser = (User) session.getAttribute("authenticatedUser");
        
        // Update the username in the database
        if (dao.updateUsername(loggedUser, newUsername)) {
            // Update session
            User updatedUser = dao.getUserById(loggedUser.getUserid());
            session.setAttribute("authenticatedUser", updatedUser);
            
            // Set success message
            request.setAttribute("msg", "Successfully updated username.");
            RequestDispatcher dispatcher = request.getRequestDispatcher(SUCCESS);
            dispatcher.forward(request, response);
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher(PROFILE);
            dispatcher.forward(request, response);
        }
    }
    
    private void editEmail(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException {
        HttpSession session = request.getSession(); // Retrieve current session.
        User loggedUser = (User) session.getAttribute("authenticatedUser");
        String email = request.getParameter("email");
        
        // Update the email in the database
        if (dao.updateEmail(loggedUser, email)) {
            // Update session
            User updatedUser = dao.getUserById(loggedUser.getUserid());
            session.setAttribute("authenticatedUser", updatedUser);
            
            // Set success message
            request.setAttribute("msg", "Successfully updated email.");
            RequestDispatcher dispatcher = request.getRequestDispatcher(SUCCESS);
            dispatcher.forward(request, response);
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher(PROFILE);
            dispatcher.forward(request, response);
        }
    }
    
    private void editDob(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException {
        HttpSession session = request.getSession(); // Retrieve current session.
        User loggedUser = (User) session.getAttribute("authenticatedUser");
        String dob = request.getParameter("dob");
        
        // Update the dateOfBirth in the database
        if (dao.updateDob(loggedUser, dob)) {
            // Update session
            User updatedUser = dao.getUserById(loggedUser.getUserid());
            session.setAttribute("authenticatedUser", updatedUser);
            
            // Set success message
            request.setAttribute("msg", "Successfully updated date of birth.");
            RequestDispatcher dispatcher = request.getRequestDispatcher(SUCCESS);
            dispatcher.forward(request, response);
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher(PROFILE);
            dispatcher.forward(request, response);
        }
       
    }
    
    private void editGender(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException {
        HttpSession session = request.getSession(); // Retrieve current session.
        User loggedUser = (User) session.getAttribute("authenticatedUser");
        String gender = request.getParameter("gender");
        
        // Update the gender in the database
        if (dao.updateGender(loggedUser, gender)) {
            // Update session
            User updatedUser = dao.getUserById(loggedUser.getUserid());
            session.setAttribute("authenticatedUser", updatedUser);
            
            // Set success message
            request.setAttribute("msg", "Successfully updated gender.");
            RequestDispatcher dispatcher = request.getRequestDispatcher(SUCCESS);
            dispatcher.forward(request, response);
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher(PROFILE);
            dispatcher.forward(request, response);
        }  
    }
    
    private void deleteUser(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException {
        HttpSession session = request.getSession(); //Retrieve current session.
        User loggedUser = (User) session.getAttribute("authenticatedUser");
        dao.deleteUserById(loggedUser.getUserid());

        session.invalidate(); //Delete session.
        // Set success message
        request.setAttribute("msg", "Successfully deleted your account.");
        response.sendRedirect(response.encodeRedirectURL(INDEX));
    }
    private void logout(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException {
        HttpSession session = request.getSession(); //Retrieve current session.
        session.invalidate(); //Delete session.
        response.sendRedirect(response.encodeRedirectURL(INDEX)); // Redirect to homepage.
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
