/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDao;
import com.model.User;
/**
 *
 * @author Saiful
 */
public class UserController extends HttpServlet {
    
    private static final String INDEX = "index.jsp";
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
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")) {
            String username = request.getParameter("username");
            dao.deleteUser(username);
            
            HttpSession session = request.getSession(); //Retrieve current session.
            session.setAttribute("username", request.getParameter("username"));
            redirectURL = INDEX;
        }
        
        if (action.equalsIgnoreCase("logout")) {
            HttpSession session = request.getSession(); //Retrieve current session.
            session.invalidate(); //Delete session.
            redirectURL = INDEX;
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
        response.sendRedirect(response.encodeRedirectURL(redirectURL));
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
        String redirectURL = "";
        String action = request.getParameter("action");
        
        if (action.equalsIgnoreCase("register")) {
            User user = new User();
            LocalDate dob = LocalDate.parse(request.getParameter("dob"));

            user.setUsername(request.getParameter("username"));
            user.setPassword(request.getParameter("password"));;
            user.setEmail(request.getParameter("email"));
            user.setDateOfBirth(dob);
            user.setGender(request.getParameter("gender"));
            dao.addUser(user);
            
            redirectURL = INDEX;
        }

        if (action.equalsIgnoreCase("login")) {
            dao.isUser(request.getParameter("username"), request.getParameter("password")); //
            
            HttpSession session = request.getSession(); //Create a session if there isn't one.
            session.setAttribute("username", request.getParameter("username"));
            redirectURL = PROFILE;
        }
        /*
        if (action.equalsIgnoreCase(("edit"))) {
            //dao.updateUser(user);
        }
        else {
            dao.addUser(user);
        }
        */ 
        response.sendRedirect(response.encodeRedirectURL(redirectURL));
        
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
